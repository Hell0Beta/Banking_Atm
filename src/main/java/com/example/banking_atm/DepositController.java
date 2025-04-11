package com.example.banking_atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class DepositController {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnDeposit;

    @FXML
    private TextField txtDepositAmount;

    @FXML
    private TextField txtPin;

    @FXML
    void onCancel(ActionEvent event) {

    }

    @FXML
    void onDeposit(ActionEvent event) throws IOException {

        String userinfo = loginController.getUserinfo();

        String accountNo = model.UserTable.fetchuserKey(userinfo);
        var user = model.UserTable.fetch_a_user(accountNo);
        String email = user.get("email").toString();
        String pin = user.get("PIN").toString();
        UserSession.initSession(accountNo,userinfo, Integer.parseInt(pin), email);
        model.FinancesTable.deposit(accountNo,(int) Double.parseDouble(txtDepositAmount.getText()));

    }



}
