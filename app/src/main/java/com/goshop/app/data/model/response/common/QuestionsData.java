package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionsData {

    private List<AnswersData> answers;

    /**
     * question : Lorem Ipsum
     * question_date : 2018-01-30
     * answers : [{"answer":"Lorem Ipsum","answer_date":"2018-01-30"}]
     */

    private String question;

    @SerializedName("question_date")
    private String questionDate;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestionDate() {
        return questionDate;
    }

    public void setQuestionDate(String questionDate) {
        this.questionDate = questionDate;
    }

    public List<AnswersData> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswersData> answers) {
        this.answers = answers;
    }
}
