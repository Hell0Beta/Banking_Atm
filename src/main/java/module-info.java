module com.example.banking_atm {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.example.banking_atm to javafx.fxml;
    exports com.example.banking_atm;
}