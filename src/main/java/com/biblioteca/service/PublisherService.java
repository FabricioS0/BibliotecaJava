package com.biblioteca.service;

import com.biblioteca.dao.PublisherDAO;
import com.biblioteca.model.Publisher;

import java.sql.SQLException;
import java.util.List;

public class PublisherService {
    private PublisherDAO publisherDAO = new PublisherDAO();

    public void addPublisher(Publisher publisher) throws SQLException {
        publisherDAO.save(publisher);
    }

    public Publisher getPublisher(int id) throws SQLException {
        return publisherDAO.findById(id);
    }

    public List<Publisher> getAllPublishers() throws SQLException {
        return publisherDAO.findAll();
    }

    public void updatePublisher(Publisher publisher) throws SQLException {
        publisherDAO.update(publisher);
    }

    public void deletePublisher(Publisher publisher) throws SQLException {
        publisherDAO.delete(publisher);
    }
}