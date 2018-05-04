package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DealsData {

    @SerializedName("deal_category")
    private List<DealCategoryData> dealCategory;

    @SerializedName("deal_end_dt")
    private String dealEndDt;

    /**
     * deal_id : 20180424040110
     * deal_name : Last day promo
     * deal_start_dt : 2018-04-02
     * deal_end_dt : 2018-05-10
     * deal_merchant : {"merchant_id":"20180419133833","merchant_name":"Starbucks"}
     * deal_image : http://image.goshop.com.my/deal/<deal_id>/<file_name>.<file_type>
     * deal_category : [{"category_id":"2","category_name":"Food"}]
     * deal_location : [{"location_id":"1","location_name":"Kuala Lumpur"},
     * {"location_id":"2","location_name":"Selangor"}]
     * deal_status : {"status_id":"1","status_name":"New"}
     */

    @SerializedName("deal_id")
    private String dealId;

    @SerializedName("deal_image")
    private String dealImage;

    @SerializedName("deal_location")
    private List<DealLocationData> dealLocation;

    @SerializedName("deal_merchant")
    private DealMerchantData dealMerchant;

    @SerializedName("deal_name")
    private String dealName;

    @SerializedName("deal_start_dt")
    private String dealStartDt;

    @SerializedName("deal_status")
    private DealStatusData dealStatus;

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public String getDealStartDt() {
        return dealStartDt;
    }

    public void setDealStartDt(String dealStartDt) {
        this.dealStartDt = dealStartDt;
    }

    public String getDealEndDt() {
        return dealEndDt;
    }

    public void setDealEndDt(String dealEndDt) {
        this.dealEndDt = dealEndDt;
    }

    public DealMerchantData getDealMerchant() {
        return dealMerchant;
    }

    public void setDealMerchant(DealMerchantData dealMerchant) {
        this.dealMerchant = dealMerchant;
    }

    public String getDealImage() {
        return dealImage;
    }

    public void setDealImage(String dealImage) {
        this.dealImage = dealImage;
    }

    public DealStatusData getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(DealStatusData dealStatus) {
        this.dealStatus = dealStatus;
    }

    public List<DealCategoryData> getDealCategory() {
        return dealCategory;
    }

    public void setDealCategory(List<DealCategoryData> dealCategory) {
        this.dealCategory = dealCategory;
    }

    public List<DealLocationData> getDealLocation() {
        return dealLocation;
    }

    public void setDealLocation(List<DealLocationData> dealLocation) {
        this.dealLocation = dealLocation;
    }
}
