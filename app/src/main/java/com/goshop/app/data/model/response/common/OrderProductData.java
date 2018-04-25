package com.goshop.app.data.model.response.common;

import java.util.List;

public class OrderProductData {

    private List<AttributeData> attributes;

    private String image;

    private String name;

    private PriceData price;

    private String qty;

    /**
     * sku : 345
     * qty : 5
     * name : iPhone7
     * attributes : [{"name":"Color","value":"red"},{"name":"Size","value":"XL"}]
     * price : {"RM":{"original":"200","discounted":"149","discount_title":"25% OFF"}}
     * image : http://image.goshop.com.my/product1.jpg
     */

    private String sku;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PriceData getPrice() {
        return price;
    }

    public void setPrice(PriceData price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<AttributeData> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeData> attributes) {
        this.attributes = attributes;
    }


}
