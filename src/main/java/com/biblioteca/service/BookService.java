package com.biblioteca.service;

import com.biblioteca.dao.BookDAO;
import com.biblioteca.model.Book;

import java.sql.SQLException;
import java.util.List;

public class BookService {
    private BookDAO bookDAO = new BookDAO();

    public void addBook(Book book) throws SQLException {
        bookDAO.save(book);
    }

    public Book getBook(int id) throws SQLException {
        return bookDAO.findById(id);
    }

    public List<Book> getAllBooks() throws SQLException {
        return bookDAO.findAll();
    }

    public List<Book> getByName(String name) throws SQLException {
        return bookDAO.findByName(name);
    }

    public void updateBook(Book book) throws SQLException {
        bookDAO.update(book);
    }

    public void deleteBook(Book book) throws SQLException {
        bookDAO.delete(book);
    }
}