package HomeWork_3_03.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String name;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            TimerTask ttask = new TimerTask() {
                @Override
                public void run() {
                    if (name == null) {
                        sendMessage("Истекло время для авторизации");
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            Timer timer = new Timer();
            timer.schedule(ttask, 1200000);

            doListen();

        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }

    public String getName() {
        return name;
    }

    private void doListen() {
        new Thread(() -> {
            try {
                doAuth();
                receiveMessage();
            } catch (Exception e) {
                throw new RuntimeException("SWW", e);
            } finally {
                server.unsubscribe(this);
            }
        }).start();
    }


    private void doAuth() {
        try {
            while (socket.isConnected()) {
                String credentials = in.readUTF();

                if (credentials.startsWith("-auth")) {
                    String[] credentialValues = credentials.split("\\s");
                    server.getAuthenticationService()
                            .doAuth(credentialValues[1], credentialValues[2])
                            .ifPresentOrElse(
                                    user -> {
                                        if (!server.isLoggedIn(user.getNickname())) {
                                            sendMessage("cmd auth: Status OK");
                                            name = user.getNickname();
                                            server.broadcastMessage(name + " is logged in.");
                                            server.subscribe(this);
                                        } else {
                                            sendMessage("Current user is already logged in.");
                                        }
                                    },
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            sendMessage("No a such user by email and password.");
                                        }
                                    }
                            );
                    if (server.isLoggedIn(name)) {
                        return;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }

    private void receiveMessage() {
        try {
            while (true) {
                String message = in.readUTF();
                if (message.equals("-exit")) {
                    return;
                } else if (message.startsWith("-changeName")) {
                    sendMessage("Имя " + name);
                    changeNickname(message.split("\\s")[1]);
                    sendMessage("было изменено на " + name);
                } else {
                    server.broadcastMessage(message);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }

    public boolean changeNickname(String newName) {
        int id;
        String sqlSelect = "SELECT * FROM users WHERE nickname = ?";
        String sqlUpdate = "UPDATE users SET nickname = ? WHERE id = ?";


        try (Connection connection = DBConnection.getConnection();) {
            PreparedStatement statement = connection.prepareStatement(sqlSelect);

            statement.setNString(1, name);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            id = resultSet.getInt("id");

            statement = connection.prepareStatement(sqlUpdate);
            statement.setNString(1, newName);
            statement.setInt(2, id);
            statement.executeUpdate();

            statement = connection.prepareStatement(sqlSelect);
            statement.setNString(1, newName);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                name = newName;
                return true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientHandler that = (ClientHandler) o;
        return Objects.equals(server, that.server) &&
                Objects.equals(socket, that.socket) &&
                Objects.equals(in, that.in) &&
                Objects.equals(out, that.out) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(server, socket, in, out, name);
    }
}
