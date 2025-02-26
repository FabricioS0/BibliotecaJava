module com.biblioteca {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;

    // Permite que o JavaFX acesse as classes dentro do pacote
    opens com.biblioteca.ViewsControllers to javafx.fxml;
    // opens com.biblioteca to javafx.fxml;
    opens com.biblioteca.dto to javafx.fxml; // Se você estiver usando DTOs em FXML
    opens com.biblioteca.model to javafx.fxml; // Se você estiver usando modelos em FXML
    opens com.biblioteca.dao to javafx.fxml; // Se você estiver usando DAOs em FXML
    opens com.biblioteca.utils to javafx.fxml; // Se você estiver usando utilitários em FXML

    // Exporta os pacotes para que possam ser usados por outros módulos
    exports com.biblioteca;
    exports com.biblioteca.ViewsControllers;
    exports com.biblioteca.dto; // Se você estiver usando DTOs em outros módulos
    exports com.biblioteca.model; // Se você estiver usando modelos em outros módulos
    exports com.biblioteca.dao; // Se você estiver usando DAOs em outros módulos
    exports com.biblioteca.utils; // Se você estiver usando utilitários em outros módulos
}