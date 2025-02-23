package com.biblioteca.dao;

import com.biblioteca.database.DatabaseConnection;
import com.biblioteca.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection connection;

    public BookDAO() {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBook(Book book) throws SQLException {
        String sql = "INSERT INTO Book (title, description, edition, publication_date, isbn) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getDescription());
            stmt.setString(3, book.getEdition());
            stmt.setDate(4, new java.sql.Date(book.getPublicationDate().getTime()));
            stmt.setString(5, book.getIsbn());
            stmt.executeUpdate();
        }
    }

    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM Book";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id_book"));
                book.setTitle(rs.getString("title"));
                book.setDescription(rs.getString("description"));
                book.setEdition(rs.getString("edition"));
                book.setPublicationDate(rs.getDate("publication_date"));
                book.setIsbn(rs.getString("isbn"));
                books.add(book);
            }
        }
        return books;
    }

    public Book getBookById(int id) throws SQLException {
        String sql = "SELECT * FROM Book WHERE id_book = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id_book"));
                book.setTitle(rs.getString("title"));
                book.setDescription(rs.getString("description"));
                book.setEdition(rs.getString("edition"));
                book.setPublicationDate(rs.getDate("publication_date"));
                book.setIsbn(rs.getString("isbn"));
                return book;
            }
        }
        return null;
    }

    public void updateBook(Book book) throws SQLException {
        String sql = "UPDATE Book SET title = ?, description = ?, edition = ?, publication_date = ?, isbn = ? WHERE id_book = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getDescription());
            stmt.setString(3, book.getEdition());
            stmt.setDate(4, new java.sql.Date(book.getPublicationDate().getTime()));
            stmt.setString(5, book.getIsbn());
            stmt.setInt(6, book.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteBook(int id) throws SQLException {
        String sql = "DELETE FROM Book WHERE id_book = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}