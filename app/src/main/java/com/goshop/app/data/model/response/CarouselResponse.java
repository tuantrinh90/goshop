package com.goshop.app.data.model.response;

public class CarouselResponse extends BaseWidgetResponse {

    private CarouselAutoPlayResponse autoPlay;

    private CarouselDataResponse data;

    private String title;

    public CarouselDataResponse getData() {
        return data;
    }

    public void setData(CarouselDataResponse data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CarouselAutoPlayResponse getAutoPlay() {
        return autoPlay;
    }

    public void setAutoPlay(CarouselAutoPlayResponse autoPlay) {
        this.autoPlay = autoPlay;
    }


}
