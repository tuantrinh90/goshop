package com.goshop.app.data.model.response.common;

import java.util.List;

public class ProductData {
    private List<String> attributes;

    private String image;

    private String link;

    private String name;

    private PriceData price;

    private String product_name;

    /**
     * sku : 1234
     * name : Primada Cooker
     * link : /prd/123
     * image : http://image.goshop.com.my/prd/1234/60.jpg
     * price : {"RM":{"original":"200","discounted":"149","discount_title":"25% OFF"}}
     * attributes : ["New","Best Selling"]
     * product_name : Shogun Fan
     */

    private String sku;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public PriceData getPrice() {
        return price;
    }

    public void setPrice(PriceData price) {
        this.price = price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

}
