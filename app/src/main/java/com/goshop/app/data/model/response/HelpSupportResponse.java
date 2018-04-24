package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HelpSupportResponse {

    @SerializedName("page_title")
    private String pageTitle;

    private List<HelpSupportSectionResponse> section;

    public List<HelpSupportSectionResponse> getSection() {
        return section;
    }

    public void setSection(List<HelpSupportSectionResponse> section) {
        this.section = section;
    }
}
