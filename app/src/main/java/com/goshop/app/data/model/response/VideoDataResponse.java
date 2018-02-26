package com.goshop.app.data.model.response;

import java.util.List;

public class VideoDataResponse {

    private VideoDetailResponse detail;

    private List<VideoItemsResponse> items;

    public VideoDetailResponse getDetail() {
        return detail;
    }

    public void setDetail(VideoDetailResponse detail) {
        this.detail = detail;
    }

    public List<VideoItemsResponse> getItems() {
        return items;
    }

    public void setItems(List<VideoItemsResponse> items) {
        this.items = items;
    }

}
