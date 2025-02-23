// Person.java
package com.biblioteca.model;
import lombok.*;

import java.util.Date;

@Getter
@Setter
public class Person {
    private int id;
    private String name;
    private String cpf;
    private Date birthday;

    public Person() {
    }

    public Person(int id, String name, String cpf, Date birthday) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.birthday = birthday;
    }

    
}
