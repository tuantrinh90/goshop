package com.goshop.app.presentation.model.widget;

public class WidgetCarouselVM extends WidgetViewModel {

    private CarouselAutoPlayVM autoPlay;

    private CarouselDataVM data;

    private String id;

    private String name;

    private String title;

    public WidgetCarouselVM(CarouselAutoPlayVM autoPlay, CarouselDataVM data) {
        super(WidgetViewModel.VIEW_TYPE_BANNER);
        this.autoPlay = autoPlay;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarouselDataVM getData() {
        return data;
    }

    public void setData(CarouselDataVM data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CarouselAutoPlayVM getAutoPlay() {
        return autoPlay;
    }

    public void setAutoPlay(CarouselAutoPlayVM autoPlay) {
        this.autoPlay = autoPlay;
    }
}
