package com.gmail.vitalatron.game.input.controls;

import java.util.Set;

public class TextMenuItem extends MenuItemBase<TextMenuItem> {

    protected static final String DEFAULT_LABEL = "<NO DATA TO DISPLAY>";

    protected ViewDataSource<String> dataSource;

    public TextMenuItem(TextMenuItem parent) {
        super(parent);
    }

    public TextMenuItem(String label, TextMenuItem parent, ControlAction action) {
        super(parent, action);
    }

    public TextMenuItem(String label, TextMenuItem parent, Set<TextMenuItem> children) {
        super(parent, children);
    }

    public void setDataSource(ViewDataSource<String> label) {
        this.dataSource = label;
    }

    public void setLabel(String label) {
        this.dataSource = new FixedTextDataSource(label);
    }

    public String getLabel() {
        return (this.dataSource == null)
                ? DEFAULT_LABEL
                : this.dataSource.getViewData();
    }

}
