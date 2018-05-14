package com.goshop.app.presentation.model;

import java.util.List;

public class PaymentMethodVM {

    private String code;

    private String title;

    private boolean isSelect = false;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private List<ProfileMetaVM> months;

    public List<ProfileMetaVM> getMonths() {
        return months;
    }

    public void setMonths(List<ProfileMetaVM> months) {
        this.months = months;
    }
}
