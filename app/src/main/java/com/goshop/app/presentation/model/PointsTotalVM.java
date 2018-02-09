package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/2/8.
 */

public class PointsTotalVM extends PointsModel {

    private String total;

    public PointsTotalVM(String total) {
        super(PointsModel.VIEW_TYPE_TOTAL);
        this.total = total;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }


}
