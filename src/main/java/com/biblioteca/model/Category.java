package com.biblioteca.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private int id;
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }
}
