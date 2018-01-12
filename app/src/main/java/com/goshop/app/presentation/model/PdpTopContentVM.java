package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/1/11.
 */

public class PdpTopContentVM extends ProductDetailModel {

    private String counts;

    private String nowPrice;

    private String oldPrice;

    private String percent;

    private String quantity;

    private int ratingNum;

    private String title;

    public PdpTopContentVM() {
        super(ProductDetailModel.DETAIL_TOP_CONTENT);
    }

    public PdpTopContentVM(String title, String nowPrice, String oldPrice,
        String percent, int ratingNum, String counts, String quantity) {
        super(ProductDetailModel.DETAIL_TOP_CONTENT);
        this.title = title;
        this.nowPrice = nowPrice;
        this.oldPrice = oldPrice;
        this.percent = percent;
        this.ratingNum = ratingNum;
        this.counts = counts;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(String nowPrice) {
        this.nowPrice = nowPrice;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public int getRatingNum() {
        return ratingNum;
    }

    public void setRatingNum(int ratingNum) {
        this.ratingNum = ratingNum;
    }

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
