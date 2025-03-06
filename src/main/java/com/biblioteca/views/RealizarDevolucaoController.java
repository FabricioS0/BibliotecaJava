package com.biblioteca.views;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

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