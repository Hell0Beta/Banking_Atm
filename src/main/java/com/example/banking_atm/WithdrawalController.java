package com.example.banking_atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

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

    @FXML
    void onHome(MouseEvent event) throws IOException {
        // Load FXML and get the controller
        HelloApplication.closeStageContaining(btnCancel);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
        Scene scene = new Scene(loader.load());
        // Get the controller and pass the welcome message
        dashboardController controller = loader.getController();


        Map<String, Object> financeData = model.FinancesTable.fetch_a_finance(userid.getText());
        String balance = financeData.get("balance").toString();
        System.out.println("Balance: " + balance);

        controller.setBankBalance(balance);
//        controller.setUserid(userid.getText());
//        controller.setDebttoIncomeRatio();
//        controller.setTotalvaluedepo();
//        controller.settotalwithdrawn();
//        controller.setemergency();
//        controller.setLblDeposit();
        // Show new stage
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void backtologin(MouseEvent event) throws IOException {
        HelloApplication.closeStageContaining(btnCancel);
        HelloApplication.displaypage("Login1.fxml", 603, 474);
    }


    void setUserid(String id){
        userid.setText(id);
    }
}
