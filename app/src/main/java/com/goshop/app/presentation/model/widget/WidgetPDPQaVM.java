package com.goshop.app.presentation.model.widget;

import java.util.List;

public class WidgetPDPQaVM extends WidgetViewModel {

    private String answersCounts;

    private List<QAVM> qavms;

    private String questionCounts;

    public WidgetPDPQaVM(String questionCounts, String answersCounts,
        List<QAVM> qavms) {
        super(WidgetViewModel.VIEW_TYPE_PDP_QA);
        this.questionCounts = questionCounts;
        this.answersCounts = answersCounts;
        this.qavms = qavms;
    }

    public String getQuestionCounts() {
        return questionCounts;
    }

    public void setQuestionCounts(String questionCounts) {
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


}
