package com.codingblocks.androidtests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by championswimmer on 30/07/16.
 */
public class FareTest {



    @Test
    public void testFareFromKmAndTime() {
        assertEquals(35, MainActivity.getFare(3, 16), 0.001);
        assertEquals(0, MainActivity.getFare(-3, 16), 0.001);
    }
}
