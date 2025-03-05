package com.biblioteca.controller;

import com.biblioteca.Enums.Permission;
import com.biblioteca.model.User;
import com.biblioteca.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserController {
    private UserService userService = new UserService();

    public void createUser (String username, String name, String password, String permission) throws SQLException {
        User user = new User(username, name, password, Permission.valueOf(permission));
        userService.addUser (user);
    }

    public User getUser (int id) throws SQLException {
        return userService.getUser (id);
    }

    public List<User> getAllUsers() throws SQLException {
        return userService.getAllUsers();
    }

    public void updateUser (int id, String username, String name, String password, String permission) throws SQLException {
        User user = new User(username, name, password, Permission.valueOf(permission));
        user.setId(id);
        userService.updateUser (user);
    }

    public void deleteUser (int id) throws SQLException {
        User user = new User();
        user.setId(id);
        userService.deleteUser (user);
    }
}