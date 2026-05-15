package chatApp.server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public ClientHandler(Socket socket) {

        try {
            this.socket = socket;

            reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            writer = new PrintWriter(socket.getOutputStream(), true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        String message;

        try {

            while ((message = reader.readLine()) != null) {

                System.out.println("Received: " + message);

                Server.broadcast(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        writer.println(message);
    }
}