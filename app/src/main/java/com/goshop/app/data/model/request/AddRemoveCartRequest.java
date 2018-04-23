package com.goshop.app.data.model.request;

import com.goshop.app.data.model.request.common.CartRequestData;

public class AddRemoveCartRequest {

    /**
     * request : {"website_id":1,"store_id":3,"sku":"200000140011",
     * "super_attributes":[{"id":"123","variant_id":"7451"},{"id":"234","variant_id":"567"}],
     * "qty":5}
     */

    private CartRequestData request;

    public CartRequestData getRequest() {
        return request;
    }

    public void setRequest(CartRequestData request) {
        this.request = request;
    }

}
