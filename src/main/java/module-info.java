module com.biblioteca {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.biblioteca to javafx.fxml;
    opens com.biblioteca.Controller to javafx.fxml;

    exports com.biblioteca;
    exports com.biblioteca.Controller;
}
