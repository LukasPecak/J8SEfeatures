package org.lukas.javach;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Lukas on 30.06.2017.
 *
 * @author Lukas Pecak
 */
public class DateTimeApiTest {
    private Logger log = LoggerFactory.getLogger(DateTimeApiTest.class.getSimpleName());

    @Test
    public void testComputeProgrammerDay() {
        log.info("Performing programmers Day calculation test including one leap year");
        DateTimeApi dateTimeApi = new DateTimeApi();

        LocalDate programmersDay2017 = dateTimeApi.computeProgrammersDay(2017);
        log.info("The programmer day of " + 2017 + " is : " + programmersDay2017);
        assertEquals(LocalDate.of(2017, Month.SEPTEMBER, 13), programmersDay2017);

        LocalDate programmersDay2018 = dateTimeApi.computeProgrammersDay(2018);
        log.info("The programmer day of " + 2018 + " is : " + programmersDay2018);
        assertEquals(LocalDate.of(2018, Month.SEPTEMBER, 13), programmersDay2018);

        LocalDate programmersDay2019 = dateTimeApi.computeProgrammersDay(2019);
        log.info("The programmer day of " + 2019 + " is : " + programmersDay2019);
        assertEquals(LocalDate.of(2019, Month.SEPTEMBER, 13), programmersDay2019);

        LocalDate programmersDay2020 = dateTimeApi.computeProgrammersDay(2020);
        log.info("The programmer day of " + 2020 + " is : " + programmersDay2020);
        assertEquals(LocalDate.of(2020, Month.SEPTEMBER, 12), programmersDay2020);
    }

    @Test
    public void testForZeroYear() {
        int year = 0;
        log.info("Performing test for the year " + year);
        try {
            LocalDate programmersDay0 = new DateTimeApi().computeProgrammersDay(year);
            log.info("Programmers day for year " + year + " is : " + programmersDay0);
        } catch (Exception exception) {
            fail();
        }
    }

    @Test
    public void testForNegativeYear() {
        int year = -30000;
        log.info("Performing test for the year " + year);
        try {
            LocalDate programmersDay0 = new DateTimeApi().computeProgrammersDay(year);
            log.info("Programmers day for year " + year + " is : " + programmersDay0);
        } catch (Exception exception) {
            fail();
        }
    }

    @Test
    public void testPlusYearsResultLeapYear() {
        DateTimeApi dateTimeApi = new DateTimeApi();
        log.info("2000-02-29 plus 1 year : " + dateTimeApi.addYears(1L));
        assertEquals(LocalDate.of(2001, 2, 28), dateTimeApi.addYears(1L));
        assertEquals(LocalDate.of(2002, 2, 28), dateTimeApi.addYears(2L));
        assertEquals(LocalDate.of(2003, 2, 28), dateTimeApi.addYears(3L));
        assertEquals(LocalDate.of(2005, 2, 28), dateTimeApi.addYears(5L));
    }

    @Test
    public void testPlusYearsResultNonLeapYear() {
        DateTimeApi dateTimeApi = new DateTimeApi();
        log.info("2004-02-29 plus 4 year : " + dateTimeApi.addYears(4L));
        assertEquals(LocalDate.of(2000, 2, 29), dateTimeApi.addYears(0L));
        assertEquals(LocalDate.of(2004, 2, 29), dateTimeApi.addYears(4L));
    }

    @Test
    public void testPlusYearsResultLeapYearFourTimeOneYear() {
        DateTimeApi dateTimeApi = new DateTimeApi();
        LocalDate resultDate = dateTimeApi.addYears(0L)
                .plusYears(1L)
                .plusYears(1L)
                .plusYears(1L)
                .plusYears(1L);
        log.info("2000-02-29 plus 4 times 1 year : " + resultDate);
        log.info("This is because the last plusYears adds to the date 2003-02-28 that must yield to the same date one year later");
        assertEquals(LocalDate.of(2004, 2, 28), resultDate);
    }

    @Test
    public void testNextAdjuster() {
        DateTimeApi dateTimeApi = new DateTimeApi();
        final LocalDate startDate = LocalDate.of(2017, 7, 8);
        log.info("Today is " + startDate + ". The next working day is : " +
                startDate.with(dateTimeApi.next(w -> w.getDayOfWeek().getValue() < 6)));

        LocalDate friday = LocalDate.of(2017, 7, 7);
        LocalDate monday = LocalDate.of(2017, 7, 10);

        assertEquals(friday, friday.with(dateTimeApi.next(w -> w.getDayOfWeek().getValue() < 6)));
        assertEquals(monday, LocalDate.of(2017, 7, 8).with(dateTimeApi.next(w -> w.getDayOfWeek().getValue() < 6)));
        assertEquals(monday, LocalDate.of(2017, 7, 9).with(dateTimeApi.next(w -> w.getDayOfWeek().getValue() < 6)));
        assertEquals(monday, LocalDate.of(2017, 7, 10).with(dateTimeApi.next(w -> w.getDayOfWeek().getValue() < 6)));

        assertEquals(LocalDate.of(2017, 7, 12), friday.with(dateTimeApi.next(w -> w.getDayOfWeek().equals(DayOfWeek.WEDNESDAY))));

    }

    @Test
    public void printAllFriday13inXXcentury() {
        List<LocalDate> allFriday13inXXcentury = new DateTimeApi().getAllFriday13inXXcentury();
        allFriday13inXXcentury.stream().map(date -> date.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy"))).forEach(System.out::println);
        System.out.println(String.format("There are %d Fridays the 13ht in the XX century", allFriday13inXXcentury.size()));
    }

}