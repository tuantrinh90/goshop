package com.goshop.app.presentation.model;

public class PdpReviewsContentVM extends ProductDetailModel {

    private int ratingNum;

    private String review;

    private String reviewInfo;

    private String reviewerDetail;

    public PdpReviewsContentVM(int ratingNum, String review, String reviewInfo,
        String reviewerDetail) {
        super(ProductDetailModel.DETAIL_REVIEWS_CONTENT);
        this.ratingNum = ratingNum;
        this.review = review;
        this.reviewInfo = reviewInfo;
        this.reviewerDetail = reviewerDetail;
    }

    public PdpReviewsContentVM() {
        super(ProductDetailModel.DETAIL_REVIEWS_CONTENT);
    }

    public int getRatingNum() {
        return ratingNum;
    }

    public void setRatingNum(int ratingNum) {
        this.ratingNum = ratingNum;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getReviewInfo() {
        return reviewInfo;
    }

    public void setReviewInfo(String reviewInfo) {
        this.reviewInfo = reviewInfo;
    }

    public String getReviewerDetail() {
        return reviewerDetail;
    }

    public void setReviewerDetail(String reviewerDetail) {
        this.reviewerDetail = reviewerDetail;
    }
}
