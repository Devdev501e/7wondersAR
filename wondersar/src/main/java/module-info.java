module com.example.wonders {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens com.example.wonders to javafx.fxml;
    exports com.example.wonders;
}