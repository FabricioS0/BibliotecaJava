package com.biblioteca.dao;

import com.biblioteca.database.DatabaseConnection;
import com.biblioteca.model.Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LanguageDAO {

    public void save(Language language) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "INSERT INTO language (acronym, name) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, language.getAcronym());
            statement.setString(2, language.getName());

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Language> findAll() {
        List<Language> languages = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM language";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Language language = new Language();
                language.setId(resultSet.getInt("id_language"));
                language.setAcronym(resultSet.getString("acronym"));
                language.setName(resultSet.getString("name"));

                languages.add(language);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return languages;
    }

    public void update(Language language) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "UPDATE language SET acronym = ?, name = ? WHERE id_language = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, language.getAcronym());
            statement.setString(2, language.getName());
            statement.setInt(3, language.getId());

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Language language) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "DELETE FROM language WHERE id_language = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, language.getId());

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Language findById(int id) {
        Language language = new Language();
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM language WHERE id_language = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                language.setId(resultSet.getInt("id_language"));
                language.setAcronym(resultSet.getString("acronym"));
                language.setName(resultSet.getString("name"));
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return language;
    }
}