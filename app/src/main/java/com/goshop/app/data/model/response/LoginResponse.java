package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.UserData;

public class LoginResponse extends Response {

    /**
     * data : {"customer":{"id":123124,"title":"Mr","name":"Abc Def","email":"abc@xyz.com",
     * "mobile_number":12345678,"language":{"id":1,"name":"Malay"},"dob":"1991-06-20",
     * "race":{"id":1,"name":"Indian"},"max_failed_login":5,"email_subscribe":true,
     * "sms_subscribe":true,"token":{"token":"8s4ht6x8rlmq9k3cjigpqgvf3cfn1nd5",
     * "expiration":"3600"}}}
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
         * customer : {"id":123124,"title":"Mr","name":"Abc Def","email":"abc@xyz.com",
         * "mobile_number":12345678,"language":{"id":1,"name":"Malay"},"dob":"1991-06-20",
         * "race":{"id":1,"name":"Indian"},"max_failed_login":5,"email_subscribe":true,
         * "sms_subscribe":true,"token":{"token":"8s4ht6x8rlmq9k3cjigpqgvf3cfn1nd5",
         * "expiration":"3600"}}
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
