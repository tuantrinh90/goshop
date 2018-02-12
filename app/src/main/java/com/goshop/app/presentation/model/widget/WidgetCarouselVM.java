package com.goshop.app.presentation.model.widget;

/**
 * Created by helen on 2018/2/5.
 */

public class WidgetCarouselVM extends WidgetViewModel {

    private CarouselAutoPlayVM autoPlay;

    private CarouselDataVM data;

    /**
     * id : 1001
     * name : Carousel
     * data : {"items":[{"image":"https://image.goshop.com
     * .my/resources/ms/image/contents/prd/22/32/20052232_01_400.jpg","link":"/prd/20052232"},
     * {"image":"https://image.goshop.com
     * .my/resources/ms/image/contents/prd/22/32/20052232_01_400.jpg","link":"/prd/20052232"},
     * {"image":"https://image.goshop.com
     * .my/resources/ms/image/contents/prd/22/32/20052232_01_400.jpg","link":"/prd/20052232"},
     * {"image":"https://image.goshop.com
     * .my/resources/ms/image/contents/prd/22/32/20052232_01_400.jpg","link":"/prd/20052232"}]}
     * title :
     * autoPlay : {"enabled":"true","duration":"500","loop":"8","direction":"right"}
     */

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
