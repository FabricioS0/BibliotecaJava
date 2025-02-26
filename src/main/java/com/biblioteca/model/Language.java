// Language.java
package com.biblioteca.model;
import lombok.*;

@Getter
@Setter
public class Language {
    private int id;
    private String acronym;
    private String name;

    public Language() {
    }

    public Language(int id, String acronym, String name) {
        this.id = id;
        this.acronym = acronym;
        this.name = name;
    }
}