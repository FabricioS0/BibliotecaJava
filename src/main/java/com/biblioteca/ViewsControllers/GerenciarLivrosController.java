package com.biblioteca.ViewsControllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.biblioteca.dao.BookDAO;
import com.biblioteca.database.DatabaseConnection;
import com.biblioteca.dto.BookDTO;
import com.biblioteca.model.Book;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class GerenciarLivrosController {

    @FXML private TableView<BookDTO> tabelaLivros;
    @FXML private TableColumn<BookDTO, String> colTitulo;
    @FXML private TableColumn<BookDTO, String> colDescricao;
    @FXML private TableColumn<BookDTO, String> colEdicao;
    @FXML private TableColumn<BookDTO, String> colDataPublicacao;
    @FXML private TableColumn<BookDTO, String> colISBN;

    private ObservableList<BookDTO> listaLivros = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("title"));
        colDescricao.setCellValueFactory(new PropertyValueFactory<>("description"));
        colEdicao.setCellValueFactory(new PropertyValueFactory<>("edition"));
        colDataPublicacao.setCellValueFactory(new PropertyValueFactory<>("publicationDate"));
        colISBN.setCellValueFactory(new PropertyValueFactory<>("isbn"));

        carregarLivros();
    }

    private void carregarLivros() {
        Connection conexao = DatabaseConnection.getConnection();
        if (conexao != null) {
            BookDAO bookDAO = new BookDAO(conexao);
            List<Book> livros = bookDAO.getAllBooks(); // Método que deve ser criado no DAO
            listaLivros.getAllBooks(livros);
            tabelaLivros.setItems(listaLivros);
        }
    }

    @FXML
    void abrirTelaCadastroLivro(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/biblioteca/CadastroLivro.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Cadastro de Livro");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
