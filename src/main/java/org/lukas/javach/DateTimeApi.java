package org.lukas.javach;

import java.time.LocalDate;

/**
 * Created by Lukas on 30.06.2017.
 *
 * @author Lukas Pecak
 */
class DateTimeApi {
    /**
     *  Compute Programmers's Day without using plusDays method
     */
    LocalDate computeProgrammersDay(int year) {
        return LocalDate.ofYearDay(year, 256);
    }

    /**
     *  What happens when you add one year to LocalDate.of(2000, 2, 29)? Four years ?
     */
    LocalDate addYears(long years) {
        return LocalDate.of(2000, 2, 29).plusYears(years);
    }
}
