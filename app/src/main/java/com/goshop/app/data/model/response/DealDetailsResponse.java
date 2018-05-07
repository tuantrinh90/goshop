package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DealDetailsResponse {

    @SerializedName("deal_id")
    private String dealId;

    @SerializedName("deal_name")
    private String dealName;

    @SerializedName("deal_description")
    private String dealDescription;

    @SerializedName("deal_start_dt")
    private String dealStartDt;

    @SerializedName("deal_end_dt")
    private String dealEndDt;

    @SerializedName("deal_merchant")
    private DealMerchantResponse dealMerchantResponse;

    @SerializedName("deal_image")
    private String dealImage;

    @SerializedName("deal_status")
    private DealStatusResponse dealStatusResponse;

    @SerializedName("deal_category")
    private List<DealCategoryResponse> dealCategoryResponses;

    @SerializedName("deal_location")
    private List<DealLocationResponse> dealLocationResponses;

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

    public String getDealDescription() {
        return dealDescription;
    }

    public void setDealDescription(String dealDescription) {
        this.dealDescription = dealDescription;
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

    public DealMerchantResponse getDealMerchantResponse() {
        return dealMerchantResponse;
    }

    public void setDealMerchantResponse(DealMerchantResponse dealMerchantResponse) {
        this.dealMerchantResponse = dealMerchantResponse;
    }

    public String getDealImage() {
        return dealImage;
    }

    public void setDealImage(String dealImage) {
        this.dealImage = dealImage;
    }

    public DealStatusResponse getDealStatusResponse() {
        return dealStatusResponse;
    }

    public void setDealStatusResponse(DealStatusResponse dealStatusResponse) {
        this.dealStatusResponse = dealStatusResponse;
    }

    public List<DealCategoryResponse> getDealCategoryResponses() {
        return dealCategoryResponses;
    }

    public void setDealCategoryResponses(List<DealCategoryResponse> dealCategoryResponses) {
        this.dealCategoryResponses = dealCategoryResponses;
    }

    public List<DealLocationResponse> getDealLocationResponses() {
        return dealLocationResponses;
    }

    public void setDealLocationResponses(List<DealLocationResponse> dealLocationResponses) {
        this.dealLocationResponses = dealLocationResponses;
    }


}
