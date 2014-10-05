package com.gmail.vitalatron.game.input.controls;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class MenuItemBase<T extends MenuItemBase> {

    protected final LinkedHashSet<T> children = new LinkedHashSet<>();

    protected final T parent;

    protected ControlAction action = ControlAction.EMPTY;

    protected boolean enabled = true;

    public MenuItemBase(T parent) {
        this.parent = parent;
        if (this.parent != null) {
            this.parent.addChild(this);
        }
    }

    public MenuItemBase(T parent, ControlAction action) {
        this(parent);
        setAction(action);
    }

    public MenuItemBase(T parent, Set<T> children) {
        this(parent);
        children.addAll(children);
    }

    public void setAction(ControlAction action) {
        if (action == null) {
            this.action = ControlAction.EMPTY;
        } else {
            this.action = action;
        }
    }

    public void addChild(T child) {
        children.add(child);
    }

    T getOffsetChild(T offsetItem, int resultOffset, boolean cycle) {
        if (this.children.size() == 0) {
            return null;
        }

        List<T> children = new ArrayList<>(this.children);
        int index = children.indexOf(offsetItem);

        if (index < 0) {
            return offsetItem;
        }

        index += resultOffset;
        if (cycle) {
            index = (index >= 0) ? index % children.size() : children.size() - (Math.abs(index) % children.size() - 1);
        }
        return (index < 0)
                ? children.get(0)
                : (index >= children.size()) ? children.get(children.size() - 1) : children.get(index);
    }

    public void trigger() {
        if (this.enabled) {
            action.perform();
        }
    }

    public T getParent() {
        return parent;
    }

    public ControlAction getAction() {
        return action;
    }

    public LinkedHashSet<T> getChildren() {
        return children;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
