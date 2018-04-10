package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.CustomerData;

public class AddressResponse {

    /**
     * customer : {"id":2345,"addresses":[{"id":1234,"name":"Abc Def","address1":"Bukit
     * Jalil","address2":"Astro","country":"MY","state":123,"city":123,"zipcode":50470,
     * "phone_number":"601213123123","default_shipping_address":true,
     * "default_billing_address":true},{"id":1234,"name":"Abc Def","address1":"Bukit Jalil",
     * "address2":"Astro","country":"MY","state":123,"city":123,"zipcode":50470,
     * "phone_number":"601213123123","default_shipping_address":1,"default_billing_address":1}]}
     */

    private CustomerData customer;

    public CustomerData getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerData customer) {
        this.customer = customer;
    }
}
