package com.goshop.app.presentation.model;

public class SettingsSingleDetailVM extends SettingsModel {

    private String detail;

    private SettingDetailItemClickListener itemClickListener;

    public SettingsSingleDetailVM(String detail,
        SettingDetailItemClickListener itemClickListener) {
        super(SettingsModel.VIEW_TYPE_SINGLE_DETAIL);
        this.detail = detail;
        this.itemClickListener = itemClickListener;
    }

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

    public SettingDetailItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public void setItemClickListener(
        SettingDetailItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface SettingDetailItemClickListener {

        void onDetailItemClick();
    }
}
