package com.goshop.app.data.model.request;

import com.goshop.app.data.model.request.common.RequestData;

public class AddressRequest {

    /**
     * request : {"website_id":1,"store_id":3,"address":{"name":"Abc Def","address1":"Bukit
     * Jalil","address2":"Astro","country":"MY","state":123,"city":123,"zipcode":50470,
     * "phone_number":"60212314135","default_shipping_address":false,
     * "default_billing_address":false}}
     */

    private RequestData request;

    public RequestData getRequest() {
        return request;
    }

    public void setRequest(RequestData request) {
        this.request = request;
    }


}
