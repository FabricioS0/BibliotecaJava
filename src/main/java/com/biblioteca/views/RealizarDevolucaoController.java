package com.biblioteca.views;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class RealizarDevolucaoController {

    @FXML
    private TextField txtSearchPerson;
    @FXML
    private ListView<String> listLoans;
    @FXML
    private Label lblLateDays;
    @FXML
    private Label lblInitialFine;
    @FXML
    private Label lblDailyFine;
    @FXML
    private Label lblTotalFine;
    @FXML
    private CheckBox chkConfirmPayment;

    @FXML
    public void searchPersonLoans() {
        String personName = txtSearchPerson.getText();
        // Lógica para buscar empréstimos da pessoa
    }

    @FXML
    public void processReturn() {
        // Lógica para processar a devolução
    }

    @FXML
    public void handleKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.ESC) {
            // Lógica para voltar à tela anterior
            // Exemplo: voltarParaTelaAnterior();
        }
    }
}