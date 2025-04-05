package com.example.banking_atm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    void onLogin(MouseEvent event) throws IOException {
        var userinfo = username.getText();
        var pass = password.getText();
        if(authenticate(userinfo, pass)){
            System.out.println("Authenticated \n: Loading next page");
        }
        System.out.println(userinfo);
    }

    private static boolean authenticate(String userinfo, String pass) throws IOException {
        if(test.nameExists(userinfo)){
            var key = test.fetchuserKey(userinfo);
            var user = test.fetch_a_user(key);
            if(user.get("PIN").equals(pass)){
                return true;
            }
        }
        return false;
    }


    @FXML
    void onSignup(MouseEvent event) {
        System.out.printf("lppl");
    }

}
