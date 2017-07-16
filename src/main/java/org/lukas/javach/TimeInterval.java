package org.lukas.javach;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Lukas on 16.07.2017.
 *
 * @author Lukas Pecak
 */
class TimeInterval {
    private LocalDate date;
    private LocalTime begin;
    private LocalTime end;

    static TimeInterval of(LocalDate date, LocalTime begin, LocalTime end) {
        return new TimeInterval(date, begin, end);
    }

    private TimeInterval(LocalDate date, LocalTime begin, LocalTime end) {
        this.date = date;
        this.begin = begin;
        this.end = end;
    }

    boolean doesTimeIntervalOverlap(TimeInterval interval) {
        boolean precondition = !(interval == null || !date.equals(interval.date));
        if (!precondition) {
            return false;
        }
        boolean beginInInterval = begin.isAfter(interval.begin) && begin.isBefore(interval.end);
        boolean endInInterval = end.isAfter(interval.begin) && end.isBefore(interval.end);

        return beginInInterval || endInInterval;
    }
}
