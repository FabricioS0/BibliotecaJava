package com.biblioteca.service;

import com.biblioteca.dao.UserDAO;
import com.biblioteca.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public void addUser (User user) throws SQLException {
        userDAO.save(user);
    }

    public User getUser (int id) throws SQLException {
        return userDAO.findById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDAO.findAll();
    }

    public void updateUser (User user) throws SQLException {
        userDAO.update(user);
    }

    public void deleteUser (User user) throws SQLException {
        userDAO.delete(user);
    }
}