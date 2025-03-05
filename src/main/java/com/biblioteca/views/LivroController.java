package com.biblioteca.views;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class LivroController {

    @FXML
    private Text NomeLivro;
    @FXML
    private Text NameAutor;
    @FXML
    private Text AnoLivro;
    @FXML
    private Text Editora;

    // Método para preencher os detalhes do livro
    public void setBookDetails(String nome, String autor, String ano, String editora) {
        NomeLivro.setText(nome);
        NameAutor.setText(autor);
        AnoLivro.setText(ano);
        Editora.setText(editora);
    }

    @FXML
    public void handleKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.ESC) {
            // Lógica para voltar à tela anterior
            // Exemplo: voltarParaTelaAnterior();
        }
    }
}