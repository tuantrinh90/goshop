package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.UserData;

public class ProfileResponse {

    /**
     * customer : {"id":123124,"title":"Mr","name":"Abc Def","email":"abc@xyz.com",
     * "mobile_number":"601012345678","language":{"id":1,"name":"English"},
     * "dob":"1993-06-12","race":{"id":1,"name":"Malay"},"wishlist_tems_count":2,
     * "cart_items_count":5,"available_goshop_points":"1000.00","email_subscribe":true,
     * "sms_subscribe":true}
     */

    private UserData customer;

    public UserData getCustomer() {
        return customer;
    }

    public void setCustomer(UserData customer) {
        this.customer = customer;
    }
}
