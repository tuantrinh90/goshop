package com.goshop.app.data.model.response;

import java.util.ArrayList;

public class OnAirScheduleResponse {

    private ArrayList<VideoItemsResponse> channel;

    public ArrayList<VideoItemsResponse> getChannel() {
        return channel;
    }

    public void setChannel(
        ArrayList<VideoItemsResponse> channel) {
        this.channel = channel;
    }
}
