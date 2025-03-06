package com.biblioteca.controller;

import com.biblioteca.model.Person;
import com.biblioteca.service.PersonService;

import java.sql.SQLException;
import java.util.List;

public class PersonController {
    private PersonService personService = new PersonService();

    public void createPerson(String name, String cpf, java.util.Date birthday) throws SQLException {
        Person person = new Person(name, cpf, birthday);
        personService.addPerson(person);
    }

    public Person getPerson(int id) throws SQLException {
        return personService.getPerson(id);
    }

    public List<Person> getAllPersons() throws SQLException {
        return personService.getAllPersons();
    }

    public List<Person> getByName(String name) throws SQLException {
        return personService.getByName(name);
    }

    public void updatePerson(int id, String name, String cpf, java.util.Date birthday) throws SQLException {
        Person person = new Person(name, cpf, birthday);
        person.setId(id);
        personService.updatePerson(person);
    }

    public void deletePerson(int id) throws SQLException {
        Person person = new Person();
        person.setId(id);
        personService.deletePerson(person);
    }
}