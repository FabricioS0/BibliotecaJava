package com.biblioteca.controller;

import com.biblioteca.dao.LoanDAO;
import com.biblioteca.dto.LoanDTO;
import com.biblioteca.model.Loan;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoanController {
    private LoanDAO loanDAO;

    public LoanController() {
        this.loanDAO = new LoanDAO();
    }

    public void addLoan(LoanDTO loanDTO) throws SQLException {
        Loan loan = new Loan();
        loan.setLoanDate(java.sql.Date.valueOf(loanDTO.getLoanDate()));
        loan.setExpectedReturnDate(java.sql.Date.valueOf(loanDTO.getExpectedReturnDate()));
        loan.setReturnDate(loanDTO.getReturnDate() != null ? java.sql.Date.valueOf(loanDTO.getReturnDate()) : null);
        loan.setPersonId(loanDTO.getPersonId());
        loan.setCopyId(loanDTO.getCopyId());
        loanDAO.addLoan(loan);
    }

    public List<LoanDTO> getAllLoans() throws SQLException {
        List<Loan> loans = loanDAO.getAllLoans();
        List<LoanDTO> loanDTOs = new ArrayList<>();
        for (Loan loan : loans) {
            LoanDTO dto = new LoanDTO();
            dto.setId(loan.getId());
            dto.setLoanDate(loan.getLoanDate().toString());
            dto.setExpectedReturnDate(loan.getExpectedReturnDate().toString());
            dto.setReturnDate(loan.getReturnDate() != null ? loan.getReturnDate().toString() : null);
            dto.setPersonId(loan.getPersonId());
            dto.setCopyId(loan.getCopyId());
            loanDTOs.add(dto);
        }
        return loanDTOs;
    }

    public LoanDTO getLoanById(int id) throws SQLException {
        Loan loan = loanDAO.getLoanById(id);
        if (loan != null) {
            LoanDTO dto = new LoanDTO();
            dto.setId(loan.getId());
            dto.setLoanDate(loan.getLoanDate().toString());
            dto.setExpectedReturnDate(loan.getExpectedReturnDate().toString());
            dto.setReturnDate(loan.getReturnDate() != null ? loan.getReturnDate().toString() : null);
            dto.setPersonId(loan.getPersonId());
            dto.setCopyId(loan.getCopyId());
            return dto;
        }
        return null;
    }

    public void updateLoan(LoanDTO loanDTO) throws SQLException {
        Loan loan = new Loan();
        loan.setId(loanDTO.getId());
        loan.setLoanDate(java.sql.Date.valueOf(loanDTO.getLoanDate()));
        loan.setExpectedReturnDate(java.sql.Date.valueOf(loanDTO.getExpectedReturnDate()));
        loan.setReturnDate(loanDTO.getReturnDate() != null ? java.sql.Date.valueOf(loanDTO.getReturnDate()) : null);
        loan.setPersonId(loanDTO.getPersonId());
        loan.setCopyId(loanDTO.getCopyId());
        loanDAO.updateLoan(loan);
    }

    public void deleteLoan(int id) throws SQLException {
        loanDAO.deleteLoan(id);
    }
}