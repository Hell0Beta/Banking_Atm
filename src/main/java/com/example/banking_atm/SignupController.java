package com.example.banking_atm;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.io.IOException;

public class SignupController {

    @FXML
    private ProgressBar passwordStrengthBar;

    @FXML
    private Label passwordStrengthLabel;

    @FXML
    private Button signinButton;

    @FXML
    private Button signupButton;

    @FXML
    void handleSignin(ActionEvent event) throws IOException {
        System.out.println("BackToLogin was clicked");
        HelloApplication.closeStageContaining(signinButton);
        HelloApplication.displaypage("Login1.fxml", 603, 474);
    }

    @FXML
    void handleSignup(ActionEvent event) {

    }

}
