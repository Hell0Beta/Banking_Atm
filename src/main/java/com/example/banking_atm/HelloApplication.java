package com.example.banking_atm;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

// Now our code has been push to git lets push to github
public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 603, 474);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void displaypage(String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load(), 1240, 720);
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void displaypage(String fxmlFile, int x, int y) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load(), x, y);
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void closeStageContaining(Button button) {
        Stage currentstage = (Stage) button.getScene().getWindow();
        currentstage.close();
    }

    public static void main(String[] args) {
        launch();
    }
}