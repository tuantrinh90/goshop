package com.goshop.app.presentation.model;

import com.goshop.app.presentation.model.widget.OfferListItemsVM;

public class PromotionBannerCenterVM extends PromotionBannerModel {

    private OfferListItemsVM listItemsVM;

    public PromotionBannerCenterVM(OfferListItemsVM listItemsVM) {
        super(PromotionBannerModel.VIEW_CENTER_BANNER);
        this.listItemsVM = listItemsVM;
    }

    public OfferListItemsVM getListItemsVM() {
        return listItemsVM;
    }

    public void setListItemsVM(OfferListItemsVM listItemsVM) {
        this.listItemsVM = listItemsVM;
    }
}
