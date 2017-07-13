package org.lukas.javach;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lukas on 13.07.2017.
 *
 * @author Lukas Pecak
 */
public class CalTest {
    @Test
    public void forCurrentMonth() {
        Cal.main(new String[0]);
    }

    @Test
    public void forFutureDate() {
        Cal.main(new String[]{"10", "2222"});
    }

    @Test
    public void forPastDate() {
        Cal.main(new String[]{"1", "102"});
    }

    @Test
    public void forMonthOutOfRange() {
        Cal.main(new String[]{"15", "2017"});
    }

    @Test
    public void forUnparsableInput() {
        Cal.main(new String[]{"r", "r"});
    }

    @Test
    public void forWrongArgumentNumberInput() {
        Cal.main(new String[]{"4"});
    }

}