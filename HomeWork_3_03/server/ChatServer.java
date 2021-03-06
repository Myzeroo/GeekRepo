package HomeWork_3_03.server;

import HomeWork_3_02.auth.AuthenticationService;
import HomeWork_3_02.auth.BasicAuthenticationService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer implements Server {
    private Set<ClientHandler> clients;
    private AuthenticationService authenticationService;


    public ChatServer() {
        try {
            System.out.println("Server is starting up...");
            ServerSocket serverSocket = new ServerSocket(8899);
            clients = new HashSet<>();
            authenticationService = new BasicAuthenticationService();
            System.out.println("Server is started up...");

            while (true) {
                System.out.println("Server is listening for clients...");
                Socket socket = serverSocket.accept();
                System.out.println("Client accepted: " + socket);
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }

    @Override
    public synchronized void broadcastMessage(String message) {

        if (message.startsWith("/w")) {
            String[] splitMessage = message.split("\\s");
            String nickName = splitMessage[1];
            String msg = message.substring(4 + nickName.length());
            for (ClientHandler client : clients) {
                if (client.getName().equals(nickName)) {
                    client.sendMessage(msg);
                }
            }
            return;
        }
        clients.forEach(client -> client.sendMessage(message));
    }

    @Override
    public synchronized boolean isLoggedIn(String nickname) {

        System.out.println();
        return clients.stream()
                .filter(clientHandler -> clientHandler.getName().equals(nickname))
                .findFirst()
                .isPresent();
    }

    @Override
    public synchronized void subscribe(ClientHandler client) {
        clients.add(client);
    }

    @Override
    public synchronized void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    @Override
    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }
}
