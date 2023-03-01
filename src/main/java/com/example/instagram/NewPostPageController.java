package com.example.instagram;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class NewPostPageController {
    @FXML
    private VBox Vbox;
    @FXML
    private Button sendBUT;
    @FXML
    private TextArea textArea;

    private static FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("newPostPage.fxml"));
    private static Scene scene;

    static {
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static Stage stage = new Stage();
    public void sendBUTEvent(ActionEvent e) throws IOException {
        Message message = new Message(textArea.getText() ,"0","",User.getUsername());
        Database.addMessage(message);
        exitLoginPage();
    }


    public static void showLoginPage() throws IOException {
        stage.setTitle("پست جدید");
        stage.setScene(scene);
        stage.show();
    }
    public static void exitLoginPage() throws IOException{
        stage.close();
    }


}

