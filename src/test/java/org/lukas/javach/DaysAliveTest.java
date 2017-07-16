package org.lukas.javach;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

/**
 * Created by Lukas on 16.07.2017.
 *
 * @author Lukas Pecak
 */
public class DaysAliveTest {

    @Test
    public void testDaysAlive() {
        DaysAlive.main(new String[]{"10-12-1981"});
        DaysAlive.main(new String[]{"11-12-1981"});
        DaysAlive.main(new String[]{LocalDate.now().minusDays(1L).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))});
    }

}