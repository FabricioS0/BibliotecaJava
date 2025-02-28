package com.biblioteca.dao;

import com.biblioteca.database.DatabaseConnection;
import com.biblioteca.dto.BookDTO;
import com.biblioteca.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection connection;

    public BookDAO() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    public boolean addBook(BookDTO book) {
        String sql = "INSERT INTO Book (title, description, edition, publication_date, isbn) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getDescription());
            stmt.setString(3, book.getEdition());
            stmt.setDate(4, new java.sql.Date(book.getPublicationDate().getTime()));
            stmt.setString(5, book.getIsbn());
            stmt.executeUpdate();
            return true; // Retorna true se o livro foi cadastrado com sucesso
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retorna false em caso de erro
        }
    }

    public List<Book> getAllBooks() {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public Book getBookById(int id) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateBook(Book book) {
        String sql = "UPDATE Book SET title = ?, description = ?, edition = ?, publication_date = ?, isbn = ? WHERE id_book = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getDescription());
            stmt.setString(3, book.getEdition());
            stmt.setDate(4, new java.sql.Date(book.getPublicationDate().getTime()));
            stmt.setString(5, book.getIsbn());
            stmt.setInt(6, book.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBook(int id) {
        String sql = "DELETE FROM Book WHERE id_book = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
