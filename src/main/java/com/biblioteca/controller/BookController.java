package com.biblioteca.controller;

import com.biblioteca.model.Book;
import com.biblioteca.service.BookService;

import java.sql.SQLException;
import java.util.List;

public class BookController {
    private BookService bookService = new BookService();

    public void createBook(String title, String description, String edition, java.util.Date publicationDate, int isbn) throws SQLException {
        Book book = new Book(title, description, edition, publicationDate, isbn);
        bookService.addBook(book);
    }

    public Book getBook(int id) throws SQLException {
        return bookService.getBook(id);
    }

    public List<Book> getAllBooks() throws SQLException {
        return bookService.getAllBooks();
    }

    public void updateBook(int id, String title, String description, String edition, java.util.Date publicationDate, int isbn) throws SQLException {
        Book book = new Book(title, description, edition, publicationDate, isbn);
        book.setId(id);
        bookService.updateBook(book);
    }

    public void deleteBook(int id) throws SQLException {
        Book book = new Book();
        book.setId(id);
        bookService.deleteBook(book);
    }
}