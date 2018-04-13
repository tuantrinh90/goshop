package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

import com.goshop.app.data.model.response.common.PaginationData;
import com.goshop.app.data.model.response.common.ReviewsData;

import java.util.List;

public class AllReviewsResponse {

    private String image;

    private PaginationData pagination;

    private List<ReviewsData> reviews;

    @SerializedName("total_rating")
    private int totalRating;

    /**
     * total_reviews : 100
     * total_rating : 4
     * image : http://image.goshop.com.my/img/prd/123/abc.jpg
     * reviews : [{"title":"Lorem Ipsum","description":"Lorem Ipsum","name":"Abc","rating":4,
     * "date":"2018-02-30"},{"title":"Lorem Ipsum","description":"Lorem Ipsum","name":"Abc",
     * "rating":4,"date":"2018-02-30"}]
     * pagination : {"total_pages":5,"current_page":2,"limit":10,
     * "next":"http://<domain-name>/<base-path>/catalog/product/<sku>/reviews?website_id=1
     * &store_id=3&page=3&limit=10","previous":"http://<domain-name>/<base-path>/catalog/product
     * /<sku>/reviews?website_id=1&store_id=3&page=1&limit=10"}
     */

    @SerializedName("total_reviews")
    private String totalReviews;

    public String getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(String totalReviews) {
        this.totalReviews = totalReviews;
    }

    public int getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(int totalRating) {
        this.totalRating = totalRating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public PaginationData getPagination() {
        return pagination;
    }

    public void setPagination(PaginationData pagination) {
        this.pagination = pagination;
    }

    public List<ReviewsData> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewsData> reviews) {
        this.reviews = reviews;
    }

}
