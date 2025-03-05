package com.biblioteca.views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CadastroLivroController {

    @FXML
    private TextField campoTitulo;
    @FXML
    private TextField autor;
    @FXML
    private TextField campoEdicao;
    @FXML
    private TextField campoDataPublicacao;
    @FXML
    private TextField campoISBN;
    @FXML
    private TextArea campoDescricao;
    @FXML
    private Button salvarLivro;

    @FXML
    public void salvarLivro() {
        String titulo = campoTitulo.getText();
        String autorNome = autor.getText();
        String edicao = campoEdicao.getText();
        String dataPublicacao = campoDataPublicacao.getText();
        String isbn = campoISBN.getText();
        String descricao = campoDescricao.getText();
        // Lógica para salvar o livro
    }

    @FXML
    public void handleKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.ESC) {
            // Lógica para voltar à tela anterior
            // Exemplo: voltarParaTelaAnterior();
        }
    }
}