package com.example.banking_atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;

public class dashboardController {

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
        HelloApplication.closeStageContaining(btnDeposit);
        HelloApplication.displaypage("withdrawal.fxml", 603, 474);
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

}
