package com.goshop.app.presentation.model;

import java.util.List;

public class PdpAdditionalInformationVM extends ProductDetailModel {

    private List<PdpAdditionalItemVM> itemVMS;

    public PdpAdditionalInformationVM(List<PdpAdditionalItemVM> itemVMS) {
        super(ProductDetailModel.DETAIL_ADDITIONAL_INFORMATION);
        this.itemVMS = itemVMS;
    }

    public List<PdpAdditionalItemVM> getItemVMS() {
        return itemVMS;
    }

    public void setItemVMS(List<PdpAdditionalItemVM> itemVMS) {
        this.itemVMS = itemVMS;
    }
}
