package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/1/12.
 */

public class PdpQAContentTopVM extends ProductDetailModel {

    private String questionNum;
    private String answerNum;

    public PdpQAContentTopVM() {
        super(ProductDetailModel.DETAIL_QA_CONTENT_TOP);
    }

    public PdpQAContentTopVM(String questionNum, String answerNum) {
        super(ProductDetailModel.DETAIL_QA_CONTENT_TOP);
        this.questionNum = questionNum;
        this.answerNum = answerNum;
    }
}
