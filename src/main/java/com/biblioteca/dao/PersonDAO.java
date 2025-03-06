package com.biblioteca.dao;

import com.biblioteca.database.DatabaseConnection;
import com.biblioteca.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public void save(Person person) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "INSERT INTO person (name, cpf, birthday) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, person.getName());
            statement.setString(2, person.getCpf());
            statement.setDate(3, new java.sql.Date(person.getBirthday().getTime()));

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM person";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id_person"));
                person.setName(resultSet.getString("name"));
                person.setCpf(resultSet.getString("cpf"));
                person.setBirthday(resultSet.getDate("birthday"));

                persons.add(person);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public void update(Person person) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "UPDATE person SET name = ?, cpf = ?, birthday = ? WHERE id_person = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, person.getName());
            statement.setString(2, person.getCpf());
            statement.setDate(3, new java.sql.Date(person.getBirthday().getTime()));
            statement.setInt(4, person.getId());

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Person person) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "DELETE FROM person WHERE id_person = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, person.getId());

            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Person findById(int id) {
        Person person = new Person();
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM person WHERE id_person = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                person.setId(resultSet.getInt("id_person"));
                person.setName(resultSet.getString("name"));
                person.setCpf(resultSet.getString("cpf"));
                person.setBirthday(resultSet.getDate("birthday"));
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }

    public List<Person> findByName(String name){
        List<Person> persons = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();

            // pesquisa * em person onde nome contenha %name%
            String sql = "SELECT * FROM person WHERE name LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id_person"));
                person.setName(resultSet.getString("name"));
                person.setCpf(resultSet.getString("cpf"));
                person.setBirthday(resultSet.getDate("birthday"));

                persons.add(person);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }
}