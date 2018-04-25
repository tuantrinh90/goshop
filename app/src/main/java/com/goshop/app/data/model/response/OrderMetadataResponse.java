package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.OrderMetaData;

public class OrderMetadataResponse {

    /**
     * order : {"cancel":{"reason":[{"id":1,"value":"Product Damage"},{"id":2,"value":"Wrong
     * Item"}],"product_resolution":[{"id":1,"value":"Order Cancel"}]},
     * "return":{"reason":[{"id":1,"value":"ProductDamage"},{"id":2,"value":"Wrong Item Sent"}],
     * "product_resolution":[{"id":1,"value":"Order Return"}]}}
     */

    private OrderMetaData order;

    public OrderMetaData getOrder() {
        return order;
    }

    public void setOrder(OrderMetaData order) {
        this.order = order;
    }

}
