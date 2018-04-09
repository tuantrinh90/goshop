package com.goshop.app.data.model.response.common;

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

    private String order_number;

    private String points;

    private int type;

    private String valid_until;

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

    public String getValid_until() {
        return valid_until;
    }

    public void setValid_until(String valid_until) {
        this.valid_until = valid_until;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
