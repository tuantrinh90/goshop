package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

public class InformationData {

    @SerializedName("date_time")
    private String dateTime;

    /**
     * number : 123
     * status : Shipped
     * date_time : 2018-01-30T13:05:45Z
     */

    private String number;

    private String status;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
