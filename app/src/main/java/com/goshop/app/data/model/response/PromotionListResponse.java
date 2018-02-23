package com.goshop.app.data.model.response;

import java.util.List;

public class PromotionListResponse {

    private String bannerUrl;

    private List<PromotionItem> promotionItems;

    private String title;

    public List<PromotionItem> getPromotionItems() {
        return promotionItems;
    }

    public void setPromotionItems(
        List<PromotionItem> promotionItems) {
        this.promotionItems = promotionItems;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static class PromotionItem {

        private String imageUrl;

        private boolean isBest;

        private boolean isGiftShow;

        private boolean isNew;

        private boolean isTvShow;

        private String productCurrentPrice;

        private String productName;

        private String productOff;

        private String productOldPrice;

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


}
