package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

import com.goshop.app.data.model.response.common.EgiftCardData;

import java.util.List;

public class MyEGiftResponse {

    @SerializedName("egift_card")
    private List<EgiftCardData> egiftCard;

    public List<EgiftCardData> getEgiftCard() {
        return egiftCard;
    }

    public void setEgiftCard(List<EgiftCardData> egift_card) {
        this.egiftCard = egiftCard;
    }
}
