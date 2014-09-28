package com.gmail.vitalatron.game.visual;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Layer implements Drawable, Comparable<Layer> {

    public static interface ZIndexChangeListener {
        public void zIndexChanged(int newValue);
    }

    private final List<ZIndexChangeListener> zIndexListeners = new CopyOnWriteArrayList<>();

    private final List<Drawable> drawableList = new ArrayList<>();

    private int zIndex = 0;

    private final String name;

    public Layer(String name) {
        this.name = name;
    }

    public Layer(String name, int zIndex) {
        this(name);
        this.zIndex = zIndex;
    }

    public void addZIndexListener(ZIndexChangeListener listener) {
        this.zIndexListeners.add(listener);
    }

    public void removeZIndezListener(ZIndexChangeListener listener) {
        this.zIndexListeners.remove(listener);
    }

    public void addDrawable(Drawable drawable) {
        this.drawableList.add(drawable);
    }

    public void removeDrawable(Drawable drawable) {
        this.drawableList.remove(drawable);
    }

    @Override
    public void draw(Graphics2D g) {
        for (Drawable drawable : drawableList) {
            drawable.draw(g);
        }
    }

    @Override
    public int compareTo(Layer other) {
        return this.zIndex < other.zIndex
                ? -1
                : this.zIndex > other.zIndex ? 1 : 0;
    }

    public int getzIndex() {
        return zIndex;
    }

    public void setzIndex(int zIndex) {
        this.zIndex = zIndex;
        for (ZIndexChangeListener listener : zIndexListeners) {
            listener.zIndexChanged(this.zIndex);
        }
    }

    public String getName() {
        return name;
    }

}
