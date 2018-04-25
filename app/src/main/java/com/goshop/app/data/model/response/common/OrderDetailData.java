package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderDetailData {

    @SerializedName("allow_cancel")
    private boolean allowCancel;

    private OrderBillingData billing;

    /**
     * information : {"number":"123","status":"Shipped","date_time":"2018-01-30T13:05:45Z"}
     * shipping_address : {"firstname":"Pankaj","lastname":"Kavani","street":{"0":"Bukit
     * Jalil","1":"Astro"},"country":"Malaysia","region":"Kualalumpur","city":"Alor Setar",
     * "postcode":12345,"telephone":"9999999999"}
     * payment_method : Cash on Delivery
     * allow_cancel : false
     * product : [{"sku":"345","qty":5,"name":"iPhone7","allow_return":false,
     * "super_attributes":[{"name":"Color","value":"red"},{"name":"Size","value":"XL"}],
     * "price":{"RM":{"original":"200","discounted":"149","discount_title":"25%OFF"}},
     * "image":"http: //image.goshop.com.my/product1.jpg"}]
     * billing : {"RM":{"sub_total":"100.00","discount":"20.00","shipping":"15.00",
     * "total":"95.00"}}
     */

    private InformationData information;

    @SerializedName("payment_method")
    private String paymentMethod;

    private List<ProductData> product;

    @SerializedName("shipping_address")
    private ShippingAddressData shippingAddress;

    public InformationData getInformation() {
        return information;
    }

    public void setInformation(InformationData information) {
        this.information = information;
    }

    public ShippingAddressData getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddressData shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isAllowCancel() {
        return allowCancel;
    }

    public void setAllowCancel(boolean allowCancel) {
        this.allowCancel = allowCancel;
    }

    public OrderBillingData getBilling() {
        return billing;
    }

    public void setBilling(OrderBillingData billing) {
        this.billing = billing;
    }

    public List<ProductData> getProduct() {
        return product;
    }

    public void setProduct(List<ProductData> product) {
        this.product = product;
    }
}
