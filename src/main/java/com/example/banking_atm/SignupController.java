package com.example.banking_atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.io.IOException;

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
                System.out.println("sending to dashboard");
                HelloApplication.closeStageContaining(signinButton);
                HelloApplication.displaypage("dashboard.fxml", 774, 418);
            }
            else{
                info.setText("User Already Exists");
            }
        }

    }

}
