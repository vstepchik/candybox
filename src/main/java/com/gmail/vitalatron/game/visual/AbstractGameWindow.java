package com.gmail.vitalatron.game.visual;

import com.gmail.vitalatron.game.exec.ExecutorGameLoop;
import com.gmail.vitalatron.game.exec.GameTask;
import com.gmail.vitalatron.game.exec.TimedLoop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGameWindow implements GameWindow {
    protected final List<Drawable> drawableItems = new ArrayList<>();
    protected final TimedLoop repaintLoop;
    protected GameTask repaintTask = GameTask.EMPTY;

    public AbstractGameWindow() {
        this.repaintLoop = new ExecutorGameLoop();
    }

    @Override
    public void setFps(int fps) {
        this.repaintLoop.setIterationsPerSecond(fps);
    }

    @Override
    public void addDrawableItem(Drawable drawable) {
        this.drawableItems.add(drawable);
    }

    @Override
    public void removeDrawableItem(Drawable drawable) {
        this.drawableItems.remove(drawable);
    }

    @Override
    public void clearDrawableItems() {
        this.drawableItems.clear();
    }
}
