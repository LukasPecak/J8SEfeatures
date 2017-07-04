package org.lukas.javach;

import java.time.LocalDate;

/**
 * Created by Lukas on 30.06.2017.
 *
 * @author Lukas Pecak
 */
class DateTimeApi {
    LocalDate computeProgrammersDay(int year) {
        return LocalDate.ofYearDay(year, 256);
    }
}
