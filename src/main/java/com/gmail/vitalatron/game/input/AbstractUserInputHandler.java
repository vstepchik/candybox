package com.gmail.vitalatron.game.input;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractUserInputHandler implements UserInputHandler {

    protected final List<UserInputListener> inputListenerList = new CopyOnWriteArrayList<>();
    protected final LinkedHashSet<KeyboardButton> pressedKeys = new LinkedHashSet<>();
    protected final LinkedHashSet<MouseButton> pressedMouseButtons = new LinkedHashSet<>();
    protected Point mousePosition = new Point(0, 0);
    protected Point mousePrevPosition = new Point(this.mousePosition);

    @Override
    public void addListener(UserInputListener listener) {
        this.inputListenerList.add(listener);
    }

    @Override
    public void removeListener(UserInputListener listener) {
        this.inputListenerList.remove(listener);
    }

    protected void processKeyboardButtonPressed(KeyboardButton btn) {
        if (this.pressedKeys.add(btn)) { // prevents repeated notifications while button is held
            for (UserInputListener listener : this.inputListenerList) {
                listener.keyPressed(btn);
            }
        }
    }

    protected void processKeyboardButtonReleased(KeyboardButton btn) {
        this.pressedKeys.remove(btn);
        for (UserInputListener listener : this.inputListenerList) {
            listener.keyReleased(btn);
        }
    }

    protected void processMouseMoved(Point position) {
        this.mousePrevPosition = this.mousePosition;
        this.mousePosition = position;
        for (UserInputListener listener : this.inputListenerList) {
            listener.mouseMoved(this.mousePrevPosition, this.mousePosition);
        }
    }

    protected void processMouseButtonPressed(MouseButton btn) {
        this.pressedMouseButtons.add(btn);
        for (UserInputListener listener : this.inputListenerList) {
            listener.mouseButtonPressed(btn);
        }
    }

    protected void processMouseButtonReleased(MouseButton btn) {
        this.pressedMouseButtons.remove(btn);
        for (UserInputListener listener : this.inputListenerList) {
            listener.mouseButtonReleased(btn);
        }
    }

    protected void processMouseWheelMoved(int amount) {
        for (UserInputListener listener : this.inputListenerList) {
            listener.mouseWheelMoved(amount);
        }
    }

    protected <T extends Enum<T>> T getLastInSet(LinkedHashSet<T> items) {
        if (items == null || items.isEmpty()) {
            return null;
        }
        LinkedList<T> pressedButtons = new LinkedList<>(items);
        return pressedButtons.getLast();
    }

    protected <T extends Enum<T>> T getLastInSetOf(LinkedHashSet<T> items, Set<T> lookupItems) {
        if (items == null || items.isEmpty() || lookupItems == null || lookupItems.isEmpty()) {
            return null;
        }
        Iterator<T> iterator = new LinkedList<>(items).descendingIterator();
        while (iterator.hasNext()) {
            T btn = iterator.next();
            if (lookupItems.contains(btn)) {
                return btn;
            }
        }
        return null;
    }

    @Override
    public boolean isKeyDown(KeyboardButton btn) {
        return this.pressedKeys.contains(btn);
    }

    @Override
    public boolean isMouseButtonDown(MouseButton btn) {
        return this.pressedMouseButtons.contains(btn);
    }

    @Override
    public Point getMousePosition() {
        return new Point(this.mousePosition);
    }

    @Override
    public KeyboardButton getLastButtonPressed() {
        return getLastInSet(this.pressedKeys);
    }

    @Override
    public KeyboardButton getLastButtonPressedOf(EnumSet<KeyboardButton> buttons) {
        return getLastInSetOf(this.pressedKeys, buttons);
    }

    @Override
    public MouseButton getLastMouseButtonPressed() {
        return getLastInSet(this.pressedMouseButtons);
    }

    @Override
    public MouseButton getLastMouseButtonPressedOf(EnumSet<MouseButton> buttons) {
        return getLastInSetOf(this.pressedMouseButtons, buttons);
    }
}
