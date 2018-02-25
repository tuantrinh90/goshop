package com.goshop.app.data.model.response;

import java.util.List;

public class VideoDataReponse {

    private VideoDetailReponse detail;

    private List<VideoItemsReponse> items;

    public VideoDetailReponse getDetail() {
        return detail;
    }

    public void setDetail(VideoDetailReponse detail) {
        this.detail = detail;
    }

    public List<VideoItemsReponse> getItems() {
        return items;
    }

    public void setItems(List<VideoItemsReponse> items) {
        this.items = items;
    }

}
