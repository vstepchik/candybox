package com.gmail.vitalatron.game.visual;

import com.gmail.vitalatron.game.exec.ExecutorGameLoop;
import com.gmail.vitalatron.game.exec.GameTask;
import com.gmail.vitalatron.game.exec.TimedLoop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractGameWindow implements GameWindow {

    protected final Map<String, Scene> scenes = new HashMap<>();

    protected final TimedLoop repaintLoop;

    protected GameTask repaintTask = GameTask.EMPTY;

    protected Scene currentScene;

    public AbstractGameWindow() {
        this.repaintLoop = new ExecutorGameLoop();
    }

    @Override
    public void setFps(int fps) {
        this.repaintLoop.setIterationsPerSecond(fps);
    }

    @Override
    public void addScene(Scene scene) {
        this.scenes.put(scene.getName(), scene);
    }

    @Override
    public Scene getScene(String name) {
        return scenes.get(name);
    }

    @Override
    public void removeScene(Scene scene) {
        removeScene(scene.getName());
    }

    @Override
    public void removeScene(String name) {
        scenes.remove(name);
    }

    @Override
    public void clearScenes() {
        this.scenes.clear();
    }

    @Override
    public Scene getCurrentScene() {
        return currentScene;
    }

    @Override
    public void setCurrentScene(String sceneName) {
        setCurrentScene(getScene(sceneName));
    }

    @Override
    public void setCurrentScene(Scene scene) {
        if (scene == null) {
            currentScene = null;
            return;
        }
        addScene(scene);
        currentScene = scene;
    }
}
