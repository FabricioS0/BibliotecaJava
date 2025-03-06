package com.biblioteca.controller;

import com.biblioteca.Enums.Status;
import com.biblioteca.model.Copy;
import com.biblioteca.service.CopyService;

import java.sql.SQLException;
import java.util.List;

public class CopyController {
    private CopyService copyService = new CopyService();

    public void createCopy(String status, String identifier) throws SQLException {
        Copy copy = new Copy(status, identifier);
        copyService.addCopy(copy);
    }

    public Copy getCopy(int id) throws SQLException {
        return copyService.getCopy(id);
    }

    public List<Copy> getAllCopies() throws SQLException {
        return copyService.getAllCopies();
    }

    public Copy getByTitleBook(String title) throws SQLException {
        return copyService.getByTitleBook(title);
    }

    public void updateCopy(int id, String status, String identifier) throws SQLException {
        Copy copy = new Copy(status, identifier);
        copy.setId(id);
        copyService.updateCopy(copy);
    }

    public void deleteCopy(int id) throws SQLException {
        Copy copy = new Copy();
        copy.setId(id);
        copyService.deleteCopy(copy);
    }
}