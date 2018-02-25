package com.goshop.app.presentation.model.widget;

import java.util.List;

public class WidgetCarouselVM extends WidgetViewModel {

    private String autoDirection;

    private long autoDuration;

    private boolean autoEnabled;

    private String autoLoop;

    private List<CarouselItemsVM> carouselItemsVMS;

    private String title;


    public WidgetCarouselVM(boolean autoEnabled, long autoDuration,
        List<CarouselItemsVM> carouselItemsVMS) {
        super(WidgetViewModel.VIEW_TYPE_BANNER);
        this.autoEnabled = autoEnabled;
        this.autoDuration = autoDuration;
        this.carouselItemsVMS = carouselItemsVMS;
    }

    public String getAutoDirection() {
        return autoDirection;
    }

    public void setAutoDirection(String autoDirection) {
        this.autoDirection = autoDirection;
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

    public String getAutoLoop() {
        return autoLoop;
    }

    public void setAutoLoop(String autoLoop) {
        this.autoLoop = autoLoop;
    }

    public List<CarouselItemsVM> getCarouselItemsVMS() {
        return carouselItemsVMS;
    }

    public void setCarouselItemsVMS(
        List<CarouselItemsVM> carouselItemsVMS) {
        this.carouselItemsVMS = carouselItemsVMS;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
