package com.biblioteca.dao;

import com.biblioteca.database.DatabaseConnection;
import com.biblioteca.model.Language;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LanguageDAO {
    private Connection connection;

    public LanguageDAO() {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addLanguage(Language language) throws SQLException {
        String sql = "INSERT INTO Language (acronym, name) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, language.getAcronym());
            stmt.setString(2, language.getName());
            stmt.executeUpdate();
        }
    }

    public List<Language> getAllLanguages() throws SQLException {
        List<Language> languages = new ArrayList<>();
        String sql = "SELECT * FROM Language";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Language language = new Language();
                language.setId(rs.getInt("id_language"));
                language.setAcronym(rs.getString("acronym"));
                language.setName(rs.getString("name"));
                languages.add(language);
            }
        }
        return languages;
    }

    public Language getLanguageById(int id) throws SQLException {
        String sql = "SELECT * FROM Language WHERE id_language = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Language language = new Language();
                language.setId(rs.getInt("id_language"));
                language.setAcronym(rs.getString("acronym"));
                language.setName(rs.getString("name"));
                return language;
            }
        }
        return null;
    }

    public void updateLanguage(Language language) throws SQLException {
        String sql = "UPDATE Language SET acronym = ?, name = ? WHERE id_language = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, language.getAcronym());
            stmt.setString(2, language.getName());
            stmt.setInt(3, language.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteLanguage(int id) throws SQLException {
        String sql = "DELETE FROM Language WHERE id_language = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}