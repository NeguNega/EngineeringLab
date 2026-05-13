package chatApp;

import chatApp.UI.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    static void main(String[] args) {

        //this opens a client interface UI that helps him send messages
        launch(args);

    }

    public void start(Stage stage) {

        LoginView loginView = new LoginView(stage);

        Scene scene = new Scene(loginView, 400, 300);

        stage.setScene(scene);
        stage.setTitle("Chat Application");

        stage.show();
    }
}
