package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

public class AddressesData {

    private String address1;

    private String address2;

    private int city;

    private String country;

    @SerializedName("default_billing_address")
    private boolean defaultBillingAddress;

    @SerializedName("default_shipping_address")
    private boolean defaultShippingAddress;

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
    @SerializedName("phone_number")
    private String phoneNumber;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone_number) {
        this.phoneNumber = phone_number;
    }

    public boolean isDefaultShippingAddress() {
        return defaultShippingAddress;
    }

    public void setDefaultShippingAddress(boolean defaultShippingAddress) {
        this.defaultShippingAddress = defaultShippingAddress;
    }

    public boolean isDefaultBillingAddress() {
        return defaultBillingAddress;
    }

    public void setDefaultBillingAddress(boolean defaultBillingAddress) {
        this.defaultBillingAddress = defaultBillingAddress;
    }
}
