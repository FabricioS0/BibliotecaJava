package com.biblioteca.views;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class GerenciadorLivrosController {

    @FXML
    private TableView<?> tableViewLivros; // Substitua o tipo genérico pelo tipo correto
    @FXML
    private Button btnAdicionarLivros;

    @FXML
    public void adicionarLivros() {
        // Lógica para adicionar livros
    }

    @FXML
    public void handleBack() {
        loadScene("/com/biblioteca/MenuBiblioteca.fxml");
    }

    @FXML
    private Label printName;
    
    private void loadScene(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = (Stage) printName.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}