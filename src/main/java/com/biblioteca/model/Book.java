package com.biblioteca.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private int id;
    private String title;
    private String description;
    private String edition;
    private Date publicationDate;
    private int isbn;
    
    public Book(String title, String description, String edition, Date publicationDate, int isbn) {
        this.title = title;
        this.description = description;
        this.edition = edition;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
    }

    public Book() {
    }
}