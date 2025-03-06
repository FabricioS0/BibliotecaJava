package com.biblioteca.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
    private int id;
    private String title;
    private String description;
    private String edition;
    private String publicationDate;
    private String isbn;
}