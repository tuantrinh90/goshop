package com.goshop.app.data.model.request.common;

import com.google.gson.annotations.SerializedName;

public class RequestData {

    private AddressData address;

    @SerializedName("store_id")
    private int storeId;

    /**
     * website_id : 1
     * store_id : 3
     * address : {"name":"Abc Def","address1":"Bukit Jalil","address2":"Astro",
     * "country":"MY","state":123,"city":123,"zipcode":50470,"phone_number":"60212314135",
     * "default_shipping_address":false,"default_billing_address":false}
     */

    @SerializedName("website_id")
    private int websiteId;

    public int getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(int websiteId) {
        this.websiteId = websiteId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public AddressData getAddress() {
        return address;
    }

    public void setAddress(AddressData address) {
        this.address = address;
    }
}
