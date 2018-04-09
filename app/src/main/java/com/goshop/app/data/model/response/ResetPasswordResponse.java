package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.UserData;

public class ResetPasswordResponse extends Response {

    /**
     * data : {"customer":{"email":"john@gmail.com"}}
     */

    private Datas data;

    public Datas getData() {
        return data;
    }

    public void setData(Datas data) {
        this.data = data;
    }

    public static class Datas {

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
}
