package org.lukas.javach;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Lukas on 04.07.2017.
 *
 * @author Lukas Pecak
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
        DateTimeApiTest.class,
        CalTest.class
})
public class TestSuit {}
