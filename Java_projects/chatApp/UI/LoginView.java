package chatApp.UI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView extends VBox {


    private final Stage stage;

    public LoginView(Stage stage) {
        this.stage = stage;


        setSpacing(15);
        setAlignment(Pos.CENTER);

        Label title = new Label("ChatApp");

        Label userName = new Label("User Name");
        TextField userNameText = new TextField();

        Label password = new Label("Password");
        PasswordField passwordText = new PasswordField();

        Button login = new Button("Sign in");
        Button signUp = new Button("Sign up");
        login.setOnAction(e -> {

            String username = userNameText.getText();

            ChatView chatView = new ChatView();

            Scene scene = new Scene(chatView, 600, 400);

            stage.setScene(scene);


        });
        signUp.setOnAction(e -> {


            ChatView chatView = new ChatView();

            Scene scene = new Scene(chatView, 600, 400);

            stage.setScene(scene);
        });

        GridPane grid = new GridPane();

        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(userName, 0, 0);
        grid.add(userNameText, 1, 0);

        grid.add(password, 0, 1);
        grid.add(passwordText, 1, 1);

        HBox hBox = new HBox(10);

        hBox.getChildren().addAll(login, signUp);

        grid.add(hBox, 1, 2);

        getChildren().addAll(title, grid);
    }
}