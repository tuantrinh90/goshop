package com.goshop.app.data.model.response;

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

        public static class ProductData {

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

            public static class PriceData {

                /**
                 * RM : {"original":"200","discounted":"149","discount_title":"25% OFF"}
                 */

                private RMData RM;

                public RMData getRM() {
                    return RM;
                }

                public void setRM(RMData RM) {
                    this.RM = RM;
                }

                public static class RMData {

                    private String discount_title;

                    private String discounted;

                    /**
                     * original : 200
                     * discounted : 149
                     * discount_title : 25% OFF
                     */

                    private String original;

                    public String getOriginal() {
                        return original;
                    }

                    public void setOriginal(String original) {
                        this.original = original;
                    }

                    public String getDiscounted() {
                        return discounted;
                    }

                    public void setDiscounted(String discounted) {
                        this.discounted = discounted;
                    }

                    public String getDiscount_title() {
                        return discount_title;
                    }

                    public void setDiscount_title(String discount_title) {
                        this.discount_title = discount_title;
                    }
                }
            }
        }
    }
}
