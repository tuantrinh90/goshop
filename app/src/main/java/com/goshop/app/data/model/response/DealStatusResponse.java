package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

public class DealStatusResponse {

    /**
     * status_id : 1
     * status_name : New
     */
    @SerializedName("status_id")
    private String statusId;

    @SerializedName("status_name")
    private String statusName;

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
