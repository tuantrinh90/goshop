package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

public class AdditionalInformationData {

    /**
     * attribute_label : Brands
     * value_label : Meylana Jubah Amanina
     */

    @SerializedName("attribute_label")
    private String attributeLabel;

    @SerializedName("value_label")
    private String valueLabel;

    public String getAttributeLabel() {
        return attributeLabel;
    }

    public void setAttributeLabel(String attributeLabel) {
        this.attributeLabel = attributeLabel;
    }

    public String getValueLabel() {
        return valueLabel;
    }

    public void setValueLabel(String valueLabel) {
        this.valueLabel = valueLabel;
    }
}
