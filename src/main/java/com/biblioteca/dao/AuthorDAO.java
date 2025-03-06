package com.biblioteca.dao;

import com.biblioteca.model.Author;
import com.biblioteca.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AuthorDAO {

    // save author to the database
    public void save(Author author) throws SQLException {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "INSERT INTO authors (name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, author.getName());

            statement.execute();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // update author in the database
    public void update(Author author) throws SQLException {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "UPDATE authors SET name = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, author.getName());
            statement.setInt(2, author.getId());

            statement.execute();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // get All authors from the database
    public List<Author> findAll() throws SQLException {
        List<Author> authors = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM authors";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Author author = new Author(sql);
                author.setId(resultSet.getInt("id"));
                author.setName(resultSet.getString("name"));
                authors.add(author);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    // get author by name
    public Author findByName(String name) throws SQLException {
        Author author = new Author();
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM authors WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                author.setId(resultSet.getInt("id"));
                author.setName(resultSet.getString("name"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }

    // get author by id
    public Author findById(int id) throws SQLException {
        Author author = new Author();
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM authors WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                author.setId(resultSet.getInt("id"));
                author.setName(resultSet.getString("name"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return author;
    }

    public void delete(Author author) throws SQLException {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "DELETE FROM authors WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, author.getId());

            statement.execute();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}