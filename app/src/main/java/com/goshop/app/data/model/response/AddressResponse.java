package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.CustomerData;

public class AddressResponse {

    /**
     * customer : {"id":40,"addresses":[{"id":"29","firstname":"Pankaj","lastname":"Kavani",
     * "street":{"0":"Bukit Jalil","1":"Astro"},"country_id":"MY","region_id":512,"city":"Alor
     * Setar","postcode":12345,"telephone":"9999999999","default_billing":true,
     * "default_shipping":true},{"id":"30","firstname":"Pankaj","lastname":"Kavani",
     * "street":{"0":"Bukit Jalil","1":"Astro"},"country_id":"MY","region_id":512,"city":"Kuala
     * Lumpur","postcode":12345,"telephone":"999999999","default_billing":false,
     * "default_shipping":false}]}
     */

    private CustomerData customer;

    public CustomerData getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerData customer) {
        this.customer = customer;
    }
}
