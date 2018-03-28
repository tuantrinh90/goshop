package com.goshop.app.presentation.model;

public class ChannelVM {

    private boolean isSelect = false;

    private String name;

    public ChannelVM(boolean isSelect, String name) {
        this.isSelect = isSelect;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
