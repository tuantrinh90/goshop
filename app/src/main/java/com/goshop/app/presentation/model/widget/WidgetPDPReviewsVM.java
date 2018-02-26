package com.goshop.app.presentation.model.widget;

import java.util.List;

public class WidgetPDPReviewsVM extends WidgetViewModel {

    private String reviewsCounts;

    private List<ReviewsVM> reviewsVMS;

    private float totalStarStep;

    public WidgetPDPReviewsVM( float totalStarStep, String reviewsCounts,
        List<ReviewsVM> reviewsVMS) {
        super(WidgetViewModel.VIEW_TYPE_PDP_REVIEWS);
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
