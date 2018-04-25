package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HelpSupportSectionResponse {

    @SerializedName("section_title")
    private String sectionTitle;

    private List<HelpSupportActionResponse> actions;

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    public List<HelpSupportActionResponse> getActions() {
        return actions;
    }

    public void setActions(List<HelpSupportActionResponse> actions) {
        this.actions = actions;
    }
}
