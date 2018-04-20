package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

import com.goshop.app.data.model.response.common.EgiftCardData;
import com.goshop.app.data.model.response.common.PaginationData;

import java.util.List;

public class MyEGiftResponse {

    @SerializedName("egift_card")
    private List<EgiftCardData> egiftCard;

    private PaginationData pagination;

    public PaginationData getPagination() {
        return pagination;
    }

    public void setPagination(PaginationData pagination) {
        this.pagination = pagination;
    }

    public List<EgiftCardData> getEgiftCard() {
        return egiftCard;
    }

    public void setEgiftCard(List<EgiftCardData> egift_card) {
        this.egiftCard = egiftCard;
    }
}
