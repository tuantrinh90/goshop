package com.goshop.app.presentation.model;

public class TVCalendarVM {

    private String day;

    private String week;

    public TVCalendarVM(String day, String week) {

        this.day = day;
        this.week = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}
