package com.example.instagram;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupPageController {
    private static Stage stage = new Stage();
    private static FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("signupPage.fxml"));
    private static Scene scene;

    static {
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    private TextField nameFLD;

    @FXML
    private Text passTXT;

    @FXML
    private TextField userFLD;

    @FXML
    private Text userTXT;

    @FXML
    private Button loginBUT;

    @FXML
    private Text nameTXT;

    @FXML
    private PasswordField passFLD;

    @FXML
    private PasswordField reppassFLD;

    @FXML
    private Text reppassTXT;

    @FXML
    private Button signupBUT;

    @FXML
    private VBox vboxSignup;

    @FXML
    private Text welecomeTXT;

    @FXML
    private Text errorTXT;
    public void loginBUTEvent(ActionEvent e) throws IOException {
        exitSignupPage();
        LoginController.showLoginPage();
    }

    public static void showSignupPage() throws IOException {
        stage.setTitle("صفحه ثبت نام");
        stage.setScene(scene);
        stage.show();
    }
    public static void exitSignupPage() throws IOException {
        stage.close();
    }

    public void signupBUTEvent(ActionEvent e) throws IOException {
        String nameFLD = this.nameFLD.getText();
        String passFLD = this.passFLD.getText();
        String reppassFLD = this.reppassFLD.getText();
        String userFLD = this.userFLD.getText();
        if(passFLD.equals("") || reppassFLD.equals("") || userFLD.equals("") || nameFLD.equals("") ){
            errorTXT.setText("لطفا فیلد ها را پر کنید.");
            errorTXT.setVisible(true);
        }else{
            Database.AddUser(userFLD,passFLD,nameFLD);
            exitSignupPage();
           LoginController.showLoginPage();
        }
    }

    public void userFLDEvent(){
        userFLD.textProperty().addListener((observable, oldValue, newValue) -> {
            if(Database.checkUsername(newValue)){
                errorTXT.setText("این نام کاربری مجاز است.");
                errorTXT.setFill(Color.GREEN);
                errorTXT.setVisible(true);
                signupBUT.setDisable(false);
            }else{
                errorTXT.setText("این نام کاربری مجاز نمی باشد.");
                errorTXT.setFill(Color.RED);
                errorTXT.setVisible(true);
                signupBUT.setDisable(true);
            }
        });
    }

}
