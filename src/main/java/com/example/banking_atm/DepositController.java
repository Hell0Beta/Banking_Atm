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

public class DepositController {

    @FXML
    private Label username;

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

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login1.fxml"));
        loader.load();
        var controller = loader.getController();

        var userinfo = username.getText();
        String accountNo = model.UserTable.fetchuserKey(userinfo);
        System.out.println(":omdeep::::::::::" + accountNo + ":::::::: " + userinfo);
        var user = model.UserTable.fetch_a_user(accountNo);
        String email = user.get("email").toString();
        String pin = user.get("PIN").toString();
        UserSession.initSession(accountNo,userinfo, Integer.parseInt(pin), email);
        model.FinancesTable.deposit(accountNo,(int) Double.parseDouble(txtDepositAmount.getText()));



        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("dashboard.fxml"));
        Scene scene = new Scene(loader2.load());
        dashboardController controller2 = loader2.getController();
        controller2.setUserName(userinfo);
        var accountno1 = model.UserTable.fetchuserKey(userinfo);
//        var userinfo1 = username.getText();
//        String accountNo1 = model.UserTable.fetchuserKey(userinfo);
//        System.out.println(":::::::::::" + accountNo1 + ":::::::: " + userinfo1);
        Map<String, Object> financeData = model.FinancesTable.fetch_a_finance(accountno1);
        String balance = financeData.get("balance").toString();

        controller2.setBankBalance(balance);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        HelloApplication.closeStageContaining(btnCancel);
    }

    void setusername(String usernameofuser) {
        username.setText(usernameofuser);
    }

}




