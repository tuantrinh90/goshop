package com.goshop.app.presentation.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HelpSupportSectionVM {

    @SerializedName("section_title")
    private String sectionTitle;

    private List<HelpSupportActionVM> actions;

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    public List<HelpSupportActionVM> getActions() {
        return actions;
    }

    public void setActions(List<HelpSupportActionVM> actions) {
        this.actions = actions;
    }
}
