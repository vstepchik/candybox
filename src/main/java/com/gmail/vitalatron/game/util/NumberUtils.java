package com.gmail.vitalatron.game.util;

public final class NumberUtils {

    private NumberUtils() {
        // empty
    }

    public static int digitCount(int value) {
        if (value < 0) {
            if (value == Integer.MIN_VALUE) {
                return 10;
            }
            value = -value;
        }
        return (value < 100000)
                ? (value < 100)
                ? (value < 10) ? 1 : 2
                : (value < 1000)
                ? 3
                : (value < 10000) ? 4 : 5
                : (value < 10000000)
                ? (value < 1000000) ? 6 : 7
                : (value < 100000000)
                ? 8
                : (value < 1000000000) ? 9 : 10;
    }

}