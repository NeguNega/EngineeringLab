package chatApp.client;

import java.io.*;
import java.net.Socket;

public class Client {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public Client(String host, int port) {

        try {

            socket = new Socket(host, port);

            reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            writer = new PrintWriter(socket.getOutputStream(), true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // send message to server
    public void sendMessage(String message) {
        writer.println(message);
    }

    // receive messages from server
    public void startListening(MessageListener listener) {

        new Thread(() -> {

            String msg;

            try {
                while ((msg = reader.readLine()) != null) {
                    listener.onMessage(msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
    }

    public interface MessageListener {
        void onMessage(String message);
    }
}