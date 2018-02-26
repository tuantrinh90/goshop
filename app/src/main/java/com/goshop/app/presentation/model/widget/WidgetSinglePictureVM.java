package com.goshop.app.presentation.model.widget;

import java.util.List;

public class WidgetSinglePictureVM extends WidgetViewModel {

    List<OfferListItemsVM> offerListItemsVMS;

    public WidgetSinglePictureVM(
        List<OfferListItemsVM> offerListItemsVMS) {
        super(WidgetViewModel.VIEW_TYPE_SINGLE_PICTURE);
        this.offerListItemsVMS = offerListItemsVMS;
    }

    public List<OfferListItemsVM> getOfferListItemsVMS() {
        return offerListItemsVMS;
    }

    public void setOfferListItemsVMS(
        List<OfferListItemsVM> offerListItemsVMS) {
        this.offerListItemsVMS = offerListItemsVMS;
    }
}
