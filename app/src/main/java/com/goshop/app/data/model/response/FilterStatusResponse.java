package com.goshop.app.data.model.response;


import com.goshop.app.data.model.response.common.FilterStatusData;

import java.util.List;

public class FilterStatusResponse {

    private List<FilterStatusData> status;

    public List<FilterStatusData> getStatus() {
        return status;
    }

    public void setStatus(List<FilterStatusData> status) {
        this.status = status;
    }
}
