package com.gmail.vitalatron.game.visual;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Scene implements Drawable, Layer.ZIndexChangeListener {

    private final List<Layer> layers = new ArrayList<>();

    private final Map<String, Layer> layerNamesMap = new HashMap<>();

    private final String name;

    public Scene(String name) {
        this.name = name;
    }

    @Override
    public void draw(Graphics2D g) {
        for (Layer layer : layers) {
            layer.draw(g);
        }
    }

    public void addLayer(Layer layer) {
        if (layerNamesMap.containsKey(layer.getName())) {
            removeLayer(layer);
        }
        layers.add(layer);
        layerNamesMap.put(layer.getName(), layer);
        layer.addZIndexListener(this);
        zIndexChanged(layer.getzIndex());
    }

    public void removeLayer(Layer layer) {
        layers.remove(layer);
        layerNamesMap.remove(layer.getName());
        layer.removeZIndezListener(this);
        zIndexChanged(layer.getzIndex());
    }

    public Layer getLayer(String name) {
        return layerNamesMap.get(name);
    }

    public void removeLayer(String name) {
        removeLayer(getLayer(name));
    }

    @Override
    public void zIndexChanged(int newValue) {
        Collections.sort(layers);
    }

    public String getName() {
        return name;
    }
}
