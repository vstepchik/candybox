package com.gmail.vitalatron.game.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


public class NumberUtilsTest {


    @RunWith(Parameterized.class)
    public static class NumberUtilsDigitCountTest {
        public int number;
        public int digits;

        public NumberUtilsDigitCountTest(int number, int digits) {
            this.number = number;
            this.digits = digits;
        }

        @Parameterized.Parameters(name = "{index}: digitCount({0})=={1}")
        public static Collection digitCountNumbers() {
            return Arrays.asList(new Object[][]{
                    {Integer.MIN_VALUE, 10},
                    {-1000000000, 10},
                    {-999999999, 9},
                    {-100000000, 9},
                    {-99999999, 8},
                    {-10000000, 8},
                    {-9999999, 7},
                    {-1000000, 7},
                    {-999999, 6},
                    {-100000, 6},
                    {-99999, 5},
                    {-10000, 5},
                    {-9999, 4},
                    {-1000, 4},
                    {-999, 3},
                    {-100, 3},
                    {-99, 2},
                    {-10, 2},
                    {-9, 1},
                    {-1, 1},
                    {0, 1},
                    {1, 1},
                    {9, 1},
                    {10, 2},
                    {99, 2},
                    {100, 3},
                    {999, 3},
                    {1000, 4},
                    {9999, 4},
                    {10000, 5},
                    {99999, 5},
                    {100000, 6},
                    {999999, 6},
                    {1000000, 7},
                    {9999999, 7},
                    {10000000, 8},
                    {99999999, 8},
                    {100000000, 9},
                    {999999999, 9},
                    {1000000000, 10},
                    {Integer.MAX_VALUE, 10},
            });
        }

        @Test
        public void testDigitCount() throws Exception {
            assertEquals(digits, NumberUtils.digitCount(number));
        }
    }

}