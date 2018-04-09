package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.ProductData;

import java.util.List;

public class MyWishlistResponse extends Response {

    /**
     * data : {"product":[{"sku":"1234","name":"Primada Cooker","link":"/prd/123",
     * "image":"http://image.goshop.com.my/prd/1234/60.jpg","price":{"RM":{"original":"200",
     * "discounted":"149","discount_title":"25% OFF"}},"attributes":["New","Best Selling"],
     * "product_name":"Shogun Fan"},{"sku":"4567","product_name":"Shogun Fan","link":"/prd/123",
     * "image":"http://image.goshop.com.my/prd/1234/60.jpg","price":{"RM":{"original":"200",
     * "discounted":"149","discount_title":"25% OFF"}},"attributes":["New","Best Selling"]}]}
     */

    private Datas data;

    public Datas getData() {
        return data;
    }

    public void setData(Datas data) {
        this.data = data;
    }

    public static class Datas {

        private List<ProductData> product;

        public List<ProductData> getProduct() {
            return product;
        }

        public void setProduct(List<ProductData> product) {
            this.product = product;
        }


    }
}
