package com.goshop.app.presentation.model;

public class SelectAddressVM {

    private String address;

    private String city;

    private String code;

    private String country;

    private boolean isShipping;

    private String name;

    private String state;

    private String tel;

    private String type;

    public SelectAddressVM(String name, String address, String city, String state,
        String code, String country, String tel, boolean isShipping) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.code = code;
        this.country = country;
        this.tel = tel;
        this.isShipping = isShipping;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isShipping() {
        return isShipping;
    }

    public void setShipping(boolean shipping) {
        isShipping = shipping;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
