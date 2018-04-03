package com.goshop.app.data.model.response;

import java.util.List;

public class MyWishlistResponse extends Response {

    /**
     * data : {"wishlist":[{"sku":1234,"product_name":"Primada Cooker","original_price":"200.00",
     * "discounted_price":"100.00"},{"sku":4567,"product_name":"Shogun Fan",
     * "original_price":"200.00","discounted_price":"100.00"}]}
     */

    private Datas data;

    public Datas getData() {
        return data;
    }

    public void setData(Datas data) {
        this.data = data;
    }

    public static class Datas {

        private List<WishlistData> wishlist;

        public List<WishlistData> getWishlist() {
            return wishlist;
        }

        public void setWishlist(List<WishlistData> wishlist) {
            this.wishlist = wishlist;
        }

        public static class WishlistData {

            private String discounted_price;

            private String original_price;

            private String product_name;

            /**
             * sku : 1234
             * product_name : Primada Cooker
             * original_price : 200.00
             * discounted_price : 100.00
             */

            private int sku;

            public int getSku() {
                return sku;
            }

            public void setSku(int sku) {
                this.sku = sku;
            }

            public String getProduct_name() {
                return product_name;
            }

            public void setProduct_name(String product_name) {
                this.product_name = product_name;
            }

            public String getOriginal_price() {
                return original_price;
            }

            public void setOriginal_price(String original_price) {
                this.original_price = original_price;
            }

            public String getDiscounted_price() {
                return discounted_price;
            }

            public void setDiscounted_price(String discounted_price) {
                this.discounted_price = discounted_price;
            }
        }
    }
}
