package com.biblioteca.ViewsControllers;

import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
        String dataPublicacao = dataPublicacao.getText();
        String edicao = campoEdicao.getText();
        String isbn = campoISBN.getText();

        BookDTO book = new BookDTO(0, titulo, descricao, edicao, dataPublicacao, isbn);

        Connection conexao = DatabaseConnection.getConnection();
        if (conexao != null) {
            BookDAO bookDAO = new BookDAO(conexao);
            boolean sucesso = bookDAO.addBook(Book book);
            if (sucesso) {
                exibirAlerta("Sucesso", "Livro cadastrado com sucesso!");
                limparCampos();
            } else {
                exibirAlerta("Erro", "Falha ao cadastrar o livro.");
            }
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
