package com.example.instagram;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        LoginController.showLoginPage();
    }

    public static void main(String[] args) throws IOException {
        launch();
    }
}