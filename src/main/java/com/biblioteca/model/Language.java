package com.biblioteca.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Language {
    private int id;
    private String acronym;
    private String name;

    public Language(String acronym, String name) {
        this.acronym = acronym;
        this.name = name;
    }

    public Language() {
    }
}
