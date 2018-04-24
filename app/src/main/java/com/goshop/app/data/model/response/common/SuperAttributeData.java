package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SuperAttributeData {

    /**
     * id : 361
     * name : Size
     * variant : [{"id":"1709","name":"S"},{"id":"1701","name":"L"}]
     */

    private String id;

    private String name;

    private List<VariantData> variant;

    @SerializedName("variant_id")
    private String variantId;

    @SerializedName("variant_name")
    private String variantName;

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getVariantName() {
        return variantName;
    }

    public void setVariantName(String variantName) {
        this.variantName = variantName;
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

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

    public List<VariantData> getVariant() {
        return variant;
    }

    public void setVariant(List<VariantData> variant) {
        this.variant = variant;
    }

}
