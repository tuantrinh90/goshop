package com.goshop.app.presentation.model;

import com.goshop.app.presentation.model.widget.ReviewsVM;

import java.util.List;

public class PdpReviewsVM extends ProductDetailModel {

    private String reviewsCounts;

    private List<ReviewsVM> reviewsVMS;

    private float totalStarStep;

    public PdpReviewsVM(float totalStarStep, String reviewsCounts,
        List<ReviewsVM> reviewsVMS) {
        super(ProductDetailModel.DETAIL_REVIEWS);
        this.totalStarStep = totalStarStep;
        this.reviewsCounts = reviewsCounts;
        this.reviewsVMS = reviewsVMS;
    }

    public float getTotalStarStep() {
        return totalStarStep;
    }

    public void setTotalStarStep(float totalStarStep) {
        this.totalStarStep = totalStarStep;
    }

    public String getReviewsCounts() {
        return reviewsCounts;
    }

    public void setReviewsCounts(String reviewsCounts) {
        this.reviewsCounts = reviewsCounts;
    }

    public List<ReviewsVM> getReviewsVMS() {
        return reviewsVMS;
    }

    public void setReviewsVMS(List<ReviewsVM> reviewsVMS) {
        this.reviewsVMS = reviewsVMS;
    }
}
