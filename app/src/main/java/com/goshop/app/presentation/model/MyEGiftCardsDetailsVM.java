package com.goshop.app.presentation.model;

public class MyEGiftCardsDetailsVM extends MyEGiftModel {

    private String date;

    private String price;

    private String sender;

    private String status;

    private String title;

    public MyEGiftCardsDetailsVM(String title, String sender, String date,
        String price, String status) {
        super(MyEGiftModel.VIEW_TYPE_DETAIL);
        this.title = title;
        this.sender = sender;
        this.date = date;
        this.price = price;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
