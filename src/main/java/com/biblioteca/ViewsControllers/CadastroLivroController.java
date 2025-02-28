package com.biblioteca.ViewsControllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import com.biblioteca.dao.BookDAO;
import com.biblioteca.database.DatabaseConnection;
import com.biblioteca.dto.BookDTO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CadastroLivroController {

    @FXML
    private TextField campoTitulo;
    @FXML
    private TextArea campoDescricao;
    @FXML
    private TextField campoEdicao;
    @FXML
    private TextField campoDataPublicacao;
    @FXML
    private TextField campoISBN;
    @FXML
    private Button btnSalvarLivro;

    private void salvarLivro() {
        String titulo = campoTitulo.getText();
        String descricao = campoDescricao.getText();
        java.util.Date dataPublicacao = LocalDate.parse(campoDataPublicacao.getText());
        String edicao = campoEdicao.getText();
        String isbn = campoISBN.getText();

        BookDTO book = new BookDTO(0, titulo, descricao, edicao, dataPublicacao, isbn);

        try {
            BookDAO bookDAO = new BookDAO(); // Agora sem parâmetro
            boolean sucesso = bookDAO.addBook(book);
            if (sucesso) {
                exibirAlerta("Sucesso", "Livro cadastrado com sucesso!");
                limparCampos();
            } else {
                exibirAlerta("Erro", "Falha ao cadastrar o livro.");
            }
        } catch (SQLException e) {
            exibirAlerta("Erro", "Ocorreu um erro ao cadastrar o livro: " + e.getMessage());
            e.printStackTrace();
        }

    }

    private void limparCampos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'limparCampos'");
    }

    private void exibirAlerta(String string, String string2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exibirAlerta'");
    }
}
