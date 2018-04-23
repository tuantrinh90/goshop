package com.goshop.app.data.model.request.common;

import com.google.gson.annotations.SerializedName;

public class SuperAttributesData {

    /**
     * id : 123
     * variant_id : 7451
     */

    private String id;

    @SerializedName("variant_id")
    private String variantId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }
}
