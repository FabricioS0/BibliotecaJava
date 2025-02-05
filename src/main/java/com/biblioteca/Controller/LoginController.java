package com.biblioteca.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void FazerLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Por favor, preencha todos os campos.");
            return;
        }

        if (username.equals("admin") && password.equals("12345")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/biblioteca/MenuBiblioteca.fxml"));
                Parent root = loader.load();

                // MenuController menuController = loader.getController();
                // menuController.printName(username); // Chame o novo método

                Stage stage = (Stage) usernameField.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Usuario e senha invalido!");
        }
    }

}
