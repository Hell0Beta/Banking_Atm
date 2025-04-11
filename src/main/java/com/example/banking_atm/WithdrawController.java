package com.example.banking_atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class WithdrawController {

    @FXML
    private Button btnCancel;
    @FXML
    private Label username;
    @FXML
    private Button btnWithdraw;

    @FXML
    private TextField txtAmountToWithdraw;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtPin;

    @FXML
    void onCancel(ActionEvent event) {
        HelloApplication.closeStageContaining(btnCancel);
    }

    @FXML
    void onWithdraw(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login1.fxml"));

        var controller = loader.getController();

        var userinfo = username.getText();
        String accountNo = model.UserTable.fetchuserKey(userinfo);
        System.out.println("onwith:::::::::::" + accountNo + ":::::::: " + userinfo);
        var user = model.UserTable.fetch_a_user(accountNo);
        String email = user.get("email").toString();
        String pin = user.get("PIN").toString();
        UserSession.initSession(accountNo,userinfo, Integer.parseInt(pin), email);
        model.FinancesTable.withdraw(accountNo,(int) Double.parseDouble(txtAmountToWithdraw.getText()));

        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("dashboard.fxml"));
        Scene scene = new Scene(loader2.load());
        dashboardController controller2 = loader2.getController();
        controller2.setUserName(userinfo);
        var account_no1 = model.UserTable.fetchuserKey(userinfo);
        var financeData = model.FinancesTable.fetch_a_finance(account_no1);
        String balance = financeData.get("balance").toString();
        controller2.setBankBalance(balance);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        HelloApplication.closeStageContaining(btnCancel);




    }

    void setUsername(String usernameofuser) {
        username.setText(usernameofuser);
    }
}
