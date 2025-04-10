package com.example.banking_atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ForgotPin {

    @FXML
    private Button btnReset;

    @FXML
    private Hyperlink lnkBackToLogin;

    @FXML
    private TextField txtEmailorPhone;

//    backtologin
    @FXML
    void onLogin(ActionEvent event) throws IOException {
        System.out.println("Backtologin Clicked, loading `Login1.fxml`");
        HelloApplication.closeStageContaining(btnReset);
        HelloApplication.displaypage("Login1.fxml", 603, 474);
    }

    @FXML
    void onReset(ActionEvent event) throws IOException {

        if(model.UserTable.dataUserExists("email", txtEmailorPhone.getText())){
            System.out.println("Email exists");
            System.out.println("Reset Clicked, loading `ResetComingSoon.fxml`");
            HelloApplication.closeStageContaining(btnReset);
            HelloApplication.displaypage("restpin.fxml", 603, 474);
        }else {
            System.out.println("kokokpk;");
        }
    }

}
