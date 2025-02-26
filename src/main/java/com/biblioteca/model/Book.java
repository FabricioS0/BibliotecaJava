// Book.java
package com.biblioteca.model;
import lombok.*;

import java.util.Date;

@Getter
@Setter
public class Book {
    private int id;
    private String title;
    private String description;
    private String edition;
    private Date publicationDate;
    private String isbn;

    public Book() {}

    public Book(int id, String title, String description, String edition, Date publicationDate, String isbn) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.edition = edition;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
    }

}