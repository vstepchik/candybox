package com.gmail.vitalatron.game.visual;

import com.gmail.vitalatron.game.exec.ExecutorGameLoop;
import com.gmail.vitalatron.game.exec.GameTask;
import com.gmail.vitalatron.game.exec.TimedLoop;

public abstract class AbstractGameWindow implements GameWindow {

    protected final TimedLoop repaintLoop;

    protected GameTask repaintTask = GameTask.EMPTY;

    protected SceneHolder sceneHolder;

    public AbstractGameWindow() {
        this.repaintLoop = new ExecutorGameLoop();
    }

    @Override
    public void setFps(int fps) {
        this.repaintLoop.setIterationsPerSecond(fps);
    }

    @Override
    public void setSceneHolder(SceneHolder sceneHolder) {
        this.sceneHolder = sceneHolder;
    }
}
