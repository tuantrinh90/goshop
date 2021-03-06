package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

import com.goshop.app.data.model.response.common.GoshopPointsData;
import com.goshop.app.data.model.response.common.PaginationData;

public class MyPointsResponse {

    /**
     * goshop_points : {"total":"1000","transactions":[{"detail":"Earned GoShop Points",
     * "points":"120","type":1,"valid_until":"2018-01-31","order_number":"1234",
     * "date":"2018-04-05T00:42:09Z"},{"detail":"Utilized GoShop Points","points":"120",
     * "type":0,"valid_until":"2018-01-15","order_number":"3456",
     * "date":"2018-04-05T00:42:09Z"}]}
     */
    @SerializedName("goshop_points")
    private GoshopPointsData goshopPoints;

    private PaginationData pagination;

    public GoshopPointsData getGoshopPoints() {
        return goshopPoints;
    }

    public void setGoshopPoints(GoshopPointsData goshopPoints) {
        this.goshopPoints = goshopPoints;
    }

    public PaginationData getPagination() {
        return pagination;
    }

    public void setPagination(PaginationData pagination) {
        this.pagination = pagination;
    }
}
