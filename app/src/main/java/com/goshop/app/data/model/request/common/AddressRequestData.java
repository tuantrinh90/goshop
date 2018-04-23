package com.goshop.app.data.model.request.common;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class AddressRequestData {

    private String city;

    @SerializedName("country_id")
    private String countryId;

    @SerializedName("default_billing")
    private boolean defaultBilling;

    @SerializedName("default_shipping")
    private boolean defaultShipping;

    @SerializedName("firstname")
    private String firstName;

    @SerializedName("lastname")
    private String lastName;

    private int postcode;

    @SerializedName("region_id")
    private int regionId;

    @SerializedName("store_id")
    private String storeId;

    private HashMap<String, Object> street;

    private String telephone;

    /**
     * website_id : 1
     * store_id : 3
     * firstname : Pankaj
     * lastname : Kavani
     * street : {"0":"Bukit Jalil","1":"Astro"}
     * country_id : MY
     * region_id : 520
     * city : Alor Setar
     * postcode : 12345
     * telephone : 9999999999
     * default_billing : true
     * default_shipping : true
     */

    @SerializedName("website_id")
    private String websiteId;

    public String getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(String websiteId) {
        this.websiteId = websiteId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public HashMap<String, Object> getStreet() {
        return street;
    }

    public void setStreet(HashMap<String, Object> street) {
        this.street = street;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isDefaultBilling() {
        return defaultBilling;
    }

    public void setDefaultBilling(boolean defaultBilling) {
        this.defaultBilling = defaultBilling;
    }

    public boolean isDefaultShipping() {
        return defaultShipping;
    }

    public void setDefaultShipping(boolean defaultShipping) {
        this.defaultShipping = defaultShipping;
    }
}
