package com.biblioteca.controller;

import com.biblioteca.dao.CategoryDAO;
import com.biblioteca.dto.CategoryDTO;
import com.biblioteca.model.Category;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryController {
    private CategoryDAO categoryDAO;

    public CategoryController() {
        this.categoryDAO = new CategoryDAO();
    }

    public void addCategory(CategoryDTO categoryDTO) throws SQLException {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        categoryDAO.addCategory(category);
    }

    public List<CategoryDTO> getAllCategories() throws SQLException {
        List<Category> categories = categoryDAO.getAllCategories();
        List<CategoryDTO> categoryDTOs = new ArrayList<>();
        for (Category category : categories) {
            CategoryDTO dto = new CategoryDTO();
            dto.setId(category.getId());
            dto.setName(category.getName());
            categoryDTOs.add(dto);
        }
        return categoryDTOs;
    }

    public CategoryDTO getCategoryById(int id) throws SQLException {
        Category category = categoryDAO.getCategoryById(id);
        if (category != null) {
            CategoryDTO dto = new CategoryDTO();
            dto.setId(category.getId());
            dto.setName(category.getName());
            return dto;
        }
        return null;
    }

    public void updateCategory(CategoryDTO categoryDTO) throws SQLException {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        categoryDAO.updateCategory(category);
    }

    public void deleteCategory(int id) throws SQLException {
        categoryDAO.deleteCategory(id);
    }
}