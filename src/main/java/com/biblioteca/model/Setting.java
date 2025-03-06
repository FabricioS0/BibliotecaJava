package com.biblioteca.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Setting {
    private double initialFine;
    private double dailyFine;
    private int daysForReturn;
    private int loansPerPerson;

    public Setting(double initialFine, double dailyFine, int daysForReturn, int loansPerPerson) {
        this.initialFine = initialFine;
        this.dailyFine = dailyFine;
        this.daysForReturn = daysForReturn;
        this.loansPerPerson = loansPerPerson;
    }

    public Setting() {
    }
}
