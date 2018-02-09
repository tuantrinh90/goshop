package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/2/8.
 */

public class SettingsSingleDetailVM extends SettingsModel {

    private String detail;

    public SettingsSingleDetailVM(String detail) {
        super(SettingsModel.VIEW_TYPE_SINGLE_DETAIL);
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
