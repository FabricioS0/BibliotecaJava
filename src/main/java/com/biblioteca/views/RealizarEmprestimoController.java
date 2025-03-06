package com.biblioteca.views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class RealizarEmprestimoController {

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
}