package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrdersData {

    private String amount;

    /**
     * id : 3456
     * number : 123
     * status : Shipped
     * amount : 220.00
     * product : [{"sku":"345","qty":5,"name":"iPhone7","attributes":[{"name":"Color",
     * "value":"red"},{"name":"Size","value":"XL"}],"price":{"RM":{"original":"200",
     * "discounted":"149","discount_title":"25% OFF"}},"image":"http://image.goshop.com
     * .my/product1.jpg"},{"sku":"345","qty":5,"name":"iPhone7",
     * "attributes":[{"name":"Color","value":"red"},{"name":"Size","value":"XL"}],
     * "price":{"RM":{"original":"200","discounted":"149","discount_title":"25% OFF"}},
     * "image":"http://image.goshop.com.my/product1.jpg"}]
     */

    private String id;

    private String number;

    private String code;

    @SerializedName("payment_url")
    private String paymentUrl;

    private String state;

    private List<OrderProductData> product;

    private String status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public List<OrderProductData> getProduct() {
        return product;
    }

    public void setProduct(List<OrderProductData> product) {
        this.product = product;
    }
}
