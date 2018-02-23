package com.goshop.app.presentation.model;

public class PdpReviewsTopVM extends ProductDetailModel {

    private String reviewNum;

    private int reviewRating;

    public PdpReviewsTopVM() {
        super(ProductDetailModel.DETAIL_REVIEWS_CONTENT_TOP);
    }

    public PdpReviewsTopVM(String reviewNum, int reviewRating) {
        super(ProductDetailModel.DETAIL_REVIEWS_CONTENT_TOP);
        this.reviewNum = reviewNum;
        this.reviewRating = reviewRating;
    }

    public String getReviewNum() {
        return reviewNum;
    }

    public void setReviewNum(String reviewNum) {
        this.reviewNum = reviewNum;
    }

    public int getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(int reviewRating) {
        this.reviewRating = reviewRating;
    }
}
