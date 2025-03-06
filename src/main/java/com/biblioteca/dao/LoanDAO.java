package com.biblioteca.dao;

import com.biblioteca.database.DatabaseConnection;
import com.biblioteca.model.Loan;
import com.biblioteca.Enums.Status;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoanDAO {

    public void newLoan(Loan loan, int copyId, int personId) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "INSERT INTO loan (copy_id, person_id, loan_date, expected_return_date, return_date) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, copyId);
            preparedStatement.setInt(2, personId);
            preparedStatement.setDate(3, new Date(loan.getLoanDate().getTime()));
            preparedStatement.setDate(4, new Date(loan.getExpectedReturnDate().getTime()));
            preparedStatement.setDate(5, loan.getReturnDate() != null ? new Date(loan.getReturnDate().getTime()) : null);

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Loan findById(int id) {
        Loan loan = new Loan();
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM loan WHERE id_loan = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                loan.setId(resultSet.getInt("id_loan"));
                loan.setLoanDate(resultSet.getDate("loan_date"));
                loan.setExpectedReturnDate(resultSet.getDate("expected_return_date"));
                loan.setReturnDate(resultSet.getDate("return_date"));
                // Aqui você pode adicionar o status se necessário
                // loan.setStatus(Status.valueOf(resultSet.getString("status"))); // Se houver um status
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loan;
    }

    public List<Loan> findAll() {
        List<Loan> loans = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM loan";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Loan loan = new Loan();
                loan.setId(resultSet.getInt("id_loan"));
                loan.setLoanDate(resultSet.getDate("loan_date"));
                loan.setExpectedReturnDate(resultSet.getDate("expected_return_date"));
                loan.setReturnDate(resultSet.getDate("return_date"));
                // Aqui você pode adicionar o status se necessário
                // loan.setStatus(Status.valueOf(resultSet.getString("status"))); // Se houver um status

                loans.add(loan);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loans;
    }

    public void update(Loan loan) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "UPDATE loan SET loan_date = ?, expected_return_date = ?, return_date = ? WHERE id_loan = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, new Date(loan.getLoanDate().getTime()));
            statement.setDate(2, new Date(loan.getExpectedReturnDate().getTime()));
            statement.setDate(3, loan.getReturnDate() != null ? new Date(loan.getReturnDate().getTime()) : null);
            statement.setInt(4, loan.getId());

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Loan loan) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "DELETE FROM loan WHERE id_loan = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, loan.getId());

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}