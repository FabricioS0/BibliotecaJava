package com.biblioteca.controller;

import com.biblioteca.dao.UserDAO;
import com.biblioteca.dto.UserDTO;
import com.biblioteca.model.User;
import com.biblioteca.utils.EncryptionUtil; // Certifique-se de que você tem essa classe para criptografia

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    private UserDAO userDAO;

    public UserController() {
        this.userDAO = new UserDAO();
    }

    public void addUser (UserDTO userDTO) throws SQLException {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setName(userDTO.getName());
        user.setPassword(EncryptionUtil.encrypt(userDTO.getPassword())); // Criptografar antes de armazenar
        user.setPermission(userDTO.getPermission());
        user.setPersonId(userDTO.getPersonId());
        userDAO.addUser (user);
    }

    public List<UserDTO> getAllUsers() throws SQLException {
        List<User> users = userDAO.getAllUsers();
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User  user : users) {
            UserDTO dto = new UserDTO();
            dto.setId(user.getId());
            dto.setUsername(user.getUsername());
            dto.setName(user.getName());
            dto.setPassword(user.getPassword());
            dto.setPermission(user.getPermission());
            dto.setPersonId(user.getPersonId());
            userDTOs.add(dto);
        }
        return userDTOs;
    }

    public UserDTO getUserById(int id) throws SQLException {
        User user = userDAO.getUserById(id);
        if (user != null) {
            UserDTO dto = new UserDTO();
            dto.setId(user.getId());
            dto.setUsername(user.getUsername());
            dto.setName(user.getName());
            dto.setPassword(user.getPassword());
            dto.setPermission(user.getPermission());
            dto.setPersonId(user.getPersonId());
            return dto;
        }
        return null;
    }

    public void updateUser (UserDTO userDTO) throws SQLException {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setName(userDTO.getName());
        user.setPassword(EncryptionUtil.encrypt(userDTO.getPassword())); // Criptografar antes de armazenar
        user.setPermission(userDTO.getPermission());
        user.setPersonId(userDTO.getPersonId());
        userDAO.updateUser (user);
    }

    public void deleteUser (int id) throws SQLException {
        userDAO.deleteUser (id);
    }

    public boolean login(String username, String password) {
        // Criptografa a senha fornecida para comparação
        String encryptedPassword = EncryptionUtil.encrypt(password);
        return userDAO.login(username, encryptedPassword);
    }
}