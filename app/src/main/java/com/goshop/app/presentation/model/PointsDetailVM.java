package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/2/8.
 */

public class PointsDetailVM extends PointsModel {

    private String date;

    private String description;

    private boolean isIncrease;

    private String orderNo;

    private String points;

    private String time;

    public PointsDetailVM(String points, String date, String description,
        String orderNo, String time, boolean isIncrease) {
        super(PointsModel.VIEW_TYPE_TRANSACTIONS_DETAIL);
        this.points = points;
        this.date = date;
        this.description = description;
        this.orderNo = orderNo;
        this.time = time;
        this.isIncrease = isIncrease;

    }

    public boolean isIncrease() {
        return isIncrease;
    }

    public void setIncrease(boolean increase) {
        isIncrease = increase;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
