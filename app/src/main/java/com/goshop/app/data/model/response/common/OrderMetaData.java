package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

public class OrderMetaData {

    /**
     * cancel : {"reason":[{"id":1,"value":"Product Damage"},{"id":2,"value":"Wrong Item"}],
     * "product_resolution":[{"id":1,"value":"Order Cancel"}]}
     * return : {"reason":[{"id":1,"value":"ProductDamage"},{"id":2,"value":"Wrong Item
     * Sent"}],"product_resolution":[{"id":1,"value":"Order Return"}]}
     */

    private OrderCancelData cancel;

    @SerializedName("return")
    private OrderReturnData returnX;

    public OrderCancelData getCancel() {
        return cancel;
    }

    public void setCancel(OrderCancelData cancel) {
        this.cancel = cancel;
    }

    public OrderReturnData getReturnX() {
        return returnX;
    }

    public void setReturnX(OrderReturnData returnX) {
        this.returnX = returnX;
    }
}
