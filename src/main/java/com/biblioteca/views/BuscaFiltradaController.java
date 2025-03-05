package com.biblioteca.views;

import javafx.fxml.FXML;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class BuscaFiltradaController {

    @FXML
    private TextField txtSearch;
    @FXML
    private SplitMenuButton categoryFilter;

    @FXML
    public void handleSearch() {
        String searchText = txtSearch.getText();
        // Lógica para buscar com base nos filtros
    }

    @FXML
    public void handleKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.ESC) {
            // Lógica para voltar à tela anterior
            // Exemplo: voltarParaTelaAnterior();
        }
    }
}