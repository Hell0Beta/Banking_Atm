package com.example.banking_atm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
    void onForgot(MouseEvent event) {
        System.out.println("lolo");
    }

    @FXML
    void onLogin(MouseEvent event) {
        System.out.println("llp");
    }

    @FXML
    void onSignup(MouseEvent event) {
        System.out.printf("lppl");
    }

}
