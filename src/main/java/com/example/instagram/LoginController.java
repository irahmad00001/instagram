package com.example.instagram;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {


    @FXML
    private Button loginBUT;

    @FXML
    private PasswordField passFLD;

    @FXML
    private Text passTXT;

    @FXML
    private CheckBox rememberCKB;

    @FXML
    private VBox root;

    @FXML
    private Button signupBUT;

    @FXML
    private TextField usernameFLD;

    @FXML
    private Text usernameTXT;

    @FXML
    private Text welcomeTXT;

    @FXML
    private Text errorTXT;
    private static FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginPage.fxml"));
    private static Scene scene;

    static {
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Stage stage = new Stage();




    public void loginEvent(ActionEvent e) throws IOException {
        if(usernameFLD.getText().equals("") || passFLD.getText().equals("")) {
            errorTXT.setText("لطفا فیلد ها را پر کنید.");
            errorTXT.setVisible(true);
        }else{
            if (Database.checkAccount(usernameFLD.getText(), passFLD.getText())) {
                errorTXT.setVisible(false);
                Database.setInfo(usernameFLD.getText(), passFLD.getText());
                exitLoginPage();
                MainPageController.showMainPage();
            } else {
                errorTXT.setVisible(true);
            }
        }
    }


    public void signupEvent(ActionEvent e) throws IOException {
        stage.close();
        SignupPageController.showSignupPage();
    }


    public static void showLoginPage() throws IOException {
        stage.setTitle("صفحه ورود");
        stage.setScene(scene);
        stage.show();
    }
    public static void exitLoginPage() throws IOException{
        stage.close();
    }


}
