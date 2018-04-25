package com.goshop.app.presentation.model;

public class ApplyEGiftVM {

    private String eGiftAmount;

    private String eGiftApplied;

    private String eGiftBalance;

    private String priceNew;

    private String priceOriginal;

    public String geteGiftAmount() {
        return eGiftAmount;
    }

    public void seteGiftAmount(String eGiftAmount) {
        this.eGiftAmount = eGiftAmount;
    }

    public String geteGiftApplied() {
        return eGiftApplied;
    }

    public void seteGiftApplied(String eGiftApplied) {
        this.eGiftApplied = eGiftApplied;
    }

    public String geteGiftBalance() {
        return eGiftBalance;
    }

    public void seteGiftBalance(String eGiftBalance) {
        this.eGiftBalance = eGiftBalance;
    }

    public String getPriceNew() {
        return priceNew;
    }

    public void setPriceNew(String priceNew) {
        this.priceNew = priceNew;
    }

    public String getPriceOriginal() {
        return priceOriginal;
    }

    public void setPriceOriginal(String priceOriginal) {
        this.priceOriginal = priceOriginal;
    }
}
