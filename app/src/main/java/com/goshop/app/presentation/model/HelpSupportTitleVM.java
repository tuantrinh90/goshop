package com.goshop.app.presentation.model;

public class HelpSupportTitleVM extends HelpSupportModel {

    private String title;

    public HelpSupportTitleVM(String title) {
        super(HelpSupportModel.HELP_TITLE);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
