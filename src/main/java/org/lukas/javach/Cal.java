package org.lukas.javach;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Lukas on 13.07.2017.
 *
 * @author Lukas Pecak
 *
 * Write an equivalent of the Unix cal program that displays a calendar for a month. For example, java Cal 3 2013
 */
public class Cal {
    private static final Logger log = LoggerFactory.getLogger(Cal.class);

    private static final String SPACES = "                    ";
    private static final String WEEK_DAYS_HEADER = "Su Mo Tu We Th Fr Sa";

    public static void main(String[] args) {
        if (args.length != 0 && args.length != 2) {
            log.error("Wrong arguments. Execute using non argument for current month or Cal <month number> <year> (Cal 7 2017)");
            return;
        }
        Cal cal = new Cal();
        LocalDate now = LocalDate.now();
        Month month = now.getMonth();
        int year = now.getYear();

        if (args.length == 2) {
            try {
                month = cal.getRequestedMonth(args[0]);
                year = cal.getRequestedYear(args[1]);
            } catch (RuntimeException exception) {
                log.error(exception.getMessage());
                return;
            }
        }

        log.info(cal.getMonthHeader(month, year));
        log.info(WEEK_DAYS_HEADER);
        for (String week : cal.getWeeks(month, year)) {
            log.info(week);
        }

    }

    private Month getRequestedMonth(String input) {
        int month = Integer.parseInt(input);
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("The month must be a number in range 1-12");
        }
        return Month.of(month);
    }

    private int getRequestedYear(String input) {
        return Integer.parseInt(input);
    }

    private String getMonthHeader(Month month, int year) {
        String header = month.getDisplayName(TextStyle.FULL, Locale.US) + " " + year;
        return SPACES.substring(0, (20 - header.length()) / 2) + header;
    }

    private List<String> getWeeks(Month month, int year) {
        List<String> weeks = new ArrayList<>();
        LocalDate day = LocalDate.of(year, month, 1);

        StringBuilder currentWeek = new StringBuilder();
        int offset = (day.getDayOfWeek().getValue() * 3) % 21;
        currentWeek.append(SPACES.substring(0, offset));

        while (day.getMonth().equals(month)) {
            int dayOfMonth = day.getDayOfMonth();
            currentWeek.append(dayOfMonth > 9 ? dayOfMonth : " " + dayOfMonth);
            currentWeek.append(" ");
            if (day.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
                weeks.add(currentWeek.toString());
                currentWeek = new StringBuilder();
            }
            day = day.plusDays(1L);
        }
        if (!currentWeek.toString().equals(weeks.get(weeks.size() - 1))) {
            weeks.add(currentWeek.toString());
        }
        return weeks;
    }
}
