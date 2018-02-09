package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/2/8.
 */

public class SettingsTitleVM extends SettingsModel {

    private String title;

    public SettingsTitleVM(String title) {
        super(SettingsModel.VIEW_TYPE_TITLE);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
