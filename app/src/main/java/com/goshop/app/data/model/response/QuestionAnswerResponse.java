package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

import com.goshop.app.data.model.response.common.PaginationData;
import com.goshop.app.data.model.response.common.QuestionsData;

import java.util.List;

public class QuestionAnswerResponse {

    private PaginationData pagination;

    private List<QuestionsData> questions;

    @SerializedName("total_answers")
    private String totalAnswers;

    /**
     * total_questions : 100
     * total_answers : 4
     * questions : [{"question":"Lorem Ipsum","question_date":"2018-01-30",
     * "answers":[{"answer":"Lorem Ipsum","answer_date":"2018-01-30"}]},{"question":"Lorem
     * Ipsum","question_date":"2018-01-30","answers":[{"answer":"Lorem Ipsum",
     * "answer_date":"2018-01-30"},{"answer":"Lorem Ipsum","answer_date":"2018-01-30"}]}]
     * pagination : {"total_pages":5,"current_page":2,"limit":10,
     * "next":"http://<domain-name>/<base-path>/product/<sku>/question-answer?website_id=1
     * &store_id=3&page=3&limit=10","previous":"http://<domain-name>/<base-path>/product/<sku
     * >/question-answer?website_id=1&store_id=3&page=1&limit=10"}
     */

    @SerializedName("total_questions")
    private String totalQuestions;

    public String getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(String totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public String getTotalAnswers() {
        return totalAnswers;
    }

    public void setTotalAnswers(String totalAnswers) {
        this.totalAnswers = totalAnswers;
    }

    public PaginationData getPagination() {
        return pagination;
    }

    public void setPagination(PaginationData pagination) {
        this.pagination = pagination;
    }

    public List<QuestionsData> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionsData> questions) {
        this.questions = questions;
    }


}
