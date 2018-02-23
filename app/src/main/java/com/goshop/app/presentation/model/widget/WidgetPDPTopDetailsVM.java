package com.goshop.app.presentation.model.widget;

import java.util.List;

public class WidgetPDPTopDetailsVM extends WidgetViewModel {

    private String amount;

    private String nowPrice;

    private String oldPrice;

    private List<ColorVM> pdpColors;

    private List<String> pdpSizes;

    private String percent;

    private String starNum;

    private float starStep;

    private List<String> tips;

    private String title;

    public WidgetPDPTopDetailsVM(String title, String oldPrice, String nowPrice,
        String percent, float starStep, String starNum, List<String> tips, List<ColorVM> pdpColors,
        List<String> pdpSizes, String amount) {
        super(WidgetViewModel.VIEW_TYPE_PDP_TOP_DETAILS);
        this.title = title;
        this.oldPrice = oldPrice;
        this.nowPrice = nowPrice;
        this.percent = percent;
        this.starStep = starStep;
        this.starNum = starNum;
        this.tips = tips;
        this.pdpColors = pdpColors;
        this.pdpSizes = pdpSizes;
        this.amount = amount;

    }

    public float getStarStep() {
        return starStep;
    }

    public void setStarStep(float starStep) {
        this.starStep = starStep;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(String nowPrice) {
        this.nowPrice = nowPrice;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getStarNum() {
        return starNum;
    }

    public void setStarNum(String starNum) {
        this.starNum = starNum;
    }

    public List<String> getTips() {
        return tips;
    }

    public void setTips(List<String> tips) {
        this.tips = tips;
    }

    public List<ColorVM> getPdpColors() {
        return pdpColors;
    }

    public void setPdpColors(List<ColorVM> pdpColors) {
        this.pdpColors = pdpColors;
    }

    public List<String> getPdpSizes() {
        return pdpSizes;
    }

    public void setPdpSizes(List<String> pdpSizes) {
        this.pdpSizes = pdpSizes;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
