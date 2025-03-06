package com.biblioteca.dao;

import com.biblioteca.database.DatabaseConnection;
import com.biblioteca.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public void save(Book book) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "INSERT INTO book (title, description, edition, publication_date, isbn) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getDescription());
            statement.setString(3, book.getEdition());
            statement.setDate(4, new java.sql.Date(book.getPublicationDate().getTime()));
            statement.setInt(5, book.getIsbn());

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Book> findAll() throws SQLException{
        List<Book> books = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM book";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setDescription(resultSet.getString("description"));
                book.setEdition(resultSet.getString("edition"));
                book.setPublicationDate(resultSet.getDate("publication_date"));
                book.setIsbn(resultSet.getInt("isbn"));

                books.add(book);
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void update(Book book) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "UPDATE book SET title = ?, description = ?, edition = ?, publication_date = ?, isbn = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getDescription());
            statement.setString(3, book.getEdition());
            statement.setDate(4, new java.sql.Date(book.getPublicationDate().getTime()));
            statement.setInt(5, book.getIsbn());
            statement.setInt(6, book.getId());

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Book book) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "DELETE FROM book WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, book.getId());

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Book findById(int id) {
        Book book = new Book();
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM book WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setDescription(resultSet.getString("description"));
                book.setEdition(resultSet.getString("edition"));
                book.setPublicationDate(resultSet.getDate("publication_date"));
                book.setIsbn(resultSet.getInt("isbn"));
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // find by name
    public Book findByTitle(String title) {
        Book book = new Book();
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM book WHERE title = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setDescription(resultSet.getString("description"));
                book.setEdition(resultSet.getString("edition"));
                book.setPublicationDate(resultSet.getDate("publication_date"));
                book.setIsbn(resultSet.getInt("isbn"));
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }
}