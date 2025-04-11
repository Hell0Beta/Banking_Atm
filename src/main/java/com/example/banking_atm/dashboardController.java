package com.example.banking_atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
    private ImageView btnChangePin;

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
    void Logout(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login1.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();

        Stage logoutStage = (Stage) btnimgLogout.getScene().getWindow();
        logoutStage.close();



    }

    @FXML
    void onDeposit(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("deposit.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 431, 291);

        Stage stage = new Stage();
        stage.setTitle("Deposit");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void onChangePin(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("changePin.fxml"));
        Scene scene  = new Scene(fxmlLoader.load());

        Stage stage = new Stage();
        stage.setTitle("Transaction Logs");
        stage.setScene(scene);
        stage.show();

        Stage closePage = (Stage) btnimgViewFinances.getScene().getWindow();
        closePage.close();

    }

    @FXML
    void onViewFinances(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("transactionlogs.fxml"));
        Scene scene  = new Scene(fxmlLoader.load());

        Stage stage = new Stage();
        stage.setTitle("Transaction Logs");
        stage.setScene(scene);
        stage.show();

        Stage closePage = (Stage) btnimgViewFinances.getScene().getWindow();
        closePage.close();

    }

    @FXML
    void onWithdraw(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("withdraw.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 492, 396);

        Stage stage = new Stage();
        stage.setTitle("Withdraw");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void openDashboard(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.show();

        Stage closePage = (Stage) btndashboardHome.getScene().getWindow();
        closePage.close();

    }

    public void setWelcomeText(String text) {
        txtWelcome.setText(text);
    }

    public void setBankBalance(String balance) {
        lblBalance.setText(balance);
    }
}
