package com.biblioteca.model;
import lombok.*;

import java.util.Date;

@Getter
@Setter
public class Loan {
    private int id;
    private Date loanDate;
    private Date expectedReturnDate;
    private Date returnDate;
    private int personId;
    private int copyId;
    
    public Loan() {
    }

    public Loan(int id, Date loanDate, Date expectedReturnDate, Date returnDate, int personId, int copyId) {
        this.id = id;
        this.loanDate = loanDate;
        this.expectedReturnDate = expectedReturnDate;
        this.returnDate = returnDate;
        this.personId = personId;
        this.copyId = copyId;
    }
}