package com.goshop.app.presentation.model;

public class HelpSupportContentVM extends HelpSupportModel {

    private HelpContentClickListener helpContentClickListener;

    private String label;

    public HelpSupportContentVM(String label, HelpContentClickListener helpContentClickListener) {
        super(HelpSupportModel.HELP_CONTENT);
        this.label = label;
        this.helpContentClickListener = helpContentClickListener;
    }

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

    public HelpContentClickListener getHelpContentClickListener() {
        return helpContentClickListener;
    }

    public void setHelpContentClickListener(
        HelpContentClickListener helpContentClickListener) {
        this.helpContentClickListener = helpContentClickListener;
    }

    public interface HelpContentClickListener {

        void onContentClick();
    }
}
