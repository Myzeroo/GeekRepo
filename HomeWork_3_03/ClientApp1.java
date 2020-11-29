package HomeWork_3_03;

import java.io.*;
import java.net.Socket;

public class ClientApp1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8899);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        String message = in.readUTF();
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    throw new RuntimeException("SWW", e);
                }
            }).start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("-auth для авторизации");
            while (true) {
                try {
                    out.writeUTF(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException("SWW", e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

