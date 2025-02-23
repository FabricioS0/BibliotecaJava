package com.biblioteca.dao;

import com.biblioteca.database.DatabaseConnection;
import com.biblioteca.model.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {
    private Connection connection;

    public AuthorDAO() {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAuthor(Author author) throws SQLException {
        String sql = "INSERT INTO Author (name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, author.getName());
            stmt.executeUpdate();
        }
    }

    public List<Author> getAllAuthors() throws SQLException {
        List<Author> authors = new ArrayList<>();
        String sql = "SELECT * FROM Author";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Author author = new Author();
                author.setId(rs.getInt("id_author"));
                author.setName(rs.getString("name"));
                authors.add(author);
            }
        }
        return authors;
    }

    public Author getAuthorById(int id) throws SQLException {
        String sql = "SELECT * FROM Author WHERE id_author = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Author author = new Author();
                author.setId(rs.getInt("id_author"));
                author.setName(rs.getString("name"));
                return author;
            }
        }
        return null;
    }

    public void updateAuthor(Author author) throws SQLException {
        String sql = "UPDATE Author SET name = ? WHERE id_author = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, author.getName());
            stmt.setInt(2, author.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteAuthor(int id) throws SQLException {
        String sql = "DELETE FROM Author WHERE id_author = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}