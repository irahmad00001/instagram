package com.example.instagram;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    private Button button1HV;

    @FXML
    private Button button2HV;

    @FXML
    private Button button3HV;

    @FXML
    private Button button4HV;

    @FXML
    private Button button5HV1;

    @FXML
    private ImageView imageViewHV;

    @FXML
    private HBox mainHBox;

    @FXML
    private RadioButton radioButton1HV;

    @FXML
    private RadioButton radioButton2HV;

    @FXML
    private ScrollPane scrollPaneV;

    @FXML
    private Text textHV;

    @FXML
    private VBox vboxH;

    @FXML
    private VBox vboxHS;

    private static FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainPage.fxml"));
    private static Scene scene;

    static {
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void setTextHV(String text) {
        textHV.setText(text);
    }
    private static Stage stage = new Stage();

    public static void showMainPage(){
        stage.setTitle("این اولین نمونه است.");
        stage.setScene(scene);
        stage.show();
    }

    public void button4HVEvent() throws IOException {
        NewPostPageController.showLoginPage();
    }

    public void button5HV1Event() throws IOException {
        ArrayList<Message> messageArrayList = Database.getMessage();
        Collections.reverse(messageArrayList);
        vboxHS.getChildren().clear();
        for (int i = 0; i < messageArrayList.size(); i++) {
            Message temp = messageArrayList.get(i);
            vboxHS.getChildren().add(temp.getvBox());
        }
    }


    public void button1HVEvent() throws IOException {
        System.exit(0);
    }






    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textHV.setText(User.getName());
        ArrayList<Message> messageArrayList = Database.getMessage();
        Collections.reverse(messageArrayList);
        for (int i = 0; i < messageArrayList.size(); i++) {
            Message temp = messageArrayList.get(i);
            vboxHS.getChildren().add(temp.getvBox());
        }

    }
}

