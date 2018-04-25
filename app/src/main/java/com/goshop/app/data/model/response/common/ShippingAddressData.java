package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class ShippingAddressData {

    private String city;

    private String country;

    /**
     * firstname : Pankaj
     * lastname : Kavani
     * street : {"0":"Bukit Jalil","1":"Astro"}
     * country : Malaysia
     * region : Kualalumpur
     * city : Alor Setar
     * postcode : 12345
     * telephone : 9999999999
     */

    @SerializedName("firstname")
    private String firstName;

    @SerializedName("lastname")
    private String lastName;

    private int postcode;

    private String region;

    private Map<String, Object> street;

    private String telephone;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
}
