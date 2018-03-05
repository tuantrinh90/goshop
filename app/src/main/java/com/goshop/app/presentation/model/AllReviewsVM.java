package com.goshop.app.presentation.model;

import com.goshop.app.presentation.model.widget.ReviewsVM;

import java.util.List;

public class AllReviewsVM {

    private String amount;

    private List<ReviewsVM> reviewsVMS;

    private float step;

    private String thumb;

    private int thumbDefault;

    public AllReviewsVM(String thumb, int thumbDefault, float step, String amount,
        List<ReviewsVM> reviewsVMS) {
        this.thumb = thumb;
        this.thumbDefault = thumbDefault;
        this.step = step;
        this.amount = amount;
        this.reviewsVMS = reviewsVMS;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public int getThumbDefault() {
        return thumbDefault;
    }

    public void setThumbDefault(int thumbDefault) {
        this.thumbDefault = thumbDefault;
    }

    public float getStep() {
        return step;
    }

    public void setStep(float step) {
        this.step = step;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public List<ReviewsVM> getReviewsVMS() {
        return reviewsVMS;
    }

    public void setReviewsVMS(List<ReviewsVM> reviewsVMS) {
        this.reviewsVMS = reviewsVMS;
    }
}
