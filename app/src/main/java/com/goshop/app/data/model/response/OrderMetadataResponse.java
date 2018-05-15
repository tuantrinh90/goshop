package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

import com.goshop.app.data.model.response.common.CancelData;
import com.goshop.app.data.model.response.common.ReturnData;

public class OrderMetadataResponse {

    /**
     * cancel : {"reason":[{"id":"Product is taking too long to be delivered.","value":"Product
     * is taking too long to be delivered."},{"id":"Want to buy something else.","value":"Want to
     * buy something else."},{"id":"Cash not available for COD.","value":"Cash not available for
     * COD."}],"product_handling":[{"id":"Order Cancellation.","value":"Order Cancellation."}]}
     * return : {"resolution":[{"id":"Refund","value":"Refund"},{"id":"Replace",
     * "value":"Replace"}],"condition":[{"id":"Damaged","value":"Damaged"},{"id":"Open",
     * "value":"Open"}],"reason":[{"id":"Not as expected","value":"Not as expected"},
     * {"id":"Broken","value":"Broken"}]}
     */

    private CancelData cancel;

    @SerializedName("return")
    private ReturnData returnX;

    public CancelData getCancel() {
        return cancel;
    }

    public void setCancel(CancelData cancel) {
        this.cancel = cancel;
    }

    public ReturnData getReturnX() {
        return returnX;
    }

    public void setReturnX(ReturnData returnX) {
        this.returnX = returnX;
    }

}
