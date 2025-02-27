package com.biblioteca.Controller;

import com.biblioteca.dao.AuthorDAO;
import com.biblioteca.dto.AuthorDTO;
import com.biblioteca.model.Author;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorController {
    private AuthorDAO authorDAO;

    public AuthorController() {
        this.authorDAO = new AuthorDAO();
    }

    public void addAuthor(AuthorDTO authorDTO) throws SQLException {
        Author author = new Author();
        author.setName(authorDTO.getName());
        authorDAO.addAuthor(author);
    }

    public List<AuthorDTO> getAllAuthors() throws SQLException {
        List<Author> authors = authorDAO.getAllAuthors();
        List<AuthorDTO> authorDTOs = new ArrayList<>();
        for (Author author : authors) {
            AuthorDTO dto = new AuthorDTO();
            dto.setId(author.getId());
            dto.setName(author.getName());
            authorDTOs.add(dto);
        }
        return authorDTOs;
    }

    public AuthorDTO getAuthorById(int id) throws SQLException {
        Author author = authorDAO.getAuthorById(id);
        if (author != null) {
            AuthorDTO dto = new AuthorDTO();
            dto.setId(author.getId());
            dto.setName(author.getName());
            return dto;
        }
        return null;
    }

    public void updateAuthor(AuthorDTO authorDTO) throws SQLException {
        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        authorDAO.updateAuthor(author);
    }

    public void deleteAuthor(int id) throws SQLException {
        authorDAO.deleteAuthor(id);
    }
}