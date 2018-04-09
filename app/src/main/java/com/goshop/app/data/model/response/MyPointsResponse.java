package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

import com.goshop.app.data.model.response.common.GoshopPointsData;

public class MyPointsResponse extends Response {

    /**
     * data : {"goshop_points":{"total":"1000","transactions":[{"detail":"Earned GoShop Points",
     * "points":"120","type":1,"valid_until":"2018-01-31","order_number":"1234",
     * "date":"2018-04-05T00:42:09Z"},{"detail":"Utilized GoShop Points","points":"120","type":0,
     * "valid_until":"2018-01-15","order_number":"3456","date":"2018-04-05T00:42:09Z"}]}}
     */

    private Datas data;

    public Datas getData() {
        return data;
    }

    public void setData(Datas data) {
        this.data = data;
    }

    public static class Datas {

        /**
         * goshop_points : {"total":"1000","transactions":[{"detail":"Earned GoShop Points",
         * "points":"120","type":1,"valid_until":"2018-01-31","order_number":"1234",
         * "date":"2018-04-05T00:42:09Z"},{"detail":"Utilized GoShop Points","points":"120",
         * "type":0,"valid_until":"2018-01-15","order_number":"3456",
         * "date":"2018-04-05T00:42:09Z"}]}
         */
        @SerializedName("goshop_points")
        private GoshopPointsData goshopPoints;

        public GoshopPointsData getGoshop_points() {
            return goshopPoints;
        }

        public void setGoshopPoints(GoshopPointsData goshopPoints) {
            this.goshopPoints = goshopPoints;
        }

    }
}
