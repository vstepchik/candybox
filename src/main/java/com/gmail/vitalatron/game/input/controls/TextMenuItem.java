package com.gmail.vitalatron.game.input.controls;

import java.util.List;

public class TextMenuItem extends MenuItemBase<TextMenuItem> {

    protected static final String DEFAULT_LABEL = "<NO DATA TO DISPLAY>";

    protected ViewDataSource<String> dataSource;

    public TextMenuItem(TextMenuItem parent) {
        super(parent);
    }

    public TextMenuItem(TextMenuItem parent, String label) {
        super(parent);
        setLabel(label);
    }

    public TextMenuItem(TextMenuItem parent, String label, ControlAction action) {
        super(parent, action);
        setLabel(label);
    }

    public TextMenuItem(TextMenuItem parent, String label, List<TextMenuItem> children) {
        super(parent, children);
        setLabel(label);
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
