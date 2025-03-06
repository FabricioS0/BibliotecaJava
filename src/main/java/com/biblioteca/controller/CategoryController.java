package com.biblioteca.controller;

import com.biblioteca.model.Category;
import com.biblioteca.service.CategoryService;

import java.sql.SQLException;
import java.util.List;

public class CategoryController {
    private CategoryService categoryService = new CategoryService();

    public void createCategory(String name) throws SQLException {
        Category category = new Category(name);
        categoryService.addCategory(category);
    }

    public Category getCategory(int id) throws SQLException {
        return categoryService.getCategory(id);
    }

    public List<Category> getAllCategories() throws SQLException {
        return categoryService.getAllCategories();
    }

    public void updateCategory(int id, String name) throws SQLException {
        Category category = new Category(name);
        category.setId(id);
        categoryService.updateCategory(category);
    }

    public void deleteCategory(int id) throws SQLException {
        Category category = new Category();
        category.setId(id);
        categoryService.deleteCategory(category);
    }
}