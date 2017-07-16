package org.lukas.javach;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
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

    /**
     * Method count how many days is alive until today based on the birthday date
     *
     * @param birthDay Birthday date used for calculation
     * @return Count of days that elapsed from birthday inclusive till today exclusive
     */
    long countDaysAlive(LocalDate birthDay) {
        return ChronoUnit.DAYS.between(birthDay, LocalDate.now());
    }

    /**
     * List all Friday the 13th in the twentieth century.
     */
    List<LocalDate> getAllFriday13inXXcentury() {
        final List<LocalDate> result = new ArrayList<>();
        LocalDate currentDate = LocalDate.of(1900, 1, 13);
        for (currentDate.getYear(); currentDate.getYear() < 2000; currentDate = currentDate.plusMonths(1L)) {
            if (currentDate.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                result.add(currentDate);
            }
        }
        return result;
    }
}
