package com.example.banking_atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    private Button btnWithdraw;

    @FXML
    private Button btnWithdraw1;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private PasswordField pinField;

    @FXML
    private PasswordField pinField1;

    @FXML
    void onCancel(ActionEvent event) {

    }

    @FXML
    void onWithdraw(ActionEvent event) {
        int amount = Integer.valueOf(amountField1.getText());
        model.FinancesTable.
    }

}
