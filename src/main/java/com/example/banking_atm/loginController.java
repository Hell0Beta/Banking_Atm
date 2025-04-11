package com.example.banking_atm;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class loginController {

    @FXML
    private Button forgotpswrdbtn;

    @FXML
    private Button login;

    @FXML
    private PasswordField password;

    @FXML
    private Button signup;

    @FXML
    private static TextField username;

    @FXML
    void onForgot(MouseEvent event) throws IOException {
        System.out.println("Forgot Clicked, loading `forgot_pin.fxml`");
        HelloApplication.closeStageContaining(forgotpswrdbtn);
        HelloApplication.displaypage("forgot_pin.fxml", 603, 474);
    }

    @FXML
    void onLogin(MouseEvent event) throws IOException {
        var userinfo = username.getText();
        var pass = password.getText();
        if(authenticate(userinfo, pass)){
            System.out.println("Authenticated \n: Loading Dashboard");
            HelloApplication.closeStageContaining(forgotpswrdbtn);

            String accountNo = model.UserTable.fetchuserKey(userinfo);
            var user = model.UserTable.fetch_a_user(accountNo);
            String email = user.get("email").toString();
            String pin = user.get("PIN").toString();
            UserSession.initSession(accountNo,userinfo, Integer.parseInt(pin), email);

            //HelloApplication.displaypage("dashboard.fxml", 774, 418);
            // Load FXML and get the controller
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Scene scene = new Scene(loader.load());
            // Get the controller and pass the welcome message
            dashboardController controller = loader.getController();
            controller.setWelcomeText("Welcome " + userinfo + "!");

            Map<String, Object> financeData = model.FinancesTable.fetch_a_finance(accountNo);
            String balance = financeData.get("balance").toString();
            System.out.println("Balance: " + balance);

            controller.setBankBalance(balance);
//            controller.setUserid(accountNo);
//            controller.setDebttoIncomeRatio();
//            controller.setTotalvaluedepo();
//            controller.settotalwithdrawn();
//            controller.setemergency();
//            controller.setLblDeposit();
            // Show new stage
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        }
        System.out.println(userinfo);
    }
    public static String getUserinfo(){
        var userinfo = username.getText();
        return userinfo.toString();


    }


    @FXML
    void onSignup(MouseEvent event) throws IOException {
        System.out.printf("SignUp Clicked, loading `Signup.fxml`");
        HelloApplication.closeStageContaining(forgotpswrdbtn);
        HelloApplication.displaypage("signup.fxml", 703, 614);
    }


    private static boolean authenticate(String userinfo, String pass) throws IOException {
        if(model.UserTable.nameExists(userinfo)){
            var key = model.UserTable.fetchuserKey(userinfo);
            var user = model.UserTable.fetch_a_user(key);
            return user.get("PIN").equals(pass);
        }
        return false;
    }


}
