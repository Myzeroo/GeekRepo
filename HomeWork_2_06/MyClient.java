package HomeWork_2_06;

import HomeWork_2_04.SortTreeMap.MyComparator;

import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        new MyClient();
    }

    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;

    public MyClient() {
        try {
            clientSocket = new Socket("127.0.0.1", 8899);
            System.out.println("Соединение с сервером устанвлено.");
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread outThread = new Thread(() -> {
            try {
                while (true) {
                    String outgoingMessage = new Scanner(System.in).nextLine();
                    out.writeUTF(outgoingMessage);
                    if (outgoingMessage.equals("--exit")) {
                        System.out.println("закрытие соединения с сервером...");
                        break;
                    }
                    System.out.println("Client: " + outgoingMessage);
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
                    System.out.println("соединение превано со стороны сервера");
                    break;
                }
                System.out.println("Server: " + incomingMessage);
            }
        } catch (IOException e) {
            System.out.println("соединение с сервером прервано");
        }
    }
}
