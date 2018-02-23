package com.goshop.app.presentation.model.widget;

public class AdditionalInformationVM extends WidgetViewModel {

    private String lable;

    private String unit;

    public AdditionalInformationVM(String lable, String unit) {
        super(WidgetViewModel.VIEW_TYPE_ADDITIONAL_INFORMATION);
        this.lable = lable;
        this.unit = unit;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
