package chatApp;
import chatApp.UI.LoginView;

import chatApp.server.Server;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Scanner;

public class Main extends Application {
    public static void main(String[] args) {
//        Server runningServer = new Server();
//
//        System.out.println("Enter 0 to run server! or 1 to open the chat app! ");
//       //one main method for both server and client interface
//        if(new Scanner(System.in).nextLine().equals("0")){
//            //runs sever and waits forever listening
//            runningServer.run();
//        }else {
//            //this opens a client interface UI that helps him send messages
            launch(args);
//        }
    }

    public void start(Stage stage) {

        LoginView loginView = new LoginView(stage);

        Scene scene = new Scene(loginView, 400, 300);

        stage.setScene(scene);
        stage.setTitle("Chat Application");

        stage.show();
    }
}
