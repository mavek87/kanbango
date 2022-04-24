module com.matteoveroni.kanbango {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires com.google.gson;
    opens com.matteoveroni.kanbango to
            javafx.base,
            javafx.graphics,
            javafx.controls,
            javafx.web;
    opens com.matteoveroni.kanbango.javafx to javafx.fxml;
    opens com.matteoveroni.kanbango.domain to com.google.gson;
}