package com.goshop.app.presentation.model;

public class QuestionAnswerDataVM {

    private String content;

    private String count;

    private String date;

    private String title;

    private String user;

    public QuestionAnswerDataVM(String title, String content, String count, String date) {
        this.title = title;
        this.content = content;
        this.count = count;
        this.date = date;
    }

    public QuestionAnswerDataVM(String title, String user) {
        this.title = title;
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
