package com.goshop.app.presentation.model;

import com.goshop.app.presentation.model.widget.CarouselItemsVM;

import java.util.List;

public class TrendingBannerVM extends TrendingNowModel {

    private long autoDuration;

    private boolean autoEnabled;

    private List<CarouselItemsVM> carouselItemsVMS;

    public TrendingBannerVM(List<CarouselItemsVM> carouselItemsVMS, boolean autoEnabled,
        long autoDuration) {
        super(TrendingNowModel.VIEW_TYPE_BANNER);
        this.autoDuration = autoDuration;
        this.autoEnabled = autoEnabled;
        this.carouselItemsVMS = carouselItemsVMS;
    }

    public long getAutoDuration() {
        return autoDuration;
    }

    public void setAutoDuration(long autoDuration) {
        this.autoDuration = autoDuration;
    }

    public boolean isAutoEnabled() {
        return autoEnabled;
    }

    public void setAutoEnabled(boolean autoEnabled) {
        this.autoEnabled = autoEnabled;
    }

    public List<CarouselItemsVM> getCarouselItemsVMS() {
        return carouselItemsVMS;
    }

    public void setCarouselItemsVMS(
        List<CarouselItemsVM> carouselItemsVMS) {
        this.carouselItemsVMS = carouselItemsVMS;
    }
}
