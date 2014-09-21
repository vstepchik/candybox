package com.gmail.vitalatron.game.visual;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawableSet implements Drawable {
    private final List<Drawable> drawableItems = new ArrayList<>();

    @Override
    public void draw(Graphics2D g) {
        for (Drawable d : this.drawableItems) {
            d.draw(g);
        }
    }

    public void add(Drawable drawable) {
        this.drawableItems.add(drawable);
    }

    public void remove(Drawable drawable) {
        this.drawableItems.remove(drawable);
    }

    public void clear() {
        this.drawableItems.clear();
    }
}
