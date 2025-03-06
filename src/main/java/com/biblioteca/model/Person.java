package com.biblioteca.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter	
@Setter
public class Person {
    private int id;
    private String name;
    private String cpf;
    private Date birthday;

    public Person(String name, String cpf, Date birthday) {
        this.name = name;
        this.cpf = cpf;
        this.birthday = birthday;
    }

    public Person() {
    }
}
