package com.goshop.app.data.model.response;

import java.util.List;

public class AddressResponse extends Response {

    /**
     * data : {"customer":{"id":2345,"addresses":[{"id":1234,"name":"Abc Def","address1":"Bukit
     * Jalil","address2":"Astro","country":"MY","state":123,"city":123,"zipcode":50470,
     * "phone_number":"601213123123","default_shipping_address":true,
     * "default_billing_address":true},{"id":1234,"name":"Abc Def","address1":"Bukit Jalil",
     * "address2":"Astro","country":"MY","state":123,"city":123,"zipcode":50470,
     * "phone_number":"601213123123","default_shipping_address":1,"default_billing_address":1}]}}
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

        public static class CustomerData {

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

            public static class AddressesData {

                private String address1;

                private String address2;

                private int city;

                private String country;

                private boolean default_billing_address;

                private boolean default_shipping_address;

                /**
                 * id : 1234
                 * name : Abc Def
                 * address1 : Bukit Jalil
                 * address2 : Astro
                 * country : MY
                 * state : 123
                 * city : 123
                 * zipcode : 50470
                 * phone_number : 601213123123
                 * default_shipping_address : true
                 * default_billing_address : true
                 */

                private int id;

                private String name;

                private String phone_number;

                private int state;

                private int zipcode;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

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

                public boolean isDefault_billing_address() {
                    return default_billing_address;
                }

                public void setDefault_billing_address(boolean default_billing_address) {
                    this.default_billing_address = default_billing_address;
                }
            }
        }
    }
}
