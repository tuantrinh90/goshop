package com.goshop.app.data.model.response;

/**
 * Created by img on 2018/1/18.
 */

public class PromotionLandingResponse {
    private String imageUrl;
    private String productName;
    private String productOldPrice;
    private String productCurrentPrice;
    private String productOff;
    private boolean isTvShow;
    private boolean isGiftShow;
    private boolean isBest;
    private boolean isNew;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductOldPrice() {
        return productOldPrice;
    }

    public void setProductOldPrice(String productOldPrice) {
        this.productOldPrice = productOldPrice;
    }

    public String getProductCurrentPrice() {
        return productCurrentPrice;
    }

    public void setProductCurrentPrice(String productCurrentPrice) {
        this.productCurrentPrice = productCurrentPrice;
    }

    public String getProductOff() {
        return productOff;
    }

    public void setProductOff(String productOff) {
        this.productOff = productOff;
    }

    public boolean isTvShow() {
        return isTvShow;
    }

    public void setTvShow(boolean tvShow) {
        isTvShow = tvShow;
    }

    public boolean isGiftShow() {
        return isGiftShow;
    }

    public void setGiftShow(boolean giftShow) {
        isGiftShow = giftShow;
    }

    public boolean isBest() {
        return isBest;
    }

    public void setBest(boolean best) {
        isBest = best;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }
}
