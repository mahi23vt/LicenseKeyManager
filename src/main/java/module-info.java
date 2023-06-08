module com.example.licensekey {
    requires javafx.controls;
    requires javafx.fxml;
    requires opencsv;


    opens com.example.licensekey to javafx.fxml;
    exports com.example.licensekey;
}