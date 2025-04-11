package com.example.banking_atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class dashboardController {
//    @FXML
//    public static java.awt.Label txtWelcome;
    @FXML
    private Button btnDeposit;

    void setLblDeposit() throws IOException {
        var finance = model.FinancesTable.fetch_a_finance(userid.getText());
        ArrayList deposit = (ArrayList) finance.get("deposit");
        String last_deposit = String.valueOf(deposit.get(deposit.size()-1));
        lblDeposit.setText(last_deposit);
    }


    public void setemergency() throws IOException {
        var finance = model.FinancesTable.fetch_a_finance(userid.getText());
        String balance = (String) finance.get("balance");
        int newbalance = (int) (Integer.parseInt(balance) * 0.2);
        emergencyfund.setText(String.valueOf(newbalance));
    }

    @FXML
    private Button btnViewFinances;

    @FXML
    private Button btnWithdraw;

    @FXML
    private ImageView btndashboardHome;

    @FXML
    private ImageView btnimgLogout;

    @FXML
    private ImageView btnimgViewFinances;

    @FXML
    private Label emergencyfund;

    @FXML
    private Label lblBalance;

    @FXML
    private Label lblDebtToIncomeRatio;

    @FXML
    private Label lblDeposit;

    @FXML
    private Text lblEmergencyfund;

    @FXML
    private Label lblWithdrawal;

    @FXML
    private Label lbltotalvaluedeposited;

    @FXML
    private Text txtWelcome;

    @FXML
    private Label userid;


    @FXML
    void Logout(MouseEvent event) {



    }

    @FXML
    void onDeposit(ActionEvent event) throws IOException {
        HelloApplication.closeStageContaining(btnDeposit);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("withdrawal.fxml"));
        Scene scene = new Scene(loader.load());
        WithdrawalController controller = loader.getController();
        controller.setUserid(userid.getText());
        // Show new stage
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onViewFinances(MouseEvent event) {

    }

    @FXML
    void onWithdraw(ActionEvent event) throws IOException {
        HelloApplication.closeStageContaining(btnDeposit);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("withdrawal.fxml"));
        Scene scene = new Scene(loader.load());
        WithdrawalController controller = loader.getController();
        controller.setUserid(userid.getText());

        // Show new stage
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void openDashboard(MouseEvent event) {

    }

    public void setWelcomeText(String text) {
        txtWelcome.setText(text);
    }

    public void setBankBalance(String balance) {
        lblBalance.setText(balance);
    }

    void setUserid(String id){
        userid.setText(id);
    }

    void setDebttoIncomeRatio() throws IOException {
        var finance = model.FinancesTable.fetch_a_finance(userid.getText());
        ArrayList deposits = (ArrayList) finance.get("deposit");
        ArrayList withdrawals = (ArrayList) finance.get("withdrawals");
        int deposum = totalvaluedeposited(deposits);
        int withsum = totalvaluewithdrawn(withdrawals);

        float ratio = Float.parseFloat(String.valueOf(deposum))/withsum;
        lblDebtToIncomeRatio.setText(String.valueOf(ratio));
    }

    private static int totalvaluewithdrawn(ArrayList withdrawals) {
        int withsum = 0;
//        for sum in with
        for (int i = 0; i < withdrawals.size(); i++) {
            withsum += (int) withdrawals.get(i);

        }
        return withsum;
    }

    void setTotalvaluedepo() throws IOException {
        var finance = model.FinancesTable.fetch_a_finance(userid.getText());
        ArrayList depo = (ArrayList) finance.get("deposit");
        lbltotalvaluedeposited.setText(String.valueOf(totalvaluedeposited(depo)));
    }
    private static int totalvaluedeposited(ArrayList deposits) {
        int deposum = 0;
//        sum of deposits
        for (int i = 0; i < deposits.size(); i++) {
            deposum += (int) deposits.get(i);
        }
        return deposum;
    }

    void settotalwithdrawn() throws IOException {
        var finance = model.FinancesTable.fetch_a_finance(userid.getText());
        ArrayList with = (ArrayList) finance.get("withdrawals");
        lblWithdrawal.setText(String.valueOf(totalvaluewithdrawn(with)));
    }


}
