package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AddressData {
    private String city;

    private String country;

    @SerializedName("country_id")
    private String countryId;

    @SerializedName("default_billing")
    private boolean defaultBilling;

    @SerializedName("default_shipping")
    private boolean defaultShipping;

    private String firstname;

    /**
     * id : 13
     * firstname : Pankaj
     * lastname : Kavani
     * street : ["22nd street","Brickfields"]
     * country_id : MY
     * country : Malaysia
     * region_id : 512
     * region : Johor Darul Tazim
     * city : Nusajaya
     * postcode : 79100
     * telephone : 9999999999
     * default_shipping : true
     * default_billing : false
     */

    private String id;

    private String lastname;

    private String postcode;

    private String region;

    @SerializedName("region_id")
    private int regionId;

    private List<String> street;

    private String telephone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isDefaultShipping() {
        return defaultShipping;
    }

    public void setDefaultShipping(boolean defaultShipping) {
        this.defaultShipping = defaultShipping;
    }

    public boolean isDefaultBilling() {
        return defaultBilling;
    }

    public void setDefaultBilling(boolean defaultBilling) {
        this.defaultBilling = defaultBilling;
    }

    public List<String> getStreet() {
        return street;
    }

    public void setStreet(List<String> street) {
        this.street = street;
    }
}
