package com.biblioteca.controller;

import com.biblioteca.model.Loan;
import com.biblioteca.service.LoanService;

import java.sql.SQLException;
import java.util.List;

public class LoanController {
    private LoanService loanService = new LoanService();

    public void createLoan(Loan loan, int copyId, int personId) throws SQLException {
        loanService.addLoan(loan, copyId, personId);
    }

    public Loan getLoan(int id) throws SQLException {
        return loanService.getLoan(id);
    }

    public List<Loan> getAllLoans() throws SQLException {
        return loanService.getAllLoans();
    }

    public void updateLoan(Loan loan) throws SQLException {
        loanService.updateLoan(loan);
    }

    public void deleteLoan(int id) throws SQLException {
        Loan loan = new Loan();
        loan.setId(id);
        loanService.deleteLoan(loan);
    }
}