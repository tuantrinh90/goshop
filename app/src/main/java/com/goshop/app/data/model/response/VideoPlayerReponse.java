package com.goshop.app.data.model.response;

public class VideoPlayerReponse extends BaseWidgetReponse {

    private VideoAutoPlayReponse autoPlay;

    private VideoDataReponse data;

    private String pageTitle;

    private String title;

    public VideoDataReponse getData() {
        return data;
    }

    public void setData(VideoDataReponse data) {
        this.data = data;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public VideoAutoPlayReponse getAutoPlay() {
        return autoPlay;
    }

    public void setAutoPlay(VideoAutoPlayReponse autoPlay) {
        this.autoPlay = autoPlay;
    }


}
