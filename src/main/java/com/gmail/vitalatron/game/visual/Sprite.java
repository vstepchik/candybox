package com.gmail.vitalatron.game.visual;

import java.awt.*;

public class Sprite implements Drawable {

    protected final Image image;
    protected int x;
    protected int y;

    public Sprite(Image image) {
        this.image = image;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(this.image, this.x, this.y, null);
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
