package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/1/12.
 */

public class PdpQAContentVM extends ProductDetailModel {

    private String question;
    private String questionerDetail;
    private String answer;
    private String answerDetail;

    public PdpQAContentVM() {
        super(ProductDetailModel.DETAIL_QA_CONTENT);
    }

    public PdpQAContentVM(String question, String questionerDetail,
        String answer, String answerDetail) {
        super(ProductDetailModel.DETAIL_QA_CONTENT);
        this.question = question;
        this.questionerDetail = questionerDetail;
        this.answer = answer;
        this.answerDetail = answerDetail;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestionerDetail() {
        return questionerDetail;
    }

    public void setQuestionerDetail(String questionerDetail) {
        this.questionerDetail = questionerDetail;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswerDetail() {
        return answerDetail;
    }

    public void setAnswerDetail(String answerDetail) {
        this.answerDetail = answerDetail;
    }
}
