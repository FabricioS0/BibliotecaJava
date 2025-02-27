package com.biblioteca.ViewsControllers;

import com.biblioteca.dao.LoanDAO;
import com.biblioteca.model.Loan;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;
import java.util.List;

public class RealizarDevolucaoController {

    @FXML
    private TextField txtSearchPerson;

    @FXML
    private ListView<String> listLoans;

    @FXML
    private Label lblLateDays, lblInitialFine, lblDailyFine, lblTotalFine;

    @FXML
    private CheckBox chkConfirmPayment;

    private LoanDAO loanDAO = new LoanDAO();

    @FXML
    public void searchPersonLoans() {
        String personName = txtSearchPerson.getText().trim();
        listLoans.getItems().clear();

        if (!personName.isEmpty()) {
            try {
                List<Loan> loans = loanDAO.getLoansByPersonName(personName);
                
                for (Loan loan : loans) {
                    String itemText = "Livro ID: " + loan.getCopyId() +
                            " | Empréstimo: " + loan.getLoanDate() +
                            " | Devolução até: " + loan.getExpectedReturnDate();
                    listLoans.getItems().add(itemText);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void processReturn() {
        if (chkConfirmPayment.isSelected()) {
            System.out.println("Devolução confirmada.");
            // Lógica para atualizar o banco e marcar o livro como devolvido
        } else {
            System.out.println("Confirme o pagamento da multa antes de continuar.");
        }
    }
}
