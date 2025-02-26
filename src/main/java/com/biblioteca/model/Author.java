// Author.java
package com.biblioteca.model;
import lombok.*;

@Getter
@Setter
public class Author {
    private int id;
    private String name;

    public Author() {
    }

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }
}