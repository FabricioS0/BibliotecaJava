// Publisher.java
package com.biblioteca.model;
import lombok.*;

@Getter
@Setter
public class Publisher {
    private int id;
    private String name;

    public Publisher() {}

    public Publisher(int id, String name) {
        this.id = id;
        this.name = name;
    }
}