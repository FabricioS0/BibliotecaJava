package com.biblioteca.dao;

import com.biblioteca.database.DatabaseConnection;
import com.biblioteca.model.User;
import com.biblioteca.Enums.Permission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public void save(User user) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "INSERT INTO user (username, name, password, permission) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getName());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getPermission().name()); // Converte o enum para String

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM user";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id_user"));
                user.setUsername(resultSet.getString("username"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setPermission(Permission.valueOf(resultSet.getString("permission")));

                users.add(user);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void update(User user) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "UPDATE user SET username = ?, name = ?, password = ?, permission = ? WHERE id_user = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getName());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getPermission().name()); // Converte o enum para String
            statement.setInt(5, user.getId());

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(User user) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "DELETE FROM user WHERE id_user = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, user.getId());

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User findById(int id) {
        User user = new User();
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM user WHERE id_user = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user.setId(resultSet.getInt("id_user"));
                user.setUsername(resultSet.getString("username"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setPermission(Permission.valueOf(resultSet.getString("permission"))); // Converte String para Enum
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}