package com.goshop.app.presentation.model.widget;

public class QAVM {

    private String answersAmount;

    private String title;

    private String updateDate;

    public QAVM(String answersAmount, String title, String updateDate) {
        this.answersAmount = answersAmount;
        this.title = title;
        this.updateDate = updateDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswersAmount() {
        return answersAmount;
    }

    public void setAnswersAmount(String answersAmount) {
        this.answersAmount = answersAmount;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
