package com.goshop.app.data.model.request;


public class AddressRequest {

    /**
     * request : {"website_id":1,"store_id":3,"address":{"name":"Abc Def","address1":"Bukit
     * Jalil","address2":"Astro","country":"MY","state":123,"city":123,"zipcode":50470,
     * "phone_number":"60212314135","default_shipping_address":false}}
     */

    private RequestData request;

    public RequestData getRequest() {
        return request;
    }

    public void setRequest(RequestData request) {
        this.request = request;
    }

    public static class RequestData {

        private AddressData address;

        private int store_id;

        /**
         * website_id : 1
         * store_id : 3
         * address : {"name":"Abc Def","address1":"Bukit Jalil","address2":"Astro",
         * "country":"MY","state":123,"city":123,"zipcode":50470,"phone_number":"60212314135",
         * "default_shipping_address":false}
         */

        private int website_id;

        public int getWebsite_id() {
            return website_id;
        }

        public void setWebsite_id(int website_id) {
            this.website_id = website_id;
        }

        public int getStore_id() {
            return store_id;
        }

        public void setStore_id(int store_id) {
            this.store_id = store_id;
        }

        public AddressData getAddress() {
            return address;
        }

        public void setAddress(AddressData address) {
            this.address = address;
        }

        public static class AddressData {

            private String address1;

            private String address2;

            private int city;

            private String country;

            private boolean default_shipping_address;

            /**
             * name : Abc Def
             * address1 : Bukit Jalil
             * address2 : Astro
             * country : MY
             * state : 123
             * city : 123
             * zipcode : 50470
             * phone_number : 60212314135
             * default_shipping_address : false
             */

            private String name;

            private String phone_number;

            private int state;

            private int zipcode;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAddress1() {
                return address1;
            }

            public void setAddress1(String address1) {
                this.address1 = address1;
            }

            public String getAddress2() {
                return address2;
            }

            public void setAddress2(String address2) {
                this.address2 = address2;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public int getCity() {
                return city;
            }

            public void setCity(int city) {
                this.city = city;
            }

            public int getZipcode() {
                return zipcode;
            }

            public void setZipcode(int zipcode) {
                this.zipcode = zipcode;
            }

            public String getPhone_number() {
                return phone_number;
            }

            public void setPhone_number(String phone_number) {
                this.phone_number = phone_number;
            }

            public boolean isDefault_shipping_address() {
                return default_shipping_address;
            }

            public void setDefault_shipping_address(boolean default_shipping_address) {
                this.default_shipping_address = default_shipping_address;
            }
        }
    }
}
