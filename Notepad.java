package notepad;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.util.Optional;

public class Notepad {


    // global static variables

    static boolean isSaved = true;
    static File currentFile = null;

    //     =========================
//     MAIN APP ENTRY
//     =========================
    public static void notePad(Stage stage)
    {

        // UI ROOT
        BorderPane root = new BorderPane();

        // =========================
        // MENU BAR
        // =========================
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");

        MenuItem newMenuItem = new MenuItem("_New");
        MenuItem openMenuItem = new MenuItem("_Open");
        MenuItem saveMenuItem = new MenuItem("_Save");
        MenuItem saveAsMenuItem = new MenuItem("_Save As");
        MenuItem exitMenuItem = new MenuItem("Exit");

        fileMenu.getItems().addAll(
                newMenuItem,
                openMenuItem,
                saveMenuItem,
                saveAsMenuItem,
                exitMenuItem
        );

        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);


        // TEXT AREA

        TextArea writingSpace = new TextArea();
        writingSpace.setWrapText(true);

        //tracking  any change with in the editor
        writingSpace.textProperty().addListener((obs, oldText, newText) -> {
            isSaved = false;
            updateTitle(stage);
        });


        // MENU ACTIONS

        newMenuItem.setOnAction(e -> {
            if (confirmUnsavedChanges()) {
                newFile(stage, writingSpace);
            }
        });

        openMenuItem.setOnAction(e -> {
            if (confirmUnsavedChanges()) {
                open(stage, writingSpace);
            }
        });

        saveMenuItem.setOnAction(e -> save(stage, writingSpace));

        saveAsMenuItem.setOnAction(e -> saveAs(stage, writingSpace));

        exitMenuItem.setOnAction(e -> exit(stage, writingSpace));

        // =========================
        // LAYOUT
        // =========================
        root.setTop(menuBar);
        root.setCenter(writingSpace);

        // =========================
        // SHORTCUT KEYS
        // =========================
        KeyCombination saveKey = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);
        KeyCombination openKey = new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN);
        KeyCombination newKey  = new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN);

        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);

        scene.setOnKeyPressed(event -> {

            if (saveKey.match(event)) {
                save(stage, writingSpace);
            }

            if (openKey.match(event)) {
                openMenuItem.fire();
            }

            if (newKey.match(event)) {
                newMenuItem.fire();
            }
        });

        updateTitle(stage);
        stage.show();
    }


    // FILE OPERATIONS

    private static void open(Stage stage, TextArea writingSpace) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
        );

        File file = fileChooser.showOpenDialog(stage);

        updateTitle(stage);

        if (file != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

                StringBuilder builder = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    builder.append(line).append("\n");
                }

                writingSpace.setText(builder.toString());
                currentFile = file;
                isSaved = true;

                updateTitle(stage);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void save(Stage stage, TextArea textArea) {

        if (currentFile == null) {
            saveAs(stage, textArea);
            return;
        }

        writeToFile(currentFile, textArea);
        updateTitle(stage);
    }

    private static void saveAs(Stage stage, TextArea textArea) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save As");

        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            currentFile = file;
            writeToFile(file, textArea);
            updateTitle(stage);

        }
    }

    private static void writeToFile(File file, TextArea textArea) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(textArea.getText());
            isSaved = true;
        } catch (IOException e) {
            System.out.println("Save error: " + e.getMessage());
        }
    }

    // =========================
    // NEW FILE
    // =========================

    private static void newFile(Stage stage, TextArea writingSpace) {
        writingSpace.clear();
        currentFile = null;
        isSaved = true;
        updateTitle(stage);
    }

    // =========================
    // EXIT LOGIC
    // =========================

    private static void exit(Stage stage, TextArea textArea) {

        if (!confirm("Are you sure you want to exit?")) {
            return;
        }

        if (confirmUnsavedChanges()) {
            save(stage, textArea);
        }

        stage.close();
    }


    // DIALOGS

    static boolean confirm(String message) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();

        return result.isPresent() && result.get() == ButtonType.OK;
    }

    private static boolean confirmUnsavedChanges() {
        return isSaved || confirm("You have unsaved changes. Continue?");
    }

    // UI HELPERS

    private static void updateTitle(Stage stage) {

        String name = (currentFile == null) ? "Untitled": currentFile.getName();

        if (!isSaved) {
            name += " *";
        }

        stage.setTitle("Notepad - " + name);
    }
}

