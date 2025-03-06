package com.biblioteca.controller;

import com.biblioteca.model.Book;
import com.biblioteca.service.BookService;

import java.sql.SQLException;
import java.util.List;

public class BookController {
    private BookService bookService = new BookService();

    public void createBook(String title, String description, String edition, java.util.Date publicationDate, String isbn) throws SQLException {
        Book book = new Book();
        book.setTitle(title);
        book.setDescription(description);
        book.setEdition(edition);
        book.setPublicationDate(publicationDate);
        book.setIsbn(isbn);
        bookService.addBook(book);
    }

    public Book getBook(int id) throws SQLException {
        return bookService.getBook(id);
    }

    public List<Book> getAllBooks() throws SQLException {
        return bookService.getAllBooks();
    }

    public List<Book> getByName(String name) throws SQLException {
        return bookService.getByName(name);
    }

    public void updateBook(int id, String title, String description, String edition, java.util.Date publicationDate, String isbn) throws SQLException {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setDescription(description);
        book.setEdition(edition);
        book.setPublicationDate(publicationDate);
        book.setIsbn(isbn);
        bookService.updateBook(book);
    }

    public void deleteBook(int id) throws SQLException {
        Book book = new Book();
        book.setId(id);
        bookService.deleteBook(book);
    }
}