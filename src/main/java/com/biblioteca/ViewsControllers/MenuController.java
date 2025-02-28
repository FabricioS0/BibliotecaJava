package com.biblioteca.ViewsControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class MenuController {
    @FXML
    private Label printName;

    @FXML
    void GerenAutor(ActionEvent event) {
        abrirTela("/com/biblioteca/gerenciar_autores.fxml");
    }

    @FXML
    void GerenLeitores(ActionEvent event) {
        abrirTela("/com/biblioteca/gerenciar_leitores.fxml");
    }

    @FXML
    void GerenLivro(ActionEvent event) {
        abrirTela("/com/biblioteca/GerenciadorLivros.fxml");
    }

    @FXML
    void VizuEstatisticas(ActionEvent event) {
        abrirTela("/com/biblioteca/visualizar_estatisticas.fxml");
    }

    @FXML
    void historicoEmprestimo(ActionEvent event) {
        abrirTela("/com/biblioteca/historico_emprestimos.fxml");
    }

    @FXML
    void realizarDevolucao(ActionEvent event) {
        abrirTela("/com/biblioteca/RealizarDevolucao.fxml");
    }

    @FXML
    void realizarEmprestimo(ActionEvent event) {
        abrirTela("/com/biblioteca/RealizarEmprestimo.fxml");
    }

    private void abrirTela(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = (Stage) printName.getScene().getWindow(); // Supondo que você tenha um Label chamado printName
            stage.setScene(new Scene(root));
            stage.setTitle("Gerenciador de Biblioteca");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}