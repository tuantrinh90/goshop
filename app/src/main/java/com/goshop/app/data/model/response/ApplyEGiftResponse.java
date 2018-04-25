package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.EgiftCardData;
import com.goshop.app.data.model.response.common.PriceData;

public class ApplyEGiftResponse {

    /**
     * eGiftCard : {"amount":"100","applied":"100","balance":"0"}
     * price : {"original_price":"120","new_price":"20"}
     */

    private EgiftCardData eGiftCard;

    private PriceData price;

    public EgiftCardData getEGiftCard() {
        return eGiftCard;
    }

    public void setEGiftCard(EgiftCardData eGiftCard) {
        this.eGiftCard = eGiftCard;
    }

    public PriceData getPrice() {
        return price;
    }

    public void setPrice(PriceData price) {
        this.price = price;
    }
}
