package com.goshop.app.presentation.model;

import java.util.List;

public class PaymentMethodVM {

    private String id;

    private String name;

    private List<ProfileMetaVM> months;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProfileMetaVM> getMonths() {
        return months;
    }

    public void setMonths(List<ProfileMetaVM> months) {
        this.months = months;
    }
}
