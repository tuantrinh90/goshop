package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

public class RMData {

    @SerializedName("discount_title")
    private String discountTitle;

    @SerializedName("egift_card")
    EgiftCardData eGiftCard;

    @SerializedName("goshop_points")
    GoshopPointsData goshopPoints;

    private String discounted;

    /**
     * original : 200
     * discounted : 149
     * discount_title : 25% OFF
     */

    private String original;

    private DiscountData discount;

    private String shipping;

    /**
     * sub_total : 100.00
     * discount : 20.00
     * shipping : 15.00
     * total : 95.00
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

    public DiscountData getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountData discount) {
        this.discount = discount;
    }

    public EgiftCardData geteGiftCard() {
        return eGiftCard;
    }

    public void seteGiftCard(EgiftCardData eGiftCard) {
        this.eGiftCard = eGiftCard;
    }

    public GoshopPointsData getGoshopPoints() {
        return goshopPoints;
    }

    public void setGoshopPoints(GoshopPointsData goshopPoints) {
        this.goshopPoints = goshopPoints;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getDiscounted() {
        return discounted;
    }

    public void setDiscounted(String discounted) {
        this.discounted = discounted;
    }

    public String getDiscountTitle() {
        return discountTitle;
    }

    public void setDiscountTitle(String discountTitle) {
        this.discountTitle = discountTitle;
    }
}