package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class AddressesData {

    private String city;

    @SerializedName("country_id")
    private String countryId;

    @SerializedName("default_billing")
    private boolean defaultBilling;

    @SerializedName("default_shipping")
    private boolean defaultShipping;

    @SerializedName("firstname")
    private String firstName;

    /**
     * id : 29
     * firstname : Pankaj
     * lastname : Kavani
     * street : {"0":"Bukit Jalil","1":"Astro"}
     * country_id : MY
     * region_id : 512
     * city : Alor Setar
     * postcode : 12345
     * telephone : 9999999999
     * default_billing : true
     * default_shipping : true
     */

    private String id;

    @SerializedName("lastname")
    private String lastName;

    @SerializedName("postcode")
    private String postCode;

    @SerializedName("region_id")
    private String regionId;

    private Map<String, Object> street;

    private String telephone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Map<String, Object> getStreet() {
        return street;
    }

    public void setStreet(Map<String, Object> street) {
        this.street = street;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
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
