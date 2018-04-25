package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

public class OrderRMData {

    private DiscountData discount;

    @SerializedName("egift_card")
    private EgiftCardData egiftCard;

    @SerializedName("goshop_points")
    private GoshopPointsData goshopPoints;

    private String shipping;

    /**
     * sub_total : 100.00
     * shipping : 15.00
     * discount : {"code":"ASTRO10","amount":"10.00"}
     * egift_card : {"code":"GIFTCARD1","amount":"10.00"}
     * goshop_points : {"applied":"100","amount":"10.00"}
     * total : 150.00
     */

    @SerializedName("sub_total")
    private String subTotal;

    private String total;

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public DiscountData getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountData discount) {
        this.discount = discount;
    }

    public EgiftCardData getEgiftCard() {
        return egiftCard;
    }

    public void setEgiftCard(EgiftCardData egiftCard) {
        this.egiftCard = egiftCard;
    }

    public GoshopPointsData getGoshopPoints() {
        return goshopPoints;
    }

    public void setGoshopPoints(GoshopPointsData goshopPoints) {
        this.goshopPoints = goshopPoints;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}
