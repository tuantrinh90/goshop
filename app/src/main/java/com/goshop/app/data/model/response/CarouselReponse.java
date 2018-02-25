package com.goshop.app.data.model.response;

public class CarouselReponse extends BaseWidgetReponse {

    private CarouselAutoPlayReponse autoPlay;

    private CarouselDataReponse data;

    private String title;

    public CarouselDataReponse getData() {
        return data;
    }

    public void setData(CarouselDataReponse data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CarouselAutoPlayReponse getAutoPlay() {
        return autoPlay;
    }

    public void setAutoPlay(CarouselAutoPlayReponse autoPlay) {
        this.autoPlay = autoPlay;
    }


}
