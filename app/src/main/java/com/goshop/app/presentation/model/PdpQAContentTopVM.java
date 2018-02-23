package com.goshop.app.presentation.model;

public class PdpQAContentTopVM extends ProductDetailModel {

    private String answerNum;

    private String questionNum;

    public PdpQAContentTopVM() {
        super(ProductDetailModel.DETAIL_QA_CONTENT_TOP);
    }

    public PdpQAContentTopVM(String questionNum, String answerNum) {
        super(ProductDetailModel.DETAIL_QA_CONTENT_TOP);
        this.questionNum = questionNum;
        this.answerNum = answerNum;
    }

    public String getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(String questionNum) {
        this.questionNum = questionNum;
    }

    public String getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(String answerNum) {
        this.answerNum = answerNum;
    }
}
