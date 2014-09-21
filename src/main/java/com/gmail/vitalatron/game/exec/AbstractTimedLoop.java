package com.gmail.vitalatron.game.exec;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractTimedLoop implements TimedLoop {
    protected volatile int delay = 50;
    protected volatile boolean paused;
    protected volatile boolean stopped;
    protected List<GameTask> tasks = new CopyOnWriteArrayList<>();

    @Override
    public synchronized void setTimeout(int milliseconds) {
        if (milliseconds <= 0) {
            throw new IllegalArgumentException("Loop timeout should be > 0");
        }
        this.delay = milliseconds;
    }

    @Override
    public synchronized void setIterationsPerSecond(int ips) {
        if (ips <= 0) {
            throw new IllegalArgumentException("IPS should be > 0");
        }
        if (ips > 1000) {
            throw new IllegalArgumentException("> 1000ips!? UMAD?");
        }
        this.delay = 1000 / ips;
    }

    @Override
    public void removeAllTasks() {
        this.tasks.clear();
    }

    @Override
    public void removeTask(GameTask task) {
        this.tasks.remove(task);
    }

    @Override
    public void addTask(GameTask task) {
        this.tasks.add(task);
    }

    @Override
    public synchronized void setPaused(boolean paused) {
        this.paused = paused;
    }

    @Override
    public synchronized void stop() {
        this.stopped = true;
    }
}
