module com.example.projectrestpin {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projectrestpin to javafx.fxml;
    exports com.example.projectrestpin;
}