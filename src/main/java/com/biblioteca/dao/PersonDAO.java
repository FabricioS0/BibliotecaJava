package com.biblioteca.dao;

import com.biblioteca.database.DatabaseConnection;
import com.biblioteca.dto.PersonDTO;
import com.biblioteca.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    private Connection connection;

    public PersonDAO() {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPerson(PersonDTO personDTO) throws SQLException {
        String sql = "INSERT INTO Person (name, cpf, birthday) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, personDTO.getName());
            stmt.setString(2, personDTO.getCpf());
            stmt.setDate(3, new java.sql.Date(personDTO.getBirthday().getTime()));
            stmt.executeUpdate();
        }
    }

    public List<Person> getAllPersons() throws SQLException {
        List<Person> persons = new ArrayList<>();
        String sql = "SELECT * FROM Person";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("id_person"));
                person.setName(rs.getString("name"));
                person.setCpf(rs.getString("cpf"));
                person.setBirthday(rs.getDate("birthday"));
                persons.add(person);
            }
        }
        return persons;
    }

    public Person getPersonById(int id) throws SQLException {
        String sql = "SELECT * FROM Person WHERE id_person = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("id_person"));
                person.setName(rs.getString("name"));
                person.setCpf(rs.getString("cpf"));
                person.setBirthday(rs.getDate("birthday"));
                return person;
            }
        }
        return null;
    }

    public void updatePerson(Person person) throws SQLException {
        String sql = "UPDATE Person SET name = ?, cpf = ?, birthday = ? WHERE id_person = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, person.getName());
            stmt.setString(2, person.getCpf());
            stmt.setDate(3, new java.sql.Date(person.getBirthday().getTime()));
            stmt.setInt(4, person.getId());
            stmt.executeUpdate();
        }
    }

    public void deletePerson(int id) throws SQLException {
        String sql = "DELETE FROM Person WHERE id_person = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}