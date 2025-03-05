package com.biblioteca.dao;

import com.biblioteca.database.DatabaseConnection;
import com.biblioteca.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    public void save(Category category) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "INSERT INTO category (name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, category.getName());

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM category";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt("id_category"));
                category.setName(resultSet.getString("name"));

                categories.add(category);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public void update(Category category) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "UPDATE category SET name = ? WHERE id_category = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, category.getName());
            statement.setInt(2, category.getId());

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Category category) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "DELETE FROM category WHERE id_category = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, category.getId());

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Category findById(int id) {
        Category category = new Category();
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM category WHERE id_category = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                category.setId(resultSet.getInt("id_category"));
                category.setName(resultSet.getString("name"));
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }
}