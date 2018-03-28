package com.goshop.app.presentation.model;

import java.util.List;

public class QuestionAnswerVM {

    private String answerTotal;

    private List<QuestionAnswerDataVM> dataVMS;

    private String questionTotal;

    public QuestionAnswerVM(String questionTotal, String answerTotal,
        List<QuestionAnswerDataVM> dataVMS) {
        this.questionTotal = questionTotal;
        this.answerTotal = answerTotal;
        this.dataVMS = dataVMS;
    }

    public List<QuestionAnswerDataVM> getDataVMS() {
        return dataVMS;
    }

    public void setDataVMS(List<QuestionAnswerDataVM> dataVMS) {
        this.dataVMS = dataVMS;
    }

    public String getQuestionTotal() {
        return questionTotal;
    }

    public void setQuestionTotal(String questionTotal) {
        this.questionTotal = questionTotal;
    }

    public String getAnswerTotal() {
        return answerTotal;
    }

    public void setAnswerTotal(String answerTotal) {
        this.answerTotal = answerTotal;
    }


}
