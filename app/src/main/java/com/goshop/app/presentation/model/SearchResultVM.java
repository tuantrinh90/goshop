package com.goshop.app.presentation.model;

public class SearchResultVM extends SearchFilterModel {

    private int iconDetail;

    private int iconGift;

    private int iconTv;

    private boolean isBest;

    private boolean isNew;

    private String nowPrice;

    private String oldPrice;

    private String precent;

    private String title;

    public SearchResultVM(int iconDetail, int iconGift, int iconTv, boolean isBest,
        boolean isNew, String nowPrice, String oldPrice, String precent, String title) {
        super(SearchFilterModel.SEARCH_RESULT);
        this.iconDetail = iconDetail;
        this.iconGift = iconGift;
        this.iconTv = iconTv;
        this.isBest = isBest;
        this.isNew = isNew;
        this.nowPrice = nowPrice;
        this.oldPrice = oldPrice;
        this.precent = precent;
        this.title = title;
    }

    public int getIconDetail() {
        return iconDetail;
    }

    public void setIconDetail(int iconDetail) {
        this.iconDetail = iconDetail;
    }

    public int getIconGift() {
        return iconGift;
    }

    public void setIconGift(int iconGift) {
        this.iconGift = iconGift;
    }

    public int getIconTv() {
        return iconTv;
    }

    public void setIconTv(int iconTv) {
        this.iconTv = iconTv;
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

    public String getPrecent() {
        return precent;
    }

    public void setPrecent(String precent) {
        this.precent = precent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
