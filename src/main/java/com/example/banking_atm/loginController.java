package com.example.banking_atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginController {

    @FXML
    private Button forgotpswrdbtn;

    @FXML
    private Button login;

    @FXML
    private PasswordField password;

    @FXML
    private Button signup;

    @FXML
    private TextField username;

    @FXML
    void onForgot(ActionEvent event) {

    }

    @FXML
    void onLogin(ActionEvent event) {
        System.out.println("lplp");
    }

    @FXML
    void onSignup(ActionEvent event) {

    }

}
