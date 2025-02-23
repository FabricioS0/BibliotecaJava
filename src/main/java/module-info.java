module com.biblioteca {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;

    opens com.biblioteca to javafx.fxml;
    opens com.biblioteca.ViewsControllers to javafx.fxml;

    exports com.biblioteca;
    exports com.biblioteca.ViewsControllers;
}
