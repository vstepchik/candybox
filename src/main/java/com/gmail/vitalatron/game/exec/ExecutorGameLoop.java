package com.gmail.vitalatron.game.exec;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorGameLoop extends AbstractTimedLoop {
    protected final Executor executor = Executors.newSingleThreadExecutor();
    protected long lastExecutionNanoTime;

    protected final Runnable loop = new Runnable() {
        @Override
        public void run() {
            while (!ExecutorGameLoop.this.stopped) {
                long t = System.nanoTime();
                double delta = ((t - lastExecutionNanoTime) / 1000000) / (double) delay;

                for (GameTask task : tasks) {
                    task.execute(delta);
                }

                lastExecutionNanoTime = System.nanoTime();
                t = (lastExecutionNanoTime - t) / 1000000;

                try {
                    Thread.sleep((delay - t < 0) ? 0 : delay - t);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    };

    public ExecutorGameLoop() {
        this.lastExecutionNanoTime = System.nanoTime();
        this.executor.execute(this.loop);
    }
}
