package com.biblioteca.model;

import com.biblioteca.Enums.Permission;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int id;
    private String username;
    private	String name;
    private String password;
    private Permission permission;

    public User(String username, String name, String password, Permission permission) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.permission = permission;
    }

    public User() {
    }
}
