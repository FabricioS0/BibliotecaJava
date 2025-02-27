package com.biblioteca.Controller;

import com.biblioteca.dao.BookDAO;
import com.biblioteca.dto.BookDTO;
import com.biblioteca.model.Book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookController {
    private BookDAO bookDAO;

    public BookController() {
        this.bookDAO = new BookDAO(null);
    }

    public void addBook(BookDTO bookDTO) throws SQLException {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setDescription(bookDTO.getDescription());
        book.setEdition(bookDTO.getEdition());
        book.setPublicationDate(java.sql.Date.valueOf(bookDTO.getPublicationDate()));
        book.setIsbn(bookDTO.getIsbn());
        bookDAO.addBook(book);
    }

    public List<BookDTO> getAllBooks() throws SQLException {
        List<Book> books = bookDAO.getAllBooks();
        List<BookDTO> bookDTOs = new ArrayList<>();
        for (Book book : books) {
            BookDTO dto = new BookDTO();
            dto.setId(book.getId());
            dto.setTitle(book.getTitle());
            dto.setDescription(book.getDescription());
            dto.setEdition(book.getEdition());
            dto.setPublicationDate(book.getPublicationDate().toString());
            dto.setIsbn(book.getIsbn());
            bookDTOs.add(dto);
        }
        return bookDTOs;
    }

    public BookDTO getBookById(int id) throws SQLException {
        Book book = bookDAO.getBookById(id);
        if (book != null) {
            BookDTO dto = new BookDTO();
            dto.setId(book.getId());
            dto.setTitle(book.getTitle());
            dto.setDescription(book.getDescription());
            dto.setEdition(book.getEdition());
            dto.setPublicationDate(book.getPublicationDate().toString());
            dto.setIsbn(book.getIsbn());
            return dto;
        }
        return null;
    }

    public void updateBook(BookDTO bookDTO) throws SQLException {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setDescription(bookDTO.getDescription());
        book.setEdition(bookDTO.getEdition());
        book.setPublicationDate(java.sql.Date.valueOf(bookDTO.getPublicationDate()));
        book.setIsbn(bookDTO.getIsbn());
        bookDAO.updateBook(book);
    }

    public void deleteBook(int id) throws SQLException {
        bookDAO.deleteBook(id);
    }
}