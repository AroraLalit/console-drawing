package com.cs.consoledrawing.app;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author Lalit Arora
 */

public class ApplicationTest {

    /*
     * Trying out to test main method. which might be done using system-rules
     * api but Improvement needed here.
     */

    @Test
    @Tag("IntegrationTest")
    @Disabled
    public void testMain() throws FileNotFoundException {
        System.out.println("main");
        String[] args = null;
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(new File("src/test/resources/testInput/commands.txt"));
        System.setIn(fips);
        ConsoleDrawingApplication.main(args);
        System.setIn(original);
    }

}