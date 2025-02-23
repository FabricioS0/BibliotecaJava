// User.java
package com.biblioteca.model;
import lombok.*;

@Getter
@Setter
public class User {
    private int id;
    private String username;
    private String name;
    private String password; // Armazenar criptografado
    private String permission;
    private int personId;

    public User() {}

    public User(int id, String username, String name, String password, String permission, int personId) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.permission = permission;
        this.personId = personId;
    }
}
