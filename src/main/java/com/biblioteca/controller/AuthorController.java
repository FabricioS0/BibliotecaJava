package com.biblioteca.controller;

import com.biblioteca.model.Author;
import com.biblioteca.service.AuthorService;

import java.sql.SQLException;
import java.util.List;

public class AuthorController {
    private AuthorService authorService = new AuthorService();

    public void createAuthor(String name) throws SQLException {
        Author author = new Author(name);
        authorService.addAuthor(author);
    }

    public Author getAuthor(int id) throws SQLException {
        return authorService.getAuthor(id);
    }

    public List<Author> getAllAuthors() throws SQLException {
        return authorService.getAllAuthors();
    }

    public void updateAuthor(int id, String name) throws SQLException {
        Author author = new Author(name);
        author.setId(id);
        authorService.updateAuthor(author);
    }

    public void deleteAuthor(int id) throws SQLException {
        Author author = new Author();
        author.setId(id);
        authorService.deleteAuthor(author);
    }
}