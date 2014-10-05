package com.gmail.vitalatron.game.visual;

import java.awt.*;

public interface GameWindow {
    public void show();

    public void close();

    public void setIcon(Image icon);

    public void setFps(int fps);

    void setSceneHolder(SceneHolder sceneHolder);
}
