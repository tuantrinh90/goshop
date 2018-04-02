package com.goshop.app.data.model.response;

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

        private CustomerData customer;

        public CustomerData getCustomer() {
            return customer;
        }

        public void setCustomer(CustomerData customer) {
            this.customer = customer;
        }

        public static class CustomerData {

            /**
             * email : john@gmail.com
             */

            private String email;

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }
        }
    }
}
