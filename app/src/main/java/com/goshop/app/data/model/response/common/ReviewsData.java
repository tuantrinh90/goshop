package com.goshop.app.data.model.response.common;

public class ReviewsData {

    private String date;

    private String description;

    private String name;

    private int rating;

    /**
     * title : Lorem Ipsum
     * description : Lorem Ipsum
     * name : Abc
     * rating : 4
     * date : 2018-02-30
     */

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
