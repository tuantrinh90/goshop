package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/1/12.
 */

public class PdpAdditionalInformationVM extends ProductDetailModel {

    private String lable;

    public PdpAdditionalInformationVM(String lable) {
        super(ProductDetailModel.DETAIL_ADDITIONAL_INFORMATION);
        this.lable = lable;
    }

    public PdpAdditionalInformationVM() {
        super(ProductDetailModel.DETAIL_ADDITIONAL_INFORMATION);
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }
}
