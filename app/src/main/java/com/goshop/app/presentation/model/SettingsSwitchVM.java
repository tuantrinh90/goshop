package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/2/8.
 */

public class SettingsSwitchVM extends SettingsModel {

    private String detail;

    private boolean isSelect = false;

    public SettingsSwitchVM(String detail) {
        super(SettingsModel.VIEW_TYPE_SWICTH_DETAIL);
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
