package com.example.banking_atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangePinController {

    @FXML
    private ImageView btnChangePin;

    @FXML
    private Button btnChangeUserPin;

    @FXML
    private Button btnReset;

    @FXML
    private ImageView btndashboardHome;

    @FXML
    private ImageView btnimgLogout;

    @FXML
    private ImageView btnimgViewFinances;

    @FXML
    private TextField txtConfirmNewPin;

    @FXML
    private TextField txtNewPin;

    @FXML
    private Text txtWelcome;

    //@FXML
//    void onChangeUserPin(ActionEvent event) {
//        String newPin = txtNewPin.getText();
//        String confirmNewPin = txtConfirmNewPin.getText();
//
//        if(newPin == null || confirmNewPin == null || confirmNewPin.isEmpty()) {
//            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter a new pin number");
//            alert.showAndWait();
//            return;
//        }
//
//        if(!newPin.equals(confirmNewPin)) {
//            Alert alert = new Alert(Alert.AlertType.ERROR, "New PIN does not match Confirm PIN");
//            alert.showAndWait();
//            return;
//        }
//        if(newPin.length() < 4) {
//            Alert alert = new Alert(Alert.AlertType.WARNING, "New PIN must have at least 4 digits");
//        }
//
//        try {
//            UserSession session = UserSession.initSession();
//
//
//            String accountNo = session.getAccountNo();
//
//            boolean updated = model.UserTable.changePin(accountNo, newPin);
//
//            if (updated) {
//                session.setPin(Integer.parseInt(newPin)); // Update session
//                Alert alert = new Alert(Alert.AlertType.INFORMATION, "PIN updated successfully!");
//                alert.show();
//            } else {
//                Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to update PIN.");
//                alert.show();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            Alert alert = new Alert(Alert.AlertType.ERROR, "An error occurred while updating the PIN.");
//            alert.show();
//        }
//
//
//
//
//    }

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
