package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.DiscountData;

public class ApplyCouponResponse {

    /**
     * discount : {"type":"flat","discount":"10","original_price":"120","discounted_price":"110"}
     */

    private DiscountData discount;

    public DiscountData getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountData discount) {
        this.discount = discount;
    }
}
