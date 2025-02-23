package com.biblioteca.controller;

import com.biblioteca.dao.LanguageDAO;
import com.biblioteca.dto.LanguageDTO;
import com.biblioteca.model.Language;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LanguageController {
    private LanguageDAO languageDAO;

    public LanguageController() {
        this.languageDAO = new LanguageDAO();
    }

    public void addLanguage(LanguageDTO languageDTO) throws SQLException {
        Language language = new Language();
        language.setAcronym(languageDTO.getAcronym());
        language.setName(languageDTO.getName());
        languageDAO.addLanguage(language);
    }

    public List<LanguageDTO> getAllLanguages() throws SQLException {
        List<Language> languages = languageDAO.getAllLanguages();
        List<LanguageDTO> languageDTOs = new ArrayList<>();
        for (Language language : languages) {
            LanguageDTO dto = new LanguageDTO();
            dto.setId(language.getId());
            dto.setAcronym(language.getAcronym());
            dto.setName(language.getName());
            languageDTOs.add(dto);
        }
        return languageDTOs;
    }

    public LanguageDTO getLanguageById(int id) throws SQLException {
        Language language = languageDAO.getLanguageById(id);
        if (language != null) {
            LanguageDTO dto = new LanguageDTO();
            dto.setId(language.getId());
            dto.setAcronym(language.getAcronym());
            dto.setName(language.getName());
            return dto;
        }
        return null;
    }

    public void updateLanguage(LanguageDTO languageDTO) throws SQLException {
        Language language = new Language();
        language.setId(languageDTO.getId());
        language.setAcronym(languageDTO.getAcronym());
        language.setName(languageDTO.getName());
        languageDAO.updateLanguage(language);
    }

    public void deleteLanguage(int id) throws SQLException {
        languageDAO.deleteLanguage(id);
    }
}