package com.biblioteca.views;

import com.biblioteca.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {

    @FXML
    private Label printName; // Label para exibir o nome do usuário

    @FXML
    private Button btnEmprestimos;
    @FXML
    private Button btnHistorico;
    @FXML
    private Button btnDevolucao;
    @FXML
    private Button btnGerenciarLeitores;
    @FXML
    private Button btnGerenciarLivros;
    @FXML
    private Button btnGerenciarAutores;
    @FXML
    private Button btnEstatisticas;

    private User user;

    public void setUser (User user) {
        this.user = user;
        if (printName != null) {
            printName.setText("Bem-vindo(a), " + user.getName() + "!");
        }
    }

    @FXML
    public void initialize() {
        // You can keep this if you want to set action handlers programmatically
        // But since we are using FXML to define them, it's not necessary
    }

    @FXML
    public void handleEmprestimos() {
        // definir previousScene para poder voltar
        loadScene("/com/biblioteca/RealizarEmprestimo.fxml");
        
    }

    @FXML
    public void handleHistorico() {
        loadScene("/com/biblioteca/HistoricoEmprestimos.fxml");
    }

    @FXML
    public void handleDevolucao() {
        loadScene("/com/biblioteca/RealizarDevolucao.fxml");
    }

    @FXML
    public void handleGerenciarLeitores() {
        loadScene("/com/biblioteca/GerenciadorLeitores.fxml");
    }

    @FXML
    public void handleGerenciarLivros() {
        loadScene("/com/biblioteca/GerenciadorLivros.fxml");
    }

    @FXML
    public void handleGerenciarAutores() {
        loadScene("/com/biblioteca/GerenciadorAutores.fxml");
    }

    @FXML
    public void handleEstatisticas() {
        loadScene("/com/biblioteca/VisualizarEstatisticas.fxml");
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