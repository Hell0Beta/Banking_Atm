package com.example.banking_atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class SignupController {

    @FXML
    private TextField confin;

    @FXML
    private Label info;

    @FXML
    private TextField email;

    @FXML
    private TextField fullname;

    @FXML
    private TextField pin;

    @FXML
    private Button signinButton;

    @FXML
    private Button signupButton;

    @FXML
    void handleSignin(ActionEvent event) throws IOException {
        System.out.println("Back to login");
        HelloApplication.closeStageContaining(signinButton);
        HelloApplication.displaypage("Login1.fxml", 603, 474);
    }

    @FXML
    void handleSignup(ActionEvent event) throws IOException {
        String name = fullname.getText();
        String emailaddress = email.getText();
        String pass = pin.getText();
        String pass0 = confin.getText();

        if (pass0.equals(pass)){
            if(!model.UserTable.nameExists(name)){
                model.UserTable.create_a_user(name, pass, emailaddress);
                model.FinancesTable.create_a_finance(model.UserTable.fetchuserKey(name));
                System.out.println("sending to dashboard");
                HelloApplication.closeStageContaining(signinButton);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
                Scene scene = new Scene(loader.load());
                // Get the controller and pass the welcome message
                dashboardController controller = loader.getController();


                Map<String, Object> financeData = model.FinancesTable.fetch_a_finance(model.UserTable.fetchuserKey(name));
                String balance = financeData.get("balance").toString();
                System.out.println("Balance: " + balance);

                controller.setBankBalance(balance);
//                controller.setUserid(model.UserTable.fetchuserKey(name));
//                controller.setDebttoIncomeRatio();
//                controller.setTotalvaluedepo();
//                controller.settotalwithdrawn();
//                controller.setemergency();
//                controller.setLblDeposit();
                // Show new stage
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();

            }
            else{
                info.setText("User Already Exists");
            }
        }else {
            info.setText("Passwords dont match");
        }

    }

}
