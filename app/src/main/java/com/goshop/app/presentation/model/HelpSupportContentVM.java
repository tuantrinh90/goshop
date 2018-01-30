package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/1/29.
 */

public class HelpSupportContentVM extends HelpSupportModel {

    private String label;

    public HelpSupportContentVM(String label) {
        super(HelpSupportModel.HELP_CONTENT);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
