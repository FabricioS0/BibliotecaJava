package com.biblioteca.service;

import com.biblioteca.dao.PersonDAO;
import com.biblioteca.model.Person;

import java.sql.SQLException;
import java.util.List;

public class PersonService {
    private PersonDAO personDAO = new PersonDAO();

    public void addPerson(Person person) throws SQLException {
        personDAO.save(person);
    }

    public Person getPerson(int id) throws SQLException {
        return personDAO.findById(id);
    }

    public List<Person> getAllPersons() throws SQLException {
        return personDAO.findAll();
    }

    public void updatePerson(Person person) throws SQLException {
        personDAO.update(person);
    }

    public void deletePerson(Person person) throws SQLException {
        personDAO.delete(person);
    }
}