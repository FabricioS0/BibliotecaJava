package com.biblioteca.dto;

import java.time.LocalDate;
import java.util.Date;

public class BookDTO {
    private int id;
    private String title;
    private String description;
    private String edition;
    private Date publicationDate; // Usar String para facilitar a manipulação na UI
    private String isbn;

    public BookDTO(int id, String title, String description, String edition, Date dataPublicacao, String isbn) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.edition = edition;
        this.publicationDate = dataPublicacao;
        this.isbn = isbn;
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}