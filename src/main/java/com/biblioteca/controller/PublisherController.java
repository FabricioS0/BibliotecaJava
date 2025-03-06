package com.biblioteca.controller;

import com.biblioteca.model.Publisher;
import com.biblioteca.service.PublisherService;

import java.sql.SQLException;
import java.util.List;

public class PublisherController {
    private PublisherService publisherService = new PublisherService();

    public void createPublisher(String name) throws SQLException {
        Publisher publisher = new Publisher(name);
        publisherService.addPublisher(publisher);
    }

    public Publisher getPublisher(int id) throws SQLException {
        return publisherService.getPublisher(id);
    }

    public List<Publisher> getAllPublishers() throws SQLException {
        return publisherService.getAllPublishers();
    }

    public void updatePublisher(int id, String name) throws SQLException {
        Publisher publisher = new Publisher(name);
        publisher.setId(id);
        publisherService.updatePublisher(publisher);
    }

    public void deletePublisher(int id) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setId(id);
        publisherService.deletePublisher(publisher);
    }
}