package com.biblioteca.views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CadastroLeitorController {

    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoCPF;
    @FXML
    private TextField campoAniversario;
    @FXML
    private Button btnSalvarLeitor;

    @FXML
    public void salvarLeitor() {
        String nome = campoNome.getText();
        String cpf = campoCPF.getText();
        String aniversario = campoAniversario.getText();
        // Lógica para salvar o leitor
    }

    @FXML
    public void handleKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.ESC) {
            // Lógica para voltar à tela anterior
            // Exemplo: voltarParaTelaAnterior();
        }
    }
}