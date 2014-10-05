package com.gmail.vitalatron.game.input.controls;

public interface ControlAction {

    public static final ControlAction EMPTY = new ControlAction() {
        @Override
        public void perform() {
            // do nothing
        }
    };

    public void perform();
}
