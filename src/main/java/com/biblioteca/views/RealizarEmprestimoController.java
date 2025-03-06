package com.biblioteca.views;

import com.biblioteca.controller.BookController;
import com.biblioteca.controller.CopyController;
import com.biblioteca.controller.PersonController;
import com.biblioteca.controller.LoanController;
import com.biblioteca.model.Book;
import com.biblioteca.model.Copy;
import com.biblioteca.model.Loan;
import com.biblioteca.model.Person;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue; 
import java.util.Date;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.Scene;

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
    private Button Emprestimo;
    @FXML
    private Button Voltar;
    @FXML
    private Button PesquisaLivro;
    @FXML
    private Button PesquisaPessoa;
    @FXML
    private ListView<Person> ListaPessoas;
    @FXML
    private ListView<Book> ListaLivros;

    private PersonController personController = new PersonController();
    private BookController bookController = new BookController();
    private CopyController copyController = new CopyController();
    private LoanController loanController = new LoanController();

    @FXML
    public void initialize() {
        // Configurar ListView para exibir apenas nome e cpf
        ListaPessoas.setCellFactory(new Callback<ListView<Person>, ListCell<Person>>() {
            @Override
            public ListCell<Person> call(ListView<Person> param) {
                return new ListCell<Person>() {
                    @Override
                    protected void updateItem(Person item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                        } else {
                            setText(item.getName() + " - " + item.getCpf());
                        }
                    }
                };
            }
        });

        // Configurar ListView para exibir apenas nome, autor e isbn
        ListaLivros.setCellFactory(new Callback<ListView<Book>, ListCell<Book>>() {
            @Override
            public ListCell<Book> call(ListView<Book> param) {
                return new ListCell<Book>() {
                    @Override
                    protected void updateItem(Book item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                        } else {
                            setText(item.getTitle() + " - ISBN: " + item.getIsbn());
                        }
                    }
                };
            }
        });

        // Configurar ação do botão Voltar
        Voltar.setOnAction(event -> handleVoltar());
        Emprestimo.setOnAction(event -> handleEmprestimo());

        // Definir a data de empréstimo como a data atual
        LocalDate today = LocalDate.now();
        dataEmprestimoPicker.setValue(today);

        // Definir a data de devolução como 7 dias após a data de empréstimo
        LocalDate returnDate = today.plusDays(7);
        dataDevolucaoPicker.setValue(returnDate);

        // Adicionar um listener para mudar a data de devolução quando a data de
        // empréstimo mudar
        dataEmprestimoPicker.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue,
                    LocalDate newValue) {
                if (newValue != null) {
                    // Calcular nova data de devolução
                    LocalDate newReturnDate = newValue.plusDays(7);
                    dataDevolucaoPicker.setValue(newReturnDate);
                }
            }
        });
    }

    @FXML
    public void handleSearch() {
        String pessoa = pessoaField.getText();
        String livro = livroField.getText();

        try {
            // Limpar as ListViews
            ListaPessoas.getItems().clear();
            ListaLivros.getItems().clear();

            // Pesquisar pessoas
            if (pessoa.isEmpty()) {
                List<Person> allPersons = personController.getAllPersons();
                ListaPessoas.getItems().addAll(allPersons);
            } else {
                List<Person> persons = personController.getByName(pessoa);
                ListaPessoas.getItems().addAll(persons);
            }

            // Pesquisar livros
            if (livro.isEmpty()) {
                List<Book> allBooks = bookController.getAllBooks();
                ListaLivros.getItems().addAll(allBooks);

            } else {
                List<Book> books = bookController.getByName(livro);
                ListaLivros.getItems().addAll(books);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar exceção (exibir mensagem de erro, etc.)
        }
    }

    @FXML
    public void handleEmprestimo() {
        try {
            // Obter dados do empréstimo
            Person selectedPerson = ListaPessoas.getSelectionModel().getSelectedItem();
            Book selectedBook = ListaLivros.getSelectionModel().getSelectedItem();
            Date loanDate = java.sql.Date.valueOf(dataEmprestimoPicker.getValue());
            Date expectedReturnDate = java.sql.Date.valueOf(dataDevolucaoPicker.getValue());

            if (selectedPerson != null && selectedBook != null) {
                Loan loan = new Loan(loanDate, expectedReturnDate, null); // returnDate será null inicialmente
                Copy copy = copyController.getByTitleBook(selectedBook.getTitle());


                loanController.createLoan(loan, copy.getId(), selectedPerson.getId());
                showSuccessAlert("Empréstimo realizado com sucesso!");
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Erro ao realizar empréstimo");
                alert.setContentText("Selecione uma pessoa e um livro para realizar o empréstimo.");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar exceção (exibir mensagem de erro, etc.)
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao realizar no modulo de emprestimo");
            alert.setContentText("tente novamente");
            alert.showAndWait();
        }
    }

    @FXML
    public void handleVoltar() {
        try {
            Stage stage = (Stage) Voltar.getScene().getWindow();
            AnchorPane root = (AnchorPane) FXMLLoader
                    .load(getClass().getResource("/com/biblioteca/MenuBiblioteca.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showSuccessAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Emprestimo - Sucesso");
        alert.setHeaderText("Olá,");
        alert.setContentText(message);
        alert.showAndWait();
    }
}