package com.gmail.vitalatron.game.random.dice;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class DiceRoller {

    public static Roll rollDice(int count, int sides) {
        return new Roll(count, sides);
    }


    public static class Roll {

        private final int sides;

        private final TreeSet<Dice> dices = new TreeSet<>();

        private Roll(int count, int sides) {
            if (sides < 1) {
                throw new IllegalArgumentException("Dice can't have less than 1 side");
            }
            count = Math.max(count, 0);

            this.sides = sides;
            add(count);
        }

        private void reRoll(Dice dice) {
            if (this.dices.remove(dice)) {
                this.dices.add(dice.reRoll());
            }
        }

        private void ensureCountPositive(int count) {
            if (count < 0) {
                throw new IllegalArgumentException("Count (" + count + ") must be positive value");
            }
        }

        public Roll add(int count) {
            for (int i = 0; i < count; i++) {
                this.dices.add(new Dice(this.sides));
            }
            return this;
        }

        public Roll reRoll() {
            TreeSet<Dice> dicesToReRoll = new TreeSet<>(this.dices);
            this.dices.clear();
            while (!dicesToReRoll.isEmpty()) {
                this.dices.add(dicesToReRoll.pollFirst().reRoll());
            }
            return this;
        }

        public Roll removeWorst(int count) {
            ensureCountPositive(count);
            count = Math.min(count, this.dices.size());

            for (int i = 0; i < count; i++) {
                this.dices.pollFirst();
            }
            return this;
        }

        public Roll reRollWorst(int count) {
            ensureCountPositive(count);
            count = Math.min(count, this.dices.size());

            TreeSet<Dice> dicesToReroll = new TreeSet<>();
            for (int i = 0; i < count; i++) {
                dicesToReroll.add(this.dices.pollFirst());
            }
            for (Dice dice : dicesToReroll) {
                this.dices.add(dice.reRoll());
            }
            return this;
        }

        public Roll removeBest(int count) {
            ensureCountPositive(count);
            count = Math.min(count, this.dices.size());

            for (int i = 0; i < count; i++) {
                this.dices.pollLast();
            }
            return this;
        }

        public Roll reRoll(int count) {
            ensureCountPositive(count);
            count = Math.min(count, this.dices.size());

            TreeSet<Dice> dicesToReroll = new TreeSet<>();
            for (int i = 0; i < count; i++) {
                dicesToReroll.add(this.dices.pollLast());
            }
            for (Dice dice : dicesToReroll) {
                this.dices.add(dice.reRoll());
            }
            return this;
        }

        public int getScore() {
            int score = 0;
            for (Dice d : this.dices) {
                score += d.getScore();
            }
            return score;
        }

        public List<Dice> getDices() {
            return new ArrayList<>(this.dices);
        }

        @Override
        public String toString() {
            return this.dices.toString();
        }
    }

}
