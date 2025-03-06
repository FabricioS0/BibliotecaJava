package com.biblioteca.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Copy {
    private int id;
    private String status;
    private String identifier;

    public Copy(String status, String identifier) {
        this.status = status;
        this.identifier = identifier;
    }

    public Copy() {}
}
