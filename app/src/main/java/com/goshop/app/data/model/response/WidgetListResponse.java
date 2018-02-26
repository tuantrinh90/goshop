package com.goshop.app.data.model.response;

import java.util.List;

public class WidgetListResponse {

    private List<BaseWidgetResponse> widgetlist;

    public List<BaseWidgetResponse> getWidgetlist() {
        return widgetlist;
    }

    public void setWidgetlist(
        List<BaseWidgetResponse> widgetlist) {
        this.widgetlist = widgetlist;
    }
}
