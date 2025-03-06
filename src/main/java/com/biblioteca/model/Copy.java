package com.biblioteca.model;


import com.biblioteca.Enums.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Copy {
    private int id;
    private Status status;
    private String identifier;

    public Copy(Status status, String identifier) {
        this.status = status;
        this.identifier = identifier;
    }

    public Copy() {}
}
