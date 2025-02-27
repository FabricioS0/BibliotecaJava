package com.biblioteca.ViewsControllers;

import com.biblioteca.dao.PersonDAO;
import com.biblioteca.dto.PersonDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class cadastroLeitorController {

    @FXML
    private Button btnSalvarLeitor;

    @FXML
    private TextField campoAniversario;

    @FXML
    private TextField campoCPF;

    @FXML
    private TextField campoNome;

    // Método que será chamado ao clicar no botão "SALVAR"
    @FXML
    void salvarLeitor(ActionEvent event) {
        // Captura os dados dos campos de texto
        String nome = campoNome.getText();
        String cpf = campoCPF.getText();
        String aniversario = campoAniversario.getText();

        // Verifica se todos os campos estão preenchidos
        if (nome.isEmpty() || cpf.isEmpty() || aniversario.isEmpty()) {
            showAlert("Erro", "Todos os campos devem ser preenchidos!", AlertType.ERROR);
            return;
        }

        // Criação do DTO com os dados coletados
        PersonDTO personDTO = new PersonDTO();
        personDTO.setName(nome);
        personDTO.setCpf(cpf);
        personDTO.setBirthday(aniversario);

        // Salvar no banco de dados
        try {
            PersonDAO personDAO = new PersonDAO();
            PersonDAO.addPerson(personDTO);  // Chama o método para salvar no banco
            showAlert("Sucesso", "Leitor cadastrado com sucesso!", AlertType.INFORMATION);
            limparCampos(); // Limpa os campos após o cadastro
        } catch (SQLException e) {
            showAlert("Erro", "Erro ao salvar no banco de dados: " + e.getMessage(), AlertType.ERROR);
        }
    }

    // Método para exibir alertas
    private void showAlert(String title, String message, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Limpar os campos após o cadastro
    private void limparCampos() {
        campoNome.clear();
        campoCPF.clear();
        campoAniversario.clear();
    }
}
