package com.gmail.vitalatron.game.input.controls;

public class Menu<T extends MenuItemBase<T>> {

    protected final T rootMenu;

    protected T currentMenu;

    protected T selectedMenuItem;

    protected boolean cycledNavigation = true;

    public Menu(T rootMenu) {
        if (rootMenu == null) {
            throw new NullPointerException("Root menu is required!");
        }
        this.rootMenu = rootMenu;
        this.currentMenu = this.rootMenu;

        if (this.currentMenu.getChildren().size() > 0) {
            this.selectedMenuItem = this.currentMenu.getChildren().iterator().next();
        }
    }

    public T getRootMenu() {
        return rootMenu;
    }

    public T getCurrentMenu() {
        return currentMenu;
    }

    public T getSelectedMenuItem() {
        return selectedMenuItem;
    }

    public boolean isCycledNavigation() {
        return cycledNavigation;
    }

    public void setCycledNavigation(boolean cycledNavigation) {
        this.cycledNavigation = cycledNavigation;
    }

    public void select() {
        MenuItemBase<T> itemToTrigger = this.selectedMenuItem;

        if (this.selectedMenuItem.getChildren().size() > 0) {
            this.currentMenu = this.selectedMenuItem;
            this.selectedMenuItem = this.currentMenu.getChildren().iterator().next();
        }

        itemToTrigger.trigger();
    }

    public void back() {
        if (this.currentMenu.getParent() != null) {
            this.selectedMenuItem = this.currentMenu;
            this.currentMenu = this.currentMenu.getParent();
        }
    }

    public void next() {
        if (this.currentMenu.getChildren().size() == 0) {
            return;
        }
        this.selectedMenuItem = this.currentMenu.getOffsetChild(this.selectedMenuItem, +1, this.cycledNavigation);
    }

    public void previous() {
        if (this.currentMenu.getChildren().size() == 0) {
            return;
        }
        this.selectedMenuItem = this.currentMenu.getOffsetChild(this.selectedMenuItem, -1, this.cycledNavigation);
    }

}
