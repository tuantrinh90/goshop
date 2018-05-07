package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

public class RewardResponse {

    /**
     * "customer_id": "20180424034839",
     * "deal_id": "20180424040110",
     * "reward_id": "20180424189928",
     * "reward_code": "ABCDE223K2",
     * "reward_expiry_dt": "2018-12-01",
     * "inst_id": "haikalghazali",
     * "inst_dtm": "2018-08-01"
     */
    @SerializedName("customer_id")
    private String customerId;

    @SerializedName("deal_id")
    private String dealId;

    @SerializedName("reward_id")
    private String rewardId;

    @SerializedName("reward_code")
    private String rewardCode;

    @SerializedName("reward_expiry_dt")
    private String rewardExpiryDt;

    @SerializedName("inst_id")
    private String instId;

    @SerializedName("inst_dtm")
    private String instDtm;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public String getRewardCode() {
        return rewardCode;
    }

    public void setRewardCode(String rewardCode) {
        this.rewardCode = rewardCode;
    }

    public String getRewardExpiryDt() {
        return rewardExpiryDt;
    }

    public void setRewardExpiryDt(String rewardExpiryDt) {
        this.rewardExpiryDt = rewardExpiryDt;
    }

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public String getInstDtm() {
        return instDtm;
    }

    public void setInstDtm(String instDtm) {
        this.instDtm = instDtm;
    }
}
