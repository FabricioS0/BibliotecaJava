package com.biblioteca.ViewsControllers;

import com.biblioteca.dto.LoanDTO;
import com.biblioteca.model.Loan;
import com.biblioteca.dao.LoanDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RealizarEmprestimoController {

    @FXML
    private TextField pessoaField;
    @FXML
    private TextField livroField;
    @FXML
    private DatePicker dataEmprestimoPicker;
    @FXML
    private DatePicker dataDevolucaoPicker;

    private LoanDAO loanDAO = new LoanDAO();

    @FXML
    private void handleRealizarEmprestimo(ActionEvent event) {
        String pessoaNome = pessoaField.getText();
        String livroNome = livroField.getText();

        if (pessoaNome.isEmpty() || livroNome.isEmpty()) {
            showAlert("Erro", "Preencha todos os campos!", AlertType.ERROR);
            return;
        }

        // Convertendo as datas
        Date dataEmprestimo = java.sql.Date.valueOf(dataEmprestimoPicker.getValue());
        Date dataDevolucao = java.sql.Date.valueOf(dataDevolucaoPicker.getValue());

        // Criando DTO de empréstimo
        LoanDTO loanDTO = new LoanDTO();
        loanDTO.setLoanDate(formatDate(dataEmprestimo));
        loanDTO.setExpectedReturnDate(formatDate(dataDevolucao));
        loanDTO.setPersonId(getPessoaId(pessoaNome)); // Suponha que você tenha um método que retorna o ID da pessoa
        loanDTO.setCopyId(getLivroId(livroNome)); // Suponha que você tenha um método que retorna o ID do livro

        // Convertendo DTO para Model
        Loan loan = new Loan();
        loan.setLoanDate(dataEmprestimo);
        loan.setExpectedReturnDate(dataDevolucao);
        loan.setPersonId(loanDTO.getPersonId());
        loan.setCopyId(loanDTO.getCopyId());

        // Salvando o empréstimo no banco de dados
        LoanDAO.addLoan(Loan loan);
        showAlert("Sucesso", "Empréstimo realizado com sucesso!", AlertType.INFORMATION);
    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    private int getPessoaId(String nomePessoa) {
        // Aqui você implementaria a lógica para buscar o ID da pessoa com base no nome
        return 1; // Exemplo de retorno
    }

    private int getLivroId(String nomeLivro) {
        // Aqui você implementaria a lógica para buscar o ID do livro com base no nome
        return 1; // Exemplo de retorno
    }

    private void showAlert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
