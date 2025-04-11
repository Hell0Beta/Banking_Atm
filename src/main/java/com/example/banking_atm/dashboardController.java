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

public class dashboardController {
//    @FXML
//    public static java.awt.Label txtWelcome;
    @FXML
    private Button btnDeposit;

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
    private Label lblBalance;

    @FXML
    private Label lblDebtToIncomeRatio;

    @FXML
    private Text lblEmergencyfund;

    @FXML
    private Text lblTotalValueDeposited;

    @FXML
    private Label lblWithdrawal;

    @FXML
    private Text txtWelcome;

    @FXML
    void Logout(MouseEvent event) {



    }

    @FXML
    void onDeposit(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("deposit.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 431, 291);

        Stage stage = new Stage();
        stage.setTitle("Deposit");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void onViewFinances(MouseEvent event) {

    }

    @FXML
    void onWithdraw(ActionEvent event) throws IOException {
        HelloApplication.closeStageContaining(btnDeposit);
        HelloApplication.displaypage("withdrawal.fxml", 603, 474);

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
}
