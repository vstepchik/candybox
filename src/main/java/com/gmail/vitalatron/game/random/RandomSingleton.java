package com.gmail.vitalatron.game.random;

import org.apache.commons.math3.random.RandomDataGenerator;

public class RandomSingleton {
    private final static SynchronizedRandomDataGenerator random = new SynchronizedRandomDataGenerator();

    static {
        random.reSeed(System.nanoTime());
    }

    public static RandomDataGenerator get() {
        return random;
    }
}
