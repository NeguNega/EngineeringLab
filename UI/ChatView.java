package chatApp.UI;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ChatView extends BorderPane {

    TextArea chatArea;
    TextField messageField;
    Button sendButton;
    ListView<String> userList;

    public ChatView() {

        // CENTER: chat messages
        chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setWrapText(true);

        setCenter(chatArea);

        // LEFT: online users panel
        userList = new ListView<>();
        userList.setPrefWidth(150);

        // fake data for now
        userList.getItems().addAll(
                "Negasi",
                "John",
                "Alice",
                "Bob"
        );

        setLeft(userList);

        // BOTTOM: input area
        messageField = new TextField();
        messageField.setPromptText("Type message...");

        sendButton = new Button("Send");


        HBox bottomBar = new HBox(10);
        bottomBar.setPadding(new Insets(10));

        HBox.setHgrow(messageField, Priority.ALWAYS);

        bottomBar.getChildren().addAll(messageField, sendButton);

        setBottom(bottomBar);

        sendButton.setOnAction(e -> {

            String message = messageField.getText();

            if (message.isEmpty()) return;

            chatArea.appendText("Me: " + message + "\n");

            messageField.clear();
        });
        // for pressing Enter
        messageField.setOnAction(e -> sendButton.fire());
    }
}