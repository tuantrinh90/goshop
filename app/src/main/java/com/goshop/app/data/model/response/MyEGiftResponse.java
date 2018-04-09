package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

import com.goshop.app.data.model.response.common.EgiftCardData;

import java.util.List;

public class MyEGiftResponse extends Response {

    /**
     * data : {"egift_card":[{"code":"ABCDE","balance":"120.00","status":"Active",
     * "sentby":"User","expire":"2018-02-01"},{"code":"ABCDE","balance":"120.00",
     * "status":"Active","sentby":"User","expire":"2018-02-01"}]}
     */

    private Datas data;

    public Datas getData() {
        return data;
    }

    public void setData(Datas data) {
        this.data = data;
    }

    public static class Datas {
        @SerializedName("egift_card")
        private List<EgiftCardData> egiftCard;

        public List<EgiftCardData> getEgiftCard() {
            return egiftCard;
        }

        public void setEgiftCard(List<EgiftCardData> egift_card) {
            this.egiftCard = egiftCard;
        }

    }
}
