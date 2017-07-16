package org.lukas.javach;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Created by Lukas on 15.07.2017.
 *
 * @author Lukas Pecak
 */
public class DaysAlive {
    private static final Logger log = LoggerFactory.getLogger(DaysAlive.class);

    public static void main(String[] args) {
        if (args.length != 1) {
            log.info("Wrong input arguments. Please specify your birthday in format dd-MM-yyyy as argument");
            return;
        }
        LocalDate birthday = null;
        try {
            birthday = LocalDate.parse(args[0], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException exception) {
            log.info("Wrong birthday date pattern. Please use date in format dd-MM-yyyy : for example 07-07-2017");
        }
        String daysAliveMessage = String.format("You are alive for %d days", new DateTimeApi().countDaysAlive(birthday));
        log.info(daysAliveMessage);
    }
}
