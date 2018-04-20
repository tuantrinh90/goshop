package com.goshop.app.presentation.model;

import java.util.List;

public class ProductDetailTopVM extends ProductDetailModel {

    private String amount;

    private List<ColorVM> colorVMS;

    private String percent;

    private String priceNow;

    private String priceOld;

    private List<SizeVM> sizeVMS;

    private String title;

    private String sku;

    public ProductDetailTopVM(String sku, String title,
        String priceOld, String priceNow, String percent,
        List<ColorVM> colorVMS, List<SizeVM> sizeVMS, String amount) {
        super(ProductDetailModel.DETAIL_TOP_VIEW);
        this.sku = sku;
        this.title = title;
        this.priceOld = priceOld;
        this.priceNow = priceNow;
        this.percent = percent;
        this.colorVMS = colorVMS;
        this.sizeVMS = sizeVMS;
        this.amount = amount;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(String priceOld) {
        this.priceOld = priceOld;
    }

    public String getPriceNow() {
        return priceNow;
    }

    public void setPriceNow(String priceNow) {
        this.priceNow = priceNow;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public List<ColorVM> getColorVMS() {
        return colorVMS;
    }

    public void setColorVMS(List<ColorVM> colorVMS) {
        this.colorVMS = colorVMS;
    }

    public List<SizeVM> getSizeVMS() {
        return sizeVMS;
    }

    public void setSizeVMS(List<SizeVM> sizeVMS) {
        this.sizeVMS = sizeVMS;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

}
