package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.UserData;

public class ResetPasswordResponse  {

    /**
     * customer : {"email":"john@gmail.com"}
     */

    private UserData customer;

    public UserData getCustomer() {
        return customer;
    }

    public void setCustomer(UserData customer) {
        this.customer = customer;
    }
}
