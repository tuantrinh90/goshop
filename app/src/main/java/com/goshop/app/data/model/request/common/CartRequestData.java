package com.goshop.app.data.model.request.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CartRequestData {

    private String qty;

    private String sku;

    @SerializedName("store_id")
    private int storeId;

    private List<SuperAttributesData> super_attributes;

    /**
     * website_id : 1
     * store_id : 3
     * sku : 200000140011
     * super_attributes : [{"id":"123","variant_id":"7451"},{"id":"234","variant_id":"567"}]
     * qty : 5
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public List<SuperAttributesData> getSuper_attributes() {
        return super_attributes;
    }

    public void setSuper_attributes(List<SuperAttributesData> super_attributes) {
        this.super_attributes = super_attributes;
    }
}
