package com.biblioteca.service;

import com.biblioteca.dao.CategoryDAO;
import com.biblioteca.model.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    private CategoryDAO categoryDAO = new CategoryDAO();

    public void addCategory(Category category) throws SQLException {
        categoryDAO.save(category);
    }

    public Category getCategory(int id) throws SQLException {
        return categoryDAO.findById(id);
    }

    public List<Category> getAllCategories() throws SQLException {
        return categoryDAO.findAll();
    }

    public void updateCategory(Category category) throws SQLException {
        categoryDAO.update(category);
    }

    public void deleteCategory(Category category) throws SQLException {
        categoryDAO.delete(category);
    }
}