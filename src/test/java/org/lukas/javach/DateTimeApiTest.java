package org.lukas.javach;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

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
        assertTrue(LocalDate.of(2017, Month.SEPTEMBER, 13).equals(programmersDay2017));
        LocalDate programmersDay2018 = dateTimeApi.computeProgrammersDay(2018);
        log.info("The programmer day of " + 2018 + " is : " + programmersDay2018);
        assertTrue(LocalDate.of(2018, Month.SEPTEMBER, 13).equals(programmersDay2018));
        LocalDate programmersDay2019 = dateTimeApi.computeProgrammersDay(2019);
        log.info("The programmer day of " + 2019 + " is : " + programmersDay2019);
        assertTrue(LocalDate.of(2019, Month.SEPTEMBER, 13).equals(programmersDay2019));
        LocalDate programmersDay2020 = dateTimeApi.computeProgrammersDay(2020);
        log.info("The programmer day of " + 2020 + " is : " + programmersDay2020);
        assertTrue(LocalDate.of(2020, Month.SEPTEMBER, 12).equals(programmersDay2020));
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

}