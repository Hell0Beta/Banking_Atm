package com.example.banking_atm;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Resetpin {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}