package com.example.banking_atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class WithdrawalController {

    @FXML
    private TextField amountField;

    @FXML
    private TextField amountField1;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnCancel1;

    @FXML
    private Button btnDeposit;

    @FXML
    private Button btnWithdraw;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private PasswordField pinField;

    @FXML
    private PasswordField pinField1;

    @FXML
    private Label userid;

    @FXML
    void onCancel(ActionEvent event) {

    }

    @FXML
    void onDeposit(ActionEvent event) throws IOException {
        model.FinancesTable.deposit(userid.getText(), Integer.parseInt(amountField1.getText()));
    }

    @FXML
    void onWithdraw(ActionEvent event) throws IOException {
        model.FinancesTable.withdraw(userid.getText(), Integer.parseInt(amountField.getText()));
    }

    void setUserid(String id){
        userid.setText(id);
    }
}
