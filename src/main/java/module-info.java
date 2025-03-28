module com.example.banking_atm {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.banking_atm to javafx.fxml;
    exports com.example.banking_atm;
}