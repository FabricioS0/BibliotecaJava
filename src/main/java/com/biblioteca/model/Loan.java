package com.biblioteca.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Loan {
    private int id;
    private Date loanDate;
    private Date expectedReturnDate;
    private Date returnDate;

    public Loan(Date loanDate, Date expectedReturnDate, Date returnDate) {
        this.loanDate = loanDate;
        this.expectedReturnDate = expectedReturnDate;
        this.returnDate = returnDate;
    }

    public Loan() {
    }
}
