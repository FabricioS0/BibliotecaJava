package com.biblioteca.views;

import com.biblioteca.model.User;
import com.biblioteca.service.UserService;
import com.biblioteca.views.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private UserService userService = new UserService();

    @FXML
    public void FazerLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            User user = userService.getAllUsers().stream()
                    .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                    .findFirst()
                    .orElse(null);

            if (user != null) {
                // Login bem-sucedido, carregue a tela MenuBiblioteca
                loadMenuBiblioteca(user);
            } else {
                // Exibir mensagem de erro
                System.out.println("Credenciais inválidas!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadMenuBiblioteca(User user) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/path/to/MenuBiblioteca.fxml"));
            Parent root = loader.load();

            // Passar o usuário para o MenuController
            MenuController menuController = loader.getController();
            menuController.setUser (user); // Método que você deve implementar no MenuController

            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.ESC) {
            // Lógica para voltar à tela anterior
            // Exemplo: voltarParaTelaAnterior();
        }
    }
}