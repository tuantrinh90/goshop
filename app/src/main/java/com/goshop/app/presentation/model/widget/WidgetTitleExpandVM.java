package com.goshop.app.presentation.model.widget;

/**
 * Created by helen on 2018/2/22.
 */

public class WidgetTitleExpandVM extends WidgetViewModel {

    private boolean clickable = false;

    private boolean isExpand;

    private String title;

    public WidgetTitleExpandVM(String title, boolean isExpand, boolean clickable) {
        super(WidgetViewModel.VIEW_TYPE_EXPAND_TITLE);
        this.isExpand = isExpand;
        this.title = title;
        this.clickable = clickable;
    }

    public WidgetTitleExpandVM(String title) {
        super(WidgetViewModel.VIEW_TYPE_EXPAND_TITLE);
        this.title = title;
    }

    public boolean isClickable() {
        return clickable;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
