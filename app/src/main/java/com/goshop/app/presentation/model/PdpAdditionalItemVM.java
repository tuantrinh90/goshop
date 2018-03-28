package com.goshop.app.presentation.model;

public class PdpAdditionalItemVM {

    private String lable;

    private String unit;

    public PdpAdditionalItemVM(String lable, String unit) {
        this.lable = lable;
        this.unit = unit;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
