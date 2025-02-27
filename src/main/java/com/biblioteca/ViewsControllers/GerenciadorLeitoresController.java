package com.biblioteca.ViewsControllers;

import com.biblioteca.dao.PersonDAO;
import com.biblioteca.dto.PersonDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class GerenciadorLeitoresController {

    @FXML
    private Button btnAdicionarLeitores;

    @FXML
    private TableColumn<PersonDTO, String> colNome;

    @FXML
    private TableColumn<PersonDTO, String> colCPF;

    @FXML
    private TableColumn<PersonDTO, String> colAniversario;

    @FXML
    private TableColumn<PersonDTO, String> colAcoes;

    @FXML
    private TableView<PersonDTO> tableLeitores;

    private PersonDAO personDAO;

    public GerenciadorLeitoresController() {
        personDAO = new PersonDAO();
    }

    // Método para abrir a tela de cadastro
    @FXML
    void adicionarLeitores(ActionEvent event) {
        try {
            // Aqui você abriria a tela de cadastro de leitores.
            // Suponho que você tenha uma janela de cadastro (FXML).
            // Isso pode ser feito usando o FXMLLoader para carregar a tela de cadastro.

            // Exemplo de como abrir a tela de cadastro:
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/biblioteca/CadastroLeitor.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.setTitle("Cadastro de Leitores");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Erro", "Erro ao abrir a tela de cadastro.", AlertType.ERROR);
        }
    }

    // Método para carregar os dados dos leitores na tabela
    public void carregarTabelaLeitores() {
        try {
            // Pega a lista de leitores do banco de dados
            var leitores = personDAO.getAllPersons();

            // Preenche a tabela com os dados
            tableLeitores.getItems().clear();
            tableLeitores.getItems().addAll(leitores);

            // Configura as colunas da tabela
            colNome.setCellValueFactory(new PropertyValueFactory<>("name"));
            colCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
            colAniversario.setCellValueFactory(new PropertyValueFactory<>("birthday"));
            // Aqui você pode adicionar uma coluna de ações com botões para editar ou excluir leitores

        } catch (SQLException e) {
            showAlert("Erro", "Erro ao carregar os leitores.", AlertType.ERROR);
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

    // Método chamado após a tela de cadastro para atualizar a tabela
    public void atualizarTabela() {
        carregarTabelaLeitores();
    }

    @FXML
    public void initialize() {
        carregarTabelaLeitores(); // Carregar leitores ao iniciar a tela
    }
}
