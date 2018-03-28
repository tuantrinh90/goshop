package com.goshop.app.presentation.model;

import java.util.List;

public class GoLoyaltyDetailsVM extends GoLoyaltyModel {

    private List<GoLoyaltyDealsVM> dealsVMS;

    private String title;

    public GoLoyaltyDetailsVM(String title,
        List<GoLoyaltyDealsVM> dealsVMS) {
        super(GoLoyaltyModel.VIEW_TYPE_DETAIL);
        this.title = title;
        this.dealsVMS = dealsVMS;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<GoLoyaltyDealsVM> getDealsVMS() {
        return dealsVMS;
    }

    public void setDealsVMS(List<GoLoyaltyDealsVM> dealsVMS) {
        this.dealsVMS = dealsVMS;
    }
}
