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
    private String isbn;
    
    public Book(String title, String description, String edition, Date publicationDate, String isbn) {
        this.title = title;
        this.description = description;
        this.edition = edition;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
    }

    public Book(int id, String title, String description, String edition, Date publicationDate, String isbn) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.edition = edition;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
    }

    public Book() {
    }
}