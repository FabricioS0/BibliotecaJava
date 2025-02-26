// Category.java
package com.biblioteca.model;
import lombok.*;

@Getter
@Setter
public class Category {
    private int id;
    private String name;
    
    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
}