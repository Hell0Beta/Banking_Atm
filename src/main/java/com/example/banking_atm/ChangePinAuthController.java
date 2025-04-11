package com.example.banking_atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangePinAuthController {

    @FXML
    private ImageView btnChangePin;

    @FXML
    private Button btnChangePinAuth;

    @FXML
    private ImageView btndashboardHome;

    @FXML
    private ImageView btnimgLogout;

    @FXML
    private ImageView btnimgViewFinances;

    @FXML
    private TextField txtEmailorPhone;

    @FXML
    private Text txtWelcome;

    @FXML
    void Logout(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();

        Stage logoutStage = (Stage) btnimgLogout.getScene().getWindow();
        logoutStage.close();

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
    void onChangePinAuthentication(ActionEvent event) throws IOException {
        if(model.UserTable.dataUserExists("email", txtEmailorPhone.getText())){
            System.out.println("Email exists");
            System.out.println("Reset Clicked, loading `ResetComingSoon.fxml`");
            HelloApplication.closeStageContaining(btnChangePinAuth);
            HelloApplication.displaypage("ChangePin.fxml", 774, 418);
        }else {
            System.out.println("kokokpk;");
        }

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

}
