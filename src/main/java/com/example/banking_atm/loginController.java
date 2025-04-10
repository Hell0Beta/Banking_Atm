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
            System.out.println("Authenticated \n: Loading Dashboard");
            HelloApplication.closeStageContaining(forgotpswrdbtn);
//            Map<String, Object> user = JSONDatabase.fetchuserKey(userinfo);
            String accountNo = user.get("account_no").toString();
            String email = user.get("email").toString();
            String pin = user.get("PIN").toString();
            UserSession.initSession(accountNo,userinfo, Integer.parseInt(pin), email);


            HelloApplication.displaypage("dashboard.fxml", 774, 418);

        }
        System.out.println(userinfo);
    }


    @FXML
    void onSignup(MouseEvent event) throws IOException {
        System.out.printf("SignUp Clicked, loading `Signup.fxml`");
        HelloApplication.closeStageContaining(forgotpswrdbtn);
        HelloApplication.displaypage("signup.fxml", 603, 614);
    }


    private static boolean authenticate(String userinfo, String pass) throws IOException {
        if(model.UserTable.nameExists(userinfo)){
            var key = model.UserTable.fetchuserKey(userinfo);
            var user = model.UserTable.fetch_a_user(key);
            return user.get("PIN").equals(pass);
        }
        return false;
    }


}
