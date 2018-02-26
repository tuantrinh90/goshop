package com.goshop.app.data.model.response;

public class VideoPlayerResponse extends BaseWidgetResponse {

    private VideoAutoPlayResponse autoPlay;

    private VideoDataResponse data;

    private String pageTitle;

    private String title;

    public VideoDataResponse getData() {
        return data;
    }

    public void setData(VideoDataResponse data) {
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

    public VideoAutoPlayResponse getAutoPlay() {
        return autoPlay;
    }

    public void setAutoPlay(VideoAutoPlayResponse autoPlay) {
        this.autoPlay = autoPlay;
    }


}
