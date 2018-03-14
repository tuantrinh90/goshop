package com.goshop.app.presentation.model;

public class PdpAdditionalInformationVM extends ProductDetailModel {

    private String lable;

    private String unit;

    public PdpAdditionalInformationVM(String lable, String unit) {
        super(ProductDetailModel.DETAIL_ADDITIONAL_INFORMATION);
        this.lable = lable;
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }
}
