package com.goshop.app.presentation.model;

import java.util.Map;

public class MyOrdersProductVM {

    private Map<String, String> attrMap;

    private String count;

    private String percent;

    private String priceNow;

    private String priceOld;

    private String statuContent;

    private String statuNo;

    private String thumb;

    private int thumbDefault;

    private String title;

    public MyOrdersProductVM(String statuNo, String statuContent, String thumb, int thumbDefault,
        String title, Map<String, String> attrMap, String priceOld, String priceNow, String count,
        String percent) {
        this.statuNo = statuNo;
        this.statuContent = statuContent;
        this.thumb = thumb;
        this.thumbDefault = thumbDefault;
        this.title = title;
        this.attrMap = attrMap;
        this.priceOld = priceOld;
        this.priceNow = priceNow;
        this.count = count;
        this.percent = percent;
    }

    public Map<String, String> getAttrMap() {
        return attrMap;
    }

    public void setAttrMap(Map<String, String> attrMap) {
        this.attrMap = attrMap;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public int getThumbDefault() {
        return thumbDefault;
    }

    public void setThumbDefault(int thumbDefault) {
        this.thumbDefault = thumbDefault;
    }

    public String getStatuNo() {
        return statuNo;
    }

    public void setStatuNo(String statuNo) {
        this.statuNo = statuNo;
    }

    public String getStatuContent() {
        return statuContent;
    }

    public void setStatuContent(String statuContent) {
        this.statuContent = statuContent;
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
}
