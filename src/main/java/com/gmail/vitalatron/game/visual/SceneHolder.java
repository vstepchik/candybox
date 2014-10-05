package com.gmail.vitalatron.game.visual;

import com.gmail.vitalatron.game.input.KeyboardButton;
import com.gmail.vitalatron.game.input.MouseButton;
import com.gmail.vitalatron.game.input.UserInputListener;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class SceneHolder implements UserInputListener {

    protected final Map<String, Scene> scenes = new HashMap<>();

    protected Scene currentScene;

    public void addScene(Scene scene) {
        this.scenes.put(scene.getName(), scene);
    }

    public Scene getScene(String name) {
        return scenes.get(name);
    }

    public void removeScene(Scene scene) {
        removeScene(scene.getName());
    }

    public void removeScene(String name) {
        scenes.remove(name);
    }

    public void clearScenes() {
        this.scenes.clear();
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public void setCurrentScene(String sceneName) {
        setCurrentScene(getScene(sceneName));
    }

    public void setCurrentScene(Scene scene) {
        if (scene == null) {
            this.currentScene = null;
            return;
        }
        addScene(scene);
        this.currentScene = scene;
    }

    @Override
    public void keyPressed(KeyboardButton button) {
        if (currentScene != null) {
            currentScene.keyPressed(button);
        }
    }

    @Override
    public void keyReleased(KeyboardButton button) {
        if (currentScene != null) {
            currentScene.keyReleased(button);
        }
    }

    @Override
    public void mouseButtonPressed(MouseButton button) {
        if (currentScene != null) {
            currentScene.mouseButtonPressed(button);
        }
    }

    @Override
    public void mouseButtonReleased(MouseButton button) {
        if (currentScene != null) {
            currentScene.mouseButtonReleased(button);
        }
    }

    @Override
    public void mouseMoved(Point from, Point to) {
        if (this.currentScene != null) {
            this.currentScene.mouseMoved(from, to);
        }
    }

    @Override
    public void mouseWheelMoved(int amount) {
        if (this.currentScene != null) {
            this.currentScene.mouseWheelMoved(amount);
        }
    }
}
