package com.biblioteca.service;

import com.biblioteca.dao.AuthorDAO;
import com.biblioteca.model.Author;

import java.sql.SQLException;
import java.util.List;

public class AuthorService {
    private AuthorDAO authorDAO = new AuthorDAO();

    public void addAuthor(Author author) throws SQLException {
        authorDAO.save(author);
    }

    public Author getAuthor(int id) throws SQLException {
        return authorDAO.findById(id);
    }

    public List<Author> getAllAuthors() throws SQLException {
        return authorDAO.findAll();
    }

    public void updateAuthor(Author author) throws SQLException {
        authorDAO.update(author);
    }

    public void deleteAuthor(Author author) throws SQLException {
        authorDAO.delete(author);
    }
}