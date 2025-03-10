package com.biblioteca.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private int id;
    private String username;
    private String name;
    private String password;
    private String permission;
}