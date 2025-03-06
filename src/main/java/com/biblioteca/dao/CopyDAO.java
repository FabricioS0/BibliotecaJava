package com.biblioteca.dao;

import com.biblioteca.database.DatabaseConnection;
import com.biblioteca.model.Copy;
import com.biblioteca.Enums.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CopyDAO {

    public void save(Copy copy) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "INSERT INTO copy (status, identifier) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, copy.getStatus()); // Converte o enum para String
            statement.setString(2, copy.getIdentifier());

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Copy> findAll() {
        List<Copy> copies = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM copy";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Copy copy = new Copy();
                copy.setId(resultSet.getInt("id_copy"));
                copy.setStatus(resultSet.getString("status")); // Converte String para Enum
                copy.setIdentifier(resultSet.getString("identifier"));

                copies.add(copy);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return copies;
    }

    public Copy findByTitleBook(String title) {
        Copy copy = new Copy();
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "select id_copy, status, identifier from copy where id_book = (select id_book from book where title = ?) and status = 'available';";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                copy.setId(resultSet.getInt("id_copy"));
                copy.setStatus(resultSet.getString("status")); // Converte String para Enum
                copy.setIdentifier(resultSet.getString("identifier"));
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return copy;
    }

    public void update(Copy copy) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "UPDATE copy SET status = ?, identifier = ? WHERE id_copy = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, copy.getStatus()); // Converte o enum para String
            statement.setString(2, copy.getIdentifier());
            statement.setInt(3, copy.getId());

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Copy copy) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "DELETE FROM copy WHERE id_copy = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, copy.getId());

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Copy findById(int id) {
        Copy copy = new Copy();
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM copy WHERE id_copy = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                copy.setId(resultSet.getInt("id_copy"));
                copy.setStatus(resultSet.getString("status")); // Converte String para Enum
                copy.setIdentifier(resultSet.getString("identifier"));
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return copy;
    }
}