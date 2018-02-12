package com.goshop.app.presentation.model.widget;

import java.util.List;

/**
 * Created by helen on 2018/2/12.
 */

public class ProductItemVM {

    private List<String> attributes;

    private String hash;

    /**
     * id : 119391
     * title : Manjung Korean Crispy Seaweed 4
     * image : https://image.goshop.com
     * .my/resources/ms/image/contents/prd/22/32/119391_01_400.jpg
     * link : /prd/119391
     * price : {"RM":{"original":"200","discounted":149,"discountTitle":"25% OFF"}}
     * attributes : ["New"]
     */

    private String id;

    private String image;

    private int imageDefault;

    private String link;

    private ProductPriceVM price;

    private String title;

    public ProductItemVM(int imageDefault, String image, String title, List<String> attributes,
        ProductPriceVM price) {
        this.imageDefault = imageDefault;
        this.attributes = attributes;
        this.image = image;
        this.price = price;
        this.title = title;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getImageDefault() {
        return imageDefault;
    }

    public void setImageDefault(int imageDefault) {
        this.imageDefault = imageDefault;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ProductPriceVM getPrice() {
        return price;
    }

    public void setPrice(ProductPriceVM price) {
        this.price = price;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }
}
