package com.goshop.app.data.model.response.common;

import java.util.List;

public class GoshopPointsData {

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
}
