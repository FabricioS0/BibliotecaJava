package com.biblioteca.service;

import com.biblioteca.dao.CopyDAO;
import com.biblioteca.model.Copy;

import java.sql.SQLException;
import java.util.List;

public class CopyService {
    private CopyDAO copyDAO = new CopyDAO();

    public void addCopy(Copy copy) throws SQLException {
        copyDAO.save(copy);
    }

    public Copy getCopy(int id) throws SQLException {
        return copyDAO.findById(id);
    }

    public List<Copy> getAllCopies() throws SQLException {
        return copyDAO.findAll();
    }

    public Copy getByTitleBook(String title) throws SQLException {
        return copyDAO.findByTitleBook(title);
    }

    public void updateCopy(Copy copy) throws SQLException {
        copyDAO.update(copy);
    }

    public void deleteCopy(Copy copy) throws SQLException {
        copyDAO.delete(copy);
    }
}