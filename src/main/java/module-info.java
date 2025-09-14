module lk.acpt.library {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.jdi;


    opens lk.acpt.library to javafx.fxml;
    exports lk.acpt.library;
    exports lk.acpt.library.controller;
    opens lk.acpt.library.controller to javafx.fxml;
    exports lk.acpt.library.dto;
    opens lk.acpt.library.dto to javafx.fxml;
}