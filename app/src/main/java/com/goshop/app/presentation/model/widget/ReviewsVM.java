package com.goshop.app.presentation.model.widget;

public class ReviewsVM {

    private String details;

    private String reviewDate;

    private float starStep;

    private String title;

    private String userName;

    public ReviewsVM(float starStep, String title, String details, String userName,
        String reviewDate) {
        this.details = details;
        this.reviewDate = reviewDate;
        this.starStep = starStep;
        this.title = title;
        this.userName = userName;
    }

    public float getStarStep() {
        return starStep;
    }

    public void setStarStep(float starStep) {
        this.starStep = starStep;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }
}
