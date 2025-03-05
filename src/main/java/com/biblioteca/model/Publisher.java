package com.biblioteca.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Publisher {
    private int id;
    private String name;

    public Publisher(String name) {
        this.name = name;
    }

    public Publisher() {
    }
}
