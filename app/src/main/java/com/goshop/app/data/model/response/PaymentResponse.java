package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.OrdersData;

public class PaymentResponse {

    /**
     * order : {"id":"123","number":"32452345","payment_url":"https://apgstg1.astro.com
     * .my/payment?refid=HSOLKAWHERHWASJADFS","status":"Pending","state":"0","code":"123"}
     */

    private OrdersData order;

    public OrdersData getOrder() {
        return order;
    }

    public void setOrder(OrdersData order) {
        this.order = order;
    }

}
