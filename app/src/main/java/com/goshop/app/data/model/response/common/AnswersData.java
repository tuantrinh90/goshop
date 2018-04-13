package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

public class AnswersData {

    /**
     * answer : Lorem Ipsum
     * answer_date : 2018-01-30
     */

    private String answer;

    @SerializedName("answer_date")
    private String answerDate;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(String answerDate) {
        this.answerDate = answerDate;
    }
}
