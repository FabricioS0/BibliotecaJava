package com.biblioteca.service;

import com.biblioteca.dao.LoanDAO;
import com.biblioteca.model.Loan;

import java.sql.SQLException;
import java.util.List;

public class LoanService {
    private LoanDAO loanDAO = new LoanDAO();

    public void addLoan(Loan loan, int copyId, int personId) throws SQLException {
        loanDAO.newLoan(loan, copyId, personId);
    }

    public Loan getLoan(int id) throws SQLException {
        return loanDAO.findById(id);
    }

    public List<Loan> getAllLoans() throws SQLException {
        return loanDAO.findAll();
    }

    public void updateLoan(Loan loan) throws SQLException {
        loanDAO.update(loan);
    }

    public void deleteLoan(Loan loan) throws SQLException {
        loanDAO.delete(loan);
    }
}