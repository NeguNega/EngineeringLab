package chatApp.UI;

import chatApp.client.Client;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ChatView extends BorderPane {


    Client client;
    TextArea chatArea;
    TextField messageField;
    Button sendButton;
    ListView<String> userList;

    public ChatView() {

        // CENTER FIRST
        chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setWrapText(true);
        setCenter(chatArea);

        // LEFT
        userList = new ListView<>();
        userList.setPrefWidth(150);
        userList.getItems().addAll("Negasi", "John", "Alice", "Bob");
        setLeft(userList);

        // BOTTOM
        messageField = new TextField();
        sendButton = new Button("Send");

        HBox bottomBar = new HBox(10);
        bottomBar.setPadding(new Insets(10));
        bottomBar.setSpacing(10);
        HBox.setHgrow(messageField, Priority.ALWAYS);
        bottomBar.getChildren().addAll(messageField, sendButton);

        setBottom(bottomBar);

        // NOW NETWORKING (AFTER UI EXISTS)
        client = new Client("localhost", 5000);

        client.startListening(message -> {
            javafx.application.Platform.runLater(() -> {
                chatArea.appendText(message + "\n");
            });
        });

        // SEND
        sendButton.setOnAction(e -> {

            String message = messageField.getText().trim();
            if (message.isEmpty()) return;

            client.sendMessage("Me: " + message);

            messageField.clear();
        });

        messageField.setOnAction(e -> sendButton.fire());
    }
}