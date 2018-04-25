package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

import com.goshop.app.data.model.response.common.AddressesData;
import com.goshop.app.data.model.response.common.OrderBillingData;
import com.goshop.app.data.model.response.common.PaymentMethodData;
import com.goshop.app.data.model.response.common.ProductData;

import java.util.List;

public class CheckoutResponse {

    /**
     * address : {"id":"29","firstname":"Pankaj","lastname":"Kavani","street":{"0":"Bukit Jalil",
     * "1":"Astro"},"country_id":"MY","region_id":512,"city":"Alor Setar","postcode":12345,
     * "telephone":"9999999999","default_billing":true,"default_shipping":true}
     * payment_method : [{"id":"123","name":"Online Banking"},{"id":"345","name":"Cash On
     * Delivery"},{"id":"567","name":"EPP","months":[3,6,9]}]
     * products : [{"quote_item_id":"3456","sku":"345","qty":5,"name":"iPhone7","in_stock":true,
     * "link":"http://api.goshop.com.my/catalog/product/345","super_attributes":[{"id":"123",
     * "name":"Color","variant_name":"Red","variant_id":"234"},{"id":"123","name":"Size",
     * "variant_name":"XL","variant_id":"234"}],"price":{"RM":{"original":"200",
     * "discounted":"149","discount_title":"25%OFF"}},"image":"http://image.goshop.com
     * .my/product1.jpg"}]
     * billing : {"RM":{"sub_total":"100.00","shipping":"15.00","discount":{"code":"ASTRO10",
     * "amount":"10.00"},"egift_card":{"code":"GIFTCARD1","amount":"10.00"},
     * "goshop_points":{"applied":"100","amount":"10.00"},"total":"150.00"}}
     */

    private AddressesData address;

    private OrderBillingData billing;
    @SerializedName("payment_method")
    private List<PaymentMethodData> paymentMethod;

    private List<ProductData> products;

    public AddressesData getAddress() {
        return address;
    }

    public void setAddress(AddressesData address) {
        this.address = address;
    }

    public OrderBillingData getBilling() {
        return billing;
    }

    public void setBilling(OrderBillingData billing) {
        this.billing = billing;
    }

    public List<PaymentMethodData> getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(List<PaymentMethodData> paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<ProductData> getProducts() {
        return products;
    }

    public void setProducts(List<ProductData> products) {
        this.products = products;
    }

}
