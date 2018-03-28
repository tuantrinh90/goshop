package com.goshop.app.presentation.model;

import java.util.List;

public class RewardsDetailVM {

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
