package com.biblioteca.views;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RealizarEmprestimoController {
    @FXML
    private Label printName; // Label para exibir o nome do usuário

    @FXML
    private TextField pessoaField;
    @FXML
    private TextField livroField;
    @FXML
    private DatePicker dataEmprestimoPicker;
    @FXML
    private DatePicker dataDevolucaoPicker;
    @FXML
    private Button RealizarEmprestimo;

    @FXML
    public void handleRealizarEmprestimo() {
        String pessoa = pessoaField.getText();
        String livro = livroField.getText();
        // Lógica para realizar o empréstimo
    }

    @FXML
    public void handleBack() {
        loadScene("/com/biblioteca/MenuBiblioteca.fxml");
    }

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