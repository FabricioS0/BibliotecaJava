package com.biblioteca;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class MenuController {

    @FXML
    private Label printName;

    @FXML
    void GerenAutor(ActionEvent event) {

    }

    @FXML
    void GerenLeirores(ActionEvent event) {

    }

    @FXML
    void GerenLivro(ActionEvent event) {

    }

    @FXML
    void VizuEstatisticas(ActionEvent event) {

    }

    @FXML
    void historicoEmprestimo(ActionEvent event) {

    }

    @FXML
    void realizarDevolucao(ActionEvent event) {

    }

    @FXML
    void realizarEmprestimo(ActionEvent event) {

    }

    @FXML
    void printName(String username) {
        printName.setText("Bem vindo(a) " + username + "!");
    }
}
