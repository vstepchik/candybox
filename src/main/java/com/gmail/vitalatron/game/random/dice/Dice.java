package com.gmail.vitalatron.game.random.dice;

import com.gmail.vitalatron.game.random.RandomSingleton;
import com.gmail.vitalatron.game.util.NumberUtils;

/**
 * Class that simulates gaming dice.
 * <p/>
 * <p/>
 * Uses {@link com.gmail.vitalatron.game.random.RandomSingleton} as random source.
 * <p/>
 * Immutable class.
 */
public class Dice implements Comparable<Dice> {

    private final int sides;

    private final int score;

    private String stringValue;


    public Dice(int sides) {
        if (sides < 1) {
            throw new IllegalArgumentException("Number of sides cant be < 1");
        }

        this.sides = sides;
        this.score = RandomSingleton.get().nextInt(1, this.sides);
    }

    /**
     * Performs dice roll.
     * <p/>
     * <p>Since {@link Dice} is immutable class, only the returned one may contain different value, so the basic
     * usage is:<br/>
     * <code>dice = dice.reRoll();</code>
     *
     * @return new instance of dice with the same sides but random value.
     */
    public Dice reRoll() {
        return new Dice(this.sides);
    }

    public int getScore() {
        return score;
    }

    public int getSides() {
        return sides;
    }

    /**
     * Compares dice by score, and if <b>(important!)</b> their score is equal than compares their hashes.
     * This is necessary to allow contain multiple Dice instances with the same score in sorted collections like
     * {@link java.util.TreeSet}.
     *
     * @see Comparable#compareTo(Object)
     */
    @Override
    public int compareTo(Dice other) {
        if (this == other) {
            return 0;
        }
        return this.score < other.score
                ? -1
                : this.score > other.score
                ? 1
                : Integer.valueOf(this.hashCode()).compareTo(other.hashCode());
    }

    @Override
    public String toString() {
        if (stringValue == null) {
            int prefixZeroCount = NumberUtils.digitCount(sides) - NumberUtils.digitCount(score);
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < prefixZeroCount; i++) {
                sb.append('0');
            }
            sb.append(score).append('/').append(sides).append(']');
            stringValue = sb.toString();
        }

        return stringValue;
    }
}