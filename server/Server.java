package chatApp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void run() {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            System.out.println("Server started...");

            while (true) {

                Socket socket = serverSocket.accept();

                System.out.println("New client connected: " + socket.getInetAddress() + ":" + socket.getPort());

                //creating a thread for each new client
                ClientHandler clientHandler = new ClientHandler(socket);

                Thread thread = new Thread(clientHandler);

                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}