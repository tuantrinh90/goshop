package com.goshop.app.presentation.model;

import java.util.List;

public class RewardsDetailVM {

    private String dealId;

    private String dealName;

    private String dealDescription;

    private String dealStartDt;

    private String dealEndDt;

    private DealMerchantVM dealMerchantVM;

    private String dealImage;

    private DealStatusVM dealStatusVM;

    private List<DealCategoryVM> dealCategoryVMs;

    private List<DealLocationVM> dealLocationVMs;

    private String locations;

    private String merchantLogo;

    private int merchantLogoDefault;

    private String merchantName;

    private String promoDetail;

    private String promoDetailSummary;

    private String promoTerms;

    private List<String> promoTermsSummarys;

    private String promotionImage;

    private String promotionTime;

    private String promotionTitle;

    private int promtionImageDefault;

    private String timeLeft;

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

    public DealMerchantVM getDealMerchantVM() {
        return dealMerchantVM;
    }

    public void setDealMerchantVM(
        DealMerchantVM dealMerchantVM) {
        this.dealMerchantVM = dealMerchantVM;
    }

    public String getDealImage() {
        return dealImage;
    }

    public void setDealImage(String dealImage) {
        this.dealImage = dealImage;
    }

    public DealStatusVM getDealStatusVM() {
        return dealStatusVM;
    }

    public void setDealStatusVM(DealStatusVM dealStatusVM) {
        this.dealStatusVM = dealStatusVM;
    }

    public List<DealCategoryVM> getDealCategoryVMs() {
        return dealCategoryVMs;
    }

    public void setDealCategoryVMs(
        List<DealCategoryVM> dealCategoryVMs) {
        this.dealCategoryVMs = dealCategoryVMs;
    }

    public List<DealLocationVM> getDealLocationVMs() {
        return dealLocationVMs;
    }

    public void setDealLocationVMs(
        List<DealLocationVM> dealLocationVMs) {
        this.dealLocationVMs = dealLocationVMs;
    }

    public RewardsDetailVM() {
    }

    public RewardsDetailVM(String merchantName, String merchantLogo, int merchantLogoDefault,
        String promotionTitle,
        String promotionTime, String locations, String timeLeft, String promotionImage,
        int promtionImageDefault,
        String promoDetail, String promoDetailSummary, String promoTerms,
        List<String> promoTermsSummarys) {
        this.merchantName = merchantName;
        this.merchantLogo = merchantLogo;
        this.merchantLogoDefault = merchantLogoDefault;
        this.promotionTitle = promotionTitle;
        this.promotionTime = promotionTime;
        this.locations = locations;
        this.timeLeft = timeLeft;
        this.promtionImageDefault = promtionImageDefault;
        this.promotionImage = promotionImage;
        this.promoDetail = promoDetail;
        this.promoDetailSummary = promoDetailSummary;
        this.promoTerms = promoTerms;
        this.promoTermsSummarys = promoTermsSummarys;
    }

    public int getPromtionImageDefault() {
        return promtionImageDefault;
    }

    public void setPromtionImageDefault(int promtionImageDefault) {
        this.promtionImageDefault = promtionImageDefault;
    }

    public int getMerchantLogoDefault() {
        return merchantLogoDefault;
    }

    public void setMerchantLogoDefault(int merchantLogoDefault) {
        this.merchantLogoDefault = merchantLogoDefault;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getMerchantLogo() {
        return merchantLogo;
    }

    public void setMerchantLogo(String merchantLogo) {
        this.merchantLogo = merchantLogo;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getPromoDetail() {
        return promoDetail;
    }

    public void setPromoDetail(String promoDetail) {
        this.promoDetail = promoDetail;
    }

    public String getPromoDetailSummary() {
        return promoDetailSummary;
    }

    public void setPromoDetailSummary(String promoDetailSummary) {
        this.promoDetailSummary = promoDetailSummary;
    }

    public String getPromoTerms() {
        return promoTerms;
    }

    public void setPromoTerms(String promoTerms) {
        this.promoTerms = promoTerms;
    }

    public List<String> getPromoTermsSummarys() {
        return promoTermsSummarys;
    }

    public void setPromoTermsSummarys(List<String> promoTermsSummarys) {
        this.promoTermsSummarys = promoTermsSummarys;
    }

    public String getPromotionImage() {
        return promotionImage;
    }

    public void setPromotionImage(String promotionImage) {
        this.promotionImage = promotionImage;
    }

    public String getPromotionTime() {
        return promotionTime;
    }

    public void setPromotionTime(String promotionTime) {
        this.promotionTime = promotionTime;
    }

    public String getPromotionTitle() {
        return promotionTitle;
    }

    public void setPromotionTitle(String promotionTitle) {
        this.promotionTitle = promotionTitle;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }
}
