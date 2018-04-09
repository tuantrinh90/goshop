package com.goshop.app.data.model.response;

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

        private List<EgiftCardData> egift_card;

        public List<EgiftCardData> getEgift_card() {
            return egift_card;
        }

        public void setEgift_card(List<EgiftCardData> egift_card) {
            this.egift_card = egift_card;
        }

    }
}
