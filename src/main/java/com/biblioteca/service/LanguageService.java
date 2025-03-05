package com.biblioteca.service;

import com.biblioteca.dao.LanguageDAO;
import com.biblioteca.model.Language;

import java.sql.SQLException;
import java.util.List;

public class LanguageService {
    private LanguageDAO languageDAO = new LanguageDAO();

    public void addLanguage(Language language) throws SQLException {
        languageDAO.save(language);
    }

    public Language getLanguage(int id) throws SQLException {
        return languageDAO.findById(id);
    }

    public List<Language> getAllLanguages() throws SQLException {
        return languageDAO.findAll();
    }

    public void updateLanguage(Language language) throws SQLException {
        languageDAO.update(language);
    }

    public void deleteLanguage(Language language) throws SQLException {
        languageDAO.delete(language);
    }
}