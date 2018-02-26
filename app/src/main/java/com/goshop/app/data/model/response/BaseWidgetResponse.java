package com.goshop.app.data.model.response;

public class BaseWidgetResponse {

    public static final String NAME_CAROUSEL = "Carousel";

    public static final String NAME_OFFERLIST = "OfferList";

    public static final String NAME_PRODUCTSCROLLER = "ProductScroller";

    public static final String NAME_VIDEOPLAYER = "VideoPlayer";

    private String id;

    private String name;

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
}
