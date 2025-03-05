package com.biblioteca.dao;

import com.biblioteca.database.DatabaseConnection;
import com.biblioteca.model.Publisher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublisherDAO {

    public void save(Publisher publisher) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "INSERT INTO publisher (name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, publisher.getName());

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Publisher> findAll() {
        List<Publisher> publishers = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM publisher";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Publisher publisher = new Publisher();
                publisher.setId(resultSet.getInt("id_publisher"));
                publisher.setName(resultSet.getString("name"));

                publishers.add(publisher);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publishers;
    }

    public void update(Publisher publisher) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "UPDATE publisher SET name = ? WHERE id_publisher = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, publisher.getName());
            statement.setInt(2, publisher.getId());

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Publisher publisher) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "DELETE FROM publisher WHERE id_publisher = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, publisher.getId());

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Publisher findById(int id) {
        Publisher publisher = new Publisher();
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM publisher WHERE id_publisher = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                publisher.setId(resultSet.getInt("id_publisher"));
                publisher.setName(resultSet.getString("name"));
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publisher;
    }
}