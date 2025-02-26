package com.biblioteca.dao;

import com.biblioteca.database.DatabaseConnection;
import com.biblioteca.model.Copy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CopyDAO {
    private Connection connection;

    public CopyDAO() {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCopy(Copy copy) throws SQLException {
        String sql = "INSERT INTO Copy (status, identifier, id_book) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, copy.getStatus());
            stmt.setString(2, copy.getIdentifier());
            stmt.setInt(3, copy.getBookId());
            stmt.executeUpdate();
        }
    }

    public List<Copy> getAllCopies() throws SQLException {
        List<Copy> copies = new ArrayList<>();
        String sql = "SELECT * FROM Copy";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Copy copy = new Copy();
                copy.setId(rs.getInt("id_copy"));
                copy.setStatus(rs.getString("status"));
                copy.setIdentifier(rs.getString("identifier"));
                copy.setBookId(rs.getInt("id_book"));
                copies.add(copy);
            }
        }
        return copies;
    }

    public Copy getCopyById(int id) throws SQLException {
        String sql = "SELECT * FROM Copy WHERE id_copy = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Copy copy = new Copy();
                copy.setId(rs.getInt("id_copy"));
                copy.setStatus(rs.getString("status"));
                copy.setIdentifier(rs.getString("identifier"));
                copy.setBookId(rs.getInt("id_book"));
                return copy;
            }
        }
        return null;
    }

    public void updateCopy(Copy copy) throws SQLException {
        String sql = "UPDATE Copy SET status = ?, identifier = ?, id_book = ? WHERE id_copy = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, copy.getStatus());
            stmt.setString(2, copy.getIdentifier());
            stmt.setInt(3, copy.getBookId());
            stmt.setInt(4, copy.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteCopy(int id) throws SQLException {
        String sql = "DELETE FROM Copy WHERE id_copy = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}