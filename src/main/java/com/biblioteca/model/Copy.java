// Copy.java
package com.biblioteca.model;
import lombok.*;

@Getter
@Setter
public class Copy {
    private int id;
    private String status;
    private String identifier;
    private int bookId;

    public Copy() {}
    
    public Copy(int id, String status, String identifier, int bookId) {
        this.id = id;
        this.status = status;
        this.identifier = identifier;
        this.bookId = bookId;
    }
}