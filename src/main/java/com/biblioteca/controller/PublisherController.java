package com.biblioteca.controller;

import com.biblioteca.dao.PublisherDAO;
import com.biblioteca.dto.PublisherDTO;
import com.biblioteca.model.Publisher;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublisherController {
    private PublisherDAO publisherDAO;

    public PublisherController() {
        this.publisherDAO = new PublisherDAO();
    }

    public void addPublisher(PublisherDTO publisherDTO) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setName(publisherDTO.getName());
        publisherDAO.addPublisher(publisher);
    }

    public List<PublisherDTO> getAllPublishers() throws SQLException {
        List<Publisher> publishers = publisherDAO.getAllPublishers();
        List<PublisherDTO> publisherDTOs = new ArrayList<>();
        for (Publisher publisher : publishers) {
            PublisherDTO dto = new PublisherDTO();
            dto.setId(publisher.getId());
            dto.setName(publisher.getName());
            publisherDTOs.add(dto);
        }
        return publisherDTOs;
    }

    public PublisherDTO getPublisherById(int id) throws SQLException {
        Publisher publisher = publisherDAO.getPublisherById(id);
        if (publisher != null) {
            PublisherDTO dto = new PublisherDTO();
            dto.setId(publisher.getId());
            dto.setName(publisher.getName());
            return dto;
        }
        return null;
    }

    public void updatePublisher(PublisherDTO publisherDTO) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setId(publisherDTO.getId());
        publisher.setName(publisherDTO.getName());
        publisherDAO.updatePublisher(publisher);
    }

    public void deletePublisher(int id) throws SQLException {
        publisherDAO.deletePublisher(id);
    }
}