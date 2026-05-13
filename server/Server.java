package chatApp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    //a list of clients
    private static final List<ClientHandler> clients = new ArrayList<>();

    public void run() {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            System.out.println("Server started...");

            while (true) {

                Socket socket = serverSocket.accept();

                System.out.println("New client connected: "
                        + socket.getInetAddress() + ":" + socket.getPort());

                ClientHandler clientHandler = new ClientHandler(socket);
                clients.add(clientHandler);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // broadcast to all clients
    public static void broadcast(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }
}