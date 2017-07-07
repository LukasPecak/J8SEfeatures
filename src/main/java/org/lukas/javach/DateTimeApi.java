package org.lukas.javach;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

/**
 * Created by Lukas on 30.06.2017.
 *
 * @author Lukas Pecak
 */
class DateTimeApi {
    /**
     * Compute Programmers's Day without using plusDays method
     */
    LocalDate computeProgrammersDay(int year) {
        return LocalDate.ofYearDay(year, 256);
    }

    /**
     * What happens when you add one year to LocalDate.of(2000, 2, 29)? Four years ?
     */
    LocalDate addYears(long years) {
        return LocalDate.of(2000, 2, 29).plusYears(years);
    }

    /**
     * Implement a method next that takes a Predicate<LocalDate> and returns an adjuster yielding the next date fulfilling the predicate.
     * For example, today.with(next(w -> getDayOfWeek().getValue() < 6))
     */
    TemporalAdjuster next(Predicate<LocalDate> predicate) {
        return TemporalAdjusters.ofDateAdjuster(date -> {
            while (!predicate.test(date)) {
                date = date.plusDays(1L);
            }
            return date;
        });
    }
}
