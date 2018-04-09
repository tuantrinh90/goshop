package com.goshop.app.data.model.response.common;

import java.util.List;

public class CustomerData {

    private List<AddressesData> addresses;

    /**
     * id : 2345
     * addresses : [{"id":1234,"name":"Abc Def","address1":"Bukit Jalil",
     * "address2":"Astro","country":"MY","state":123,"city":123,"zipcode":50470,
     * "phone_number":"601213123123","default_shipping_address":true,
     * "default_billing_address":true},{"id":1234,"name":"Abc Def","address1":"Bukit
     * Jalil","address2":"Astro","country":"MY","state":123,"city":123,"zipcode":50470,
     * "phone_number":"601213123123","default_shipping_address":1,
     * "default_billing_address":1}]
     */

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<AddressesData> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressesData> addresses) {
        this.addresses = addresses;
    }

}
