package com.goshop.app.data.model.response;

import java.util.List;

public class MyPointsResponse extends Response {

    /**
     * data : {"goShopPoints":[{"detail":"","points":120,"type":1,"validUntil":"12 Jan 2018",
     * "orderNo":1234},{"detail":"","points":120,"type":1,"validUntil":"12 Jan 2018",
     * "orderNo":1234}]}
     * message : {"display_message":"","status":"success"}
     */

    private Datas data;

    public Datas getData() {
        return data;
    }

    public void setData(Datas data) {
        this.data = data;
    }

    public static class Datas {

        private List<GoShopPointsData> goShopPoints;

        public List<GoShopPointsData> getGoShopPoints() {
            return goShopPoints;
        }

        public void setGoShopPoints(List<GoShopPointsData> goShopPoints) {
            this.goShopPoints = goShopPoints;
        }

        public static class GoShopPointsData {

            /**
             * detail :
             * points : 120
             * type : 1
             * validUntil : 12 Jan 2018
             * orderNo : 1234
             */

            private String detail;

            private int orderNo;

            private int points;

            private int type;

            private String validUntil;

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public int getPoints() {
                return points;
            }

            public void setPoints(int points) {
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

            public void setValidUntil(String validUntil) {
                this.validUntil = validUntil;
            }

            public int getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(int orderNo) {
                this.orderNo = orderNo;
            }
        }
    }

}
