module com.biblioteca {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.biblioteca to javafx.fxml;
    exports com.biblioteca;
}
