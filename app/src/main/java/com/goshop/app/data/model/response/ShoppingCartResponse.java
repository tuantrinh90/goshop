package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.CartData;

public class ShoppingCartResponse {

    /**
     * cart : {"quote_id":"3456","products":[{"sku":"345","qty":5,"name":"iPhone7",
     * "in_stock":true,"link":"http://api.goshop.com.my/catalog/product/345",
     * "super_attributes":[{"name":"Color","value":"Red"},{"name":"Size","value":"XL"}],
     * "price":{"RM":{"original":"200","discounted":"149","discount_title":"25%OFF"}},
     * "image":"http://image.goshop.com.my/product1.jpg"}],"billing":{"RM":{"sub_total":"100.00",
     * "discount":"20.00","shipping":"15.00","total":"95.00"}}}
     */

    private CartData cart;

    public CartData getCart() {
        return cart;
    }

    public void setCart(CartData cart) {
        this.cart = cart;
    }
}
