module com.example.banking_atm {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires java.desktop;
    requires jdk.jshell;


    opens com.example.banking_atm to javafx.fxml;
    exports com.example.banking_atm;
}