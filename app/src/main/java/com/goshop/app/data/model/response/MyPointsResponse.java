package com.goshop.app.data.model.response;

import java.util.List;

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

        private GoshopPointsData goshop_points;

        public GoshopPointsData getGoshop_points() {
            return goshop_points;
        }

        public void setGoshop_points(GoshopPointsData goshop_points) {
            this.goshop_points = goshop_points;
        }

        public static class GoshopPointsData {

            /**
             * total : 1000
             * transactions : [{"detail":"Earned GoShop Points","points":"120","type":1,
             * "valid_until":"2018-01-31","order_number":"1234","date":"2018-04-05T00:42:09Z"},
             * {"detail":"Utilized GoShop Points","points":"120","type":0,
             * "valid_until":"2018-01-15","order_number":"3456","date":"2018-04-05T00:42:09Z"}]
             */

            private String total;

            private List<TransactionsData> transactions;

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public List<TransactionsData> getTransactions() {
                return transactions;
            }

            public void setTransactions(List<TransactionsData> transactions) {
                this.transactions = transactions;
            }

            public static class TransactionsData {

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
        }
    }
}
