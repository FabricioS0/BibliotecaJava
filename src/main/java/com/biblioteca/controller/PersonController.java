package com.biblioteca.Controller;

import com.biblioteca.dao.PersonDAO;
import com.biblioteca.dto.PersonDTO;
import com.biblioteca.model.Person;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonController {
    private PersonDAO personDAO;

    public PersonController() {
        this.personDAO = new PersonDAO();
    }

    public void addPerson(PersonDTO personDTO) throws SQLException {
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setCpf(personDTO.getCpf());
        person.setBirthday(java.sql.Date.valueOf(personDTO.getBirthday()));
        personDAO.addPerson(person);
    }

    public List<PersonDTO> getAllPersons() throws SQLException {
        List<Person> persons = personDAO.getAllPersons();
        List<PersonDTO> personDTOs = new ArrayList<>();
        for (Person person : persons) {
            PersonDTO dto = new PersonDTO();
            dto.setId(person.getId());
            dto.setName(person.getName());
            dto.setCpf(person.getCpf());
            dto.setBirthday(person.getBirthday().toString());
            personDTOs.add(dto);
        }
        return personDTOs;
    }

    public PersonDTO getPersonById(int id) throws SQLException {
        Person person = personDAO.getPersonById(id);
        if (person != null) {
            PersonDTO dto = new PersonDTO();
            dto.setId(person.getId());
            dto.setName(person.getName());
            dto.setCpf(person.getCpf());
            dto.setBirthday(person.getBirthday().toString());
            return dto;
        }
        return null;
    }

    public void updatePerson(PersonDTO personDTO) throws SQLException {
        Person person = new Person();
        person.setId(personDTO.getId());
        person.setName(personDTO.getName());
        person.setCpf(personDTO.getCpf());
        person.setBirthday(java.sql.Date.valueOf(personDTO.getBirthday()));
        personDAO.updatePerson(person);
    }

    public void deletePerson(int id) throws SQLException {
        personDAO.deletePerson(id);
    }
}