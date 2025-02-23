package com.biblioteca.dao;

import com.biblioteca.database.DatabaseConnection;
import com.biblioteca.model.Publisher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublisherDAO {
    private Connection connection;

    public PublisherDAO() {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPublisher(Publisher publisher) throws SQLException {
        String sql = "INSERT INTO Publisher (name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, publisher.getName());
            stmt.executeUpdate();
        }
    }

    public List<Publisher> getAllPublishers() throws SQLException {
        List<Publisher> publishers = new ArrayList<>();
        String sql = "SELECT * FROM Publisher";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Publisher publisher = new Publisher();
                publisher.setId(rs.getInt("id_publisher"));
                publisher.setName(rs.getString("name"));
                publishers.add(publisher);
            }
        }
        return publishers;
    }

    public Publisher getPublisherById(int id) throws SQLException {
        String sql = "SELECT * FROM Publisher WHERE id_publisher = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Publisher publisher = new Publisher();
                publisher.setId(rs.getInt("id_publisher"));
                publisher.setName(rs.getString("name"));
                return publisher;
            }
        }
        return null;
    }

    public void updatePublisher(Publisher publisher) throws SQLException {
        String sql = "UPDATE Publisher SET name = ? WHERE id_publisher = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, publisher.getName());
            stmt.setInt(2, publisher.getId());
            stmt.executeUpdate();
        }
    }

    public void deletePublisher(int id) throws SQLException {
        String sql = "DELETE FROM Publisher WHERE id_publisher = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}