package com.goshop.app.presentation.model;

import com.goshop.app.presentation.model.widget.CarouselItemsVM;

public class TrendingSingleBannerVM extends TrendingNowModel {

    private CarouselItemsVM carouselItemsVM;

    public TrendingSingleBannerVM(CarouselItemsVM carouselItemsVM) {
        super(TrendingNowModel.VIEW_TYPE_SINGLE_BANNER);
        this.carouselItemsVM = carouselItemsVM;
    }

    public CarouselItemsVM getCarouselItemsVM() {
        return carouselItemsVM;
    }

    public void setCarouselItemsVM(CarouselItemsVM carouselItemsVM) {
        this.carouselItemsVM = carouselItemsVM;
    }
}
