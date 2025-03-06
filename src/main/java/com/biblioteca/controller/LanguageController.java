package com.biblioteca.controller;

import com.biblioteca.model.Language;
import com.biblioteca.service.LanguageService;

import java.sql.SQLException;
import java.util.List;

public class LanguageController {
    private LanguageService languageService = new LanguageService();

    public void createLanguage(String acronym, String name) throws SQLException {
        Language language = new Language(acronym, name);
        languageService.addLanguage(language);
    }

    public Language getLanguage(int id) throws SQLException {
        return languageService.getLanguage(id);
    }

    public List<Language> getAllLanguages() throws SQLException {
        return languageService.getAllLanguages();
    }

    public void updateLanguage(int id, String acronym, String name) throws SQLException {
        Language language = new Language(acronym, name);
        language.setId(id);
        languageService.updateLanguage(language);
    }

    public void deleteLanguage(int id) throws SQLException {
        Language language = new Language();
        language.setId(id);
        languageService.deleteLanguage(language);
    }
}