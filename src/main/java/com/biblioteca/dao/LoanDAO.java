package com.biblioteca.dao;

import com.biblioteca.database.DatabaseConnection;
import com.biblioteca.model.Loan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoanDAO {
    private Connection connection;

    public LoanDAO() {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addLoan(Loan loan) throws SQLException {
        String sql = "INSERT INTO Loan (loanDate, expectedReturnDate, returnDate, id_person, id_copy) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(loan.getLoanDate().getTime()));
            stmt.setDate(2, new java.sql.Date(loan.getExpectedReturnDate().getTime()));
            stmt.setDate(3, loan.getReturnDate() != null ? new java.sql.Date(loan.getReturnDate().getTime()) : null);
            stmt.setInt(4, loan.getPersonId());
            stmt.setInt(5, loan.getCopyId());
            stmt.executeUpdate();
        }
    }

    public List<Loan> getAllLoans() throws SQLException {
        List<Loan> loans = new ArrayList<>();
        String sql = "SELECT * FROM Loan";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Loan loan = new Loan();
                loan.setId(rs.getInt("id_loan"));
                loan.setLoanDate(rs.getDate("loanDate"));
                loan.setExpectedReturnDate(rs.getDate("expectedReturnDate"));
                loan.setReturnDate(rs.getDate("returnDate"));
                loan.setPersonId(rs.getInt("id_person"));
                loan.setCopyId(rs.getInt("id_copy"));
                loans.add(loan);
            }
        }
        return loans;
    }

    public Loan getLoanById(int id) throws SQLException {
        String sql = "SELECT * FROM Loan WHERE id_loan = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Loan loan = new Loan();
                loan.setId(rs.getInt("id_loan"));
                loan.setLoanDate(rs.getDate("loanDate"));
                loan.setExpectedReturnDate(rs.getDate("expectedReturnDate"));
                loan.setReturnDate(rs.getDate("returnDate"));
                loan.setPersonId(rs.getInt("id_person"));
                loan.setCopyId(rs.getInt("id_copy"));
                return loan;
            }
        }
        return null;
    }

    public void updateLoan(Loan loan) throws SQLException {
        String sql = "UPDATE Loan SET loanDate = ?, expectedReturnDate = ?, returnDate = ?, id_person = ?, id_copy = ? WHERE id_loan = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(loan.getLoanDate().getTime()));
            stmt.setDate(2, new java.sql.Date(loan.getExpectedReturnDate().getTime()));
            stmt.setDate(3, loan.getReturnDate() != null ? new java.sql.Date(loan.getReturnDate().getTime()) : null);
            stmt.setInt(4, loan.getPersonId());
            stmt.setInt(5, loan.getCopyId());
            stmt.setInt(6, loan.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteLoan(int id) throws SQLException {
        String sql = "DELETE FROM Loan WHERE id_loan = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}