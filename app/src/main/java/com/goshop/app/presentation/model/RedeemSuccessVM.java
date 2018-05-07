package com.goshop.app.presentation.model;


public class RedeemSuccessVM {

    private String customerId;

    private String dealId;

    private String rewardId;

    private String rewardCode;

    private String rewardExpiryDt;

    private String instId;

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
