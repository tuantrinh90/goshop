package com.goshop.app.data.model.response.common;

public class PriceData {

    /**
     * RM : {"original":"200","discounted":"149","discount_title":"25% OFF"}
     */

    private RMData RM;

    public RMData getRM() {
        return RM;
    }

    public void setRM(RMData RM) {
        this.RM = RM;
    }
}
