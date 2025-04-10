package com.example.banking_atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Resetpin {

    @FXML
    private Hyperlink backtologin;

    @FXML
    private TextField pin;

    @FXML
    private TextField pin0;

    @FXML
    private Button resetpinbtn;

    @FXML
    void onBacktoLogin(ActionEvent event) throws IOException {
        System.out.println("Backtologin clicked");
        HelloApplication.closeStageContaining(resetpinbtn);
        HelloApplication.displaypage("Login1.fxml", 774, 418);
    }

    @FXML
    void onReset(ActionEvent event) {
        System.out.println("Reset pin called");
//        model.UserTable.changePin(account_no, pin.getText());
    }

}
