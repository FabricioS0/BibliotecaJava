package com.biblioteca.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanDTO {
    private int id;
    private String loanDate;
    private String expectedReturnDate;
    private String returnDate;
}