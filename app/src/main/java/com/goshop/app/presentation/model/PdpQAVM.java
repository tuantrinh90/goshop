package com.goshop.app.presentation.model;

import com.goshop.app.presentation.model.widget.QAVM;

import java.util.List;

public class PdpQAVM extends ProductDetailModel {

    private String answersCounts;

    private List<QAVM> qavms;

    private String questionCounts;

    public PdpQAVM(String answersCounts, String questionCounts, List<QAVM> qavms) {
        super(ProductDetailModel.DETAIL_QUESTION_ANSWER);
        this.answersCounts = answersCounts;
        this.qavms = qavms;
        this.questionCounts = questionCounts;
    }

    public String getAnswersCounts() {
        return answersCounts;
    }

    public void setAnswersCounts(String answersCounts) {
        this.answersCounts = answersCounts;
    }

    public List<QAVM> getQavms() {
        return qavms;
    }

    public void setQavms(List<QAVM> qavms) {
        this.qavms = qavms;
    }

    public String getQuestionCounts() {
        return questionCounts;
    }

    public void setQuestionCounts(String questionCounts) {
        this.questionCounts = questionCounts;
    }
}
