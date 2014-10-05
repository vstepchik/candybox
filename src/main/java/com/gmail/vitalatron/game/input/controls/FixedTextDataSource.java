package com.gmail.vitalatron.game.input.controls;

public class FixedTextDataSource implements ViewDataSource<String> {

    private final String text;

    public FixedTextDataSource(String text) {
        this.text = text;
    }

    @Override
    public String getViewData() {
        return text;
    }
}