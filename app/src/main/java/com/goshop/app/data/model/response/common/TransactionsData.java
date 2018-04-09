package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

public class TransactionsData {

    private String date;

    /**
     * detail : Earned GoShop Points
     * points : 120
     * type : 1
     * valid_until : 2018-01-31
     * order_number : 1234
     * date : 2018-04-05T00:42:09Z
     */

    private String detail;

    @SerializedName("order_number")
    private String orderNumber;

    private String points;

    private int type;

    @SerializedName("valid_until")
    private String validUntil;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String valid_until) {
        this.validUntil = validUntil;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String order_number) {
        this.orderNumber = orderNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
