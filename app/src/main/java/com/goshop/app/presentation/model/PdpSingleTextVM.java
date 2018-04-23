package com.goshop.app.presentation.model;

public class PdpSingleTextVM extends ProductDetailModel {

    private String content;

    public PdpSingleTextVM(String content) {
        super(ProductDetailModel.DETAIL_SINGLE_TEXT);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
