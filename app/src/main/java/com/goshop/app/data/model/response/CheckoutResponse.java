package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

import com.goshop.app.data.model.response.common.AddressData;
import com.goshop.app.data.model.response.common.BillingData;
import com.goshop.app.data.model.response.common.EmiOptionsData;
import com.goshop.app.data.model.response.common.PaymentMethodData;
import com.goshop.app.data.model.response.common.ProductData;

import java.util.List;

public class CheckoutResponse {

    private List<AddressData> address;

    private BillingData billing;

    @SerializedName("emi_options")
    private List<EmiOptionsData> emiOptions;

    @SerializedName("goshop_points")
    private String goshopPoints;

    @SerializedName("payment_method")
    private List<PaymentMethodData> paymentMethod;

    private List<ProductData> products;

    /**
     * quote_id : 4
     * address : [{"id":"13","firstname":"Pankaj","lastname":"Kavani","street":["22nd street",
     * "Brickfields"],"country_id":"MY","country":"Malaysia","region_id":512,"region":"Johor
     * Darul Tazim","city":"Nusajaya","postcode":"79100","telephone":"9999999999",
     * "default_shipping":true,"default_billing":false},{"id":"14","firstname":"Pankaj",
     * "lastname":"Kavani","street":["23rd Street","4th lane"],"country_id":"MY",
     * "country":"Malaysia","region_id":515,"region":"Melaka","city":"Kaula Lampur",
     * "postcode":"79000","telephone":"9999999999","default_shipping":false,"default_billing":true}]
     * products : [{"quote_item_id":3456,"sku":"Test Configurable-5-kissen","qty":1,"name":"Test
     * Configurable","link":"http://localhost/goshopbit222/rest/all/V1/rest-api/catalog/product
     * /Test Configurable-5-kissen?store_id=1&website_id=1",
     * "image":"http://localhost/goshopbit222/pub/media/catalog/product/placeholder/default
     * /placeholder.jpg","in_stock":true,"price":{"RM":{"discounted":"","original":"100.00",
     * "discount_title":""}},"super_attributes":[{"id":"123","name":"Color","variant_name":"Red",
     * "variant_id":"234"},{"id":"123","name":"Size","variant_name":"XL","variant_id":"234"}]}]
     * goshop_points : 820.00
     * payment_method : [{"code":"apgbanktrasfer","title":"Bank Transfer"},{"code":"apgastropay",
     * "title":"Credit/Debit Card"},{"code":"banktransfer","title":"Bank Transfer Payment"},
     * {"code":"eppapgpay","title":"EPP Installment Plan"}]
     * emi_options : [{"value":"6","label":"6 Months"},{"value":"9","label":"9 Months"}]
     * billing : {"RM":{"sub_total":"100.00","shipping":"10.00","discount":{"code":"",
     * "amount":"20.00"},"egift_card":{"code":"GIFTCARD1","amount":"10.00"},
     * "goshop_points":{"applied":"40.00","amount":"40.00"},"total":"50.00"}}
     */

    @SerializedName("quote_id")
    private int quoteId;

    public int getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }

    public String getGoshopPoints() {
        return goshopPoints;
    }

    public void setGoshopPoints(String goshopPoints) {
        this.goshopPoints = goshopPoints;
    }

    public BillingData getBilling() {
        return billing;
    }

    public void setBilling(BillingData billing) {
        this.billing = billing;
    }

    public List<AddressData> getAddress() {
        return address;
    }

    public void setAddress(List<AddressData> address) {
        this.address = address;
    }

    public List<ProductData> getProducts() {
        return products;
    }

    public void setProducts(List<ProductData> products) {
        this.products = products;
    }

    public List<PaymentMethodData> getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(List<PaymentMethodData> paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<EmiOptionsData> getEmiOptions() {
        return emiOptions;
    }

    public void setEmiOptions(List<EmiOptionsData> emiOptions) {
        this.emiOptions = emiOptions;
    }

}
