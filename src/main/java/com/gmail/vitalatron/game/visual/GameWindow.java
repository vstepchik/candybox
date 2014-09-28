package com.gmail.vitalatron.game.visual;

import java.awt.*;

public interface GameWindow {
    public void show();

    public void close();

    public void setIcon(Image icon);

    public void setFps(int fps);

    public void addScene(Scene scene);

    public Scene getScene(String name);

    public void removeScene(Scene scene);

    public void removeScene(String name);

    public void clearScenes();

    public Scene getCurrentScene();

    public void setCurrentScene(String sceneName);

    public void setCurrentScene(Scene scene);
}
