package HomeWork_2_06;

import org.w3c.dom.ls.LSOutput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
    public static void main(String[] args) {
        new MyServer();
    }

    private ServerSocket srvSocket;
    private Socket clntSocket;
    private DataOutputStream out;
    private DataInputStream in;

    public MyServer() {
        try {
            srvSocket = new ServerSocket(8899);
            System.out.println("Сервер ожидает соединения с клиентом.");
            clntSocket = srvSocket.accept();
            System.out.println("Соединение с клиентом установлено.");
            out = new DataOutputStream(clntSocket.getOutputStream());
            in = new DataInputStream(clntSocket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread outThread = new Thread(() -> {
            try {
                while (true) {
                    String outgoingMessage = new Scanner(System.in).nextLine();
                    out.writeUTF(outgoingMessage);
                    if (outgoingMessage.equals("--exit")) {
                        System.out.println("закрытие соединения с клиентом...");
                        break;
                    }
                    System.out.println("Server: " + outgoingMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        outThread.setDaemon(true);
        outThread.start();

        try {
            while (true) {
                String incomingMessage = in.readUTF();
                if (incomingMessage.equals("--exit")) {
                    System.out.println("соединение превано со стороны клиента");
                    break;
                }
                System.out.println("Client: " + incomingMessage);
            }
        } catch (IOException e) {
            System.out.println("соединение с клиентом прервано");
        }
    }
}
