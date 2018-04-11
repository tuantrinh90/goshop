package com.goshop.app.data.model.response;
import com.goshop.app.data.model.response.common.CustomerMetaData;

public class ProfileMetadataResponse {

    /**
     * customer : {"gender":{"1":"Male","2":"Female"},"language":{"74":"Malay","75":"Chinese",
     * "169":"English"},"race":{"76":"Malay","77":"Chinese","128":"Indian","129":"Others"}}
     */

    private CustomerMetaData customer;

    public CustomerMetaData getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerMetaData customer) {
        this.customer = customer;
    }

}
