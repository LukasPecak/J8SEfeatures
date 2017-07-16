package org.lukas.javach;

import org.junit.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;

/**
 * Created by Lukas on 16.07.2017.
 *
 * @author Lukas Pecak
 */
public class TimeIntervalTest {

    @Test
    public void doesTimeIntervalOverlap() throws Exception {
        TimeInterval first = TimeInterval.of(LocalDate.now(), LocalTime.of(13, 0), LocalTime.of(14, 0));
        TimeInterval overlapping = TimeInterval.of(LocalDate.now(), LocalTime.NOON, LocalTime.of(13, 10));
        TimeInterval nonOverlapping = TimeInterval.of(LocalDate.now(), LocalTime.of(15, 10), LocalTime.of(16, 30));
        assertTrue("Intervals overlap", first.doesTimeIntervalOverlap(overlapping));
        assertFalse("Intervals non overlap", first.doesTimeIntervalOverlap(nonOverlapping));
    }

}