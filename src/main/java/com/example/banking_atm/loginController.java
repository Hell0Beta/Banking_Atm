package com.example.banking_atm;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    void onForgot(MouseEvent event) throws IOException {
        System.out.println("Forgot Clicked, loading `forgot_pin.fxml`");
        HelloApplication.closeStageContaining(forgotpswrdbtn);
        HelloApplication.displaypage("forgot_pin.fxml", 603, 474);
    }

    @FXML
    void onLogin(MouseEvent event) throws IOException {
        var userinfo = username.getText();
        var pass = password.getText();
        if(authenticate(userinfo, pass)){
            System.out.println("Authenticated \n: Loading next page");
            HelloApplication.closeStageContaining(forgotpswrdbtn);
            HelloApplication.displaypage("withdrawal.fxml");
        }
        System.out.println(userinfo);
    }


    @FXML
    void onSignup(MouseEvent event) {
        System.out.printf("SignUp Clicked, loading `Signup_coming_soon.fxml`");
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


}
