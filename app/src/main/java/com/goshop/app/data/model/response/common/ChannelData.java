package com.goshop.app.data.model.response.common;

import java.util.List;

public class ChannelData {

    private String id;

    private String name;

    private String playback_url;

    private List<ProductsBean> products;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayback_url() {
        return playback_url;
    }

    public void setPlayback_url(String playback_url) {
        this.playback_url = playback_url;
    }

    public List<ProductsBean> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsBean> products) {
        this.products = products;
    }

    public static class ProductsBean {

        /**
         * image : https://image.goshop.com
         * .my/resources/ms/image/contents/prd/22/32/20052232_01_400.jpg
         * labels : ["New","Best Selling"]
         * link : /prd/20052232
         * name : Manjung Korean Crispy Seaweed 2
         * price : {"RM":{"discount_title":"25% OFF","discounted":149,"original":"200"}}
         * sku : 20052232
         */

        private String image;

        private String link;

        private String name;

        private PriceBean price;

        private String sku;

        private List<String> labels;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public PriceBean getPrice() {
            return price;
        }

        public void setPrice(PriceBean price) {
            this.price = price;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public List<String> getLabels() {
            return labels;
        }

        public void setLabels(List<String> labels) {
            this.labels = labels;
        }

        public static class PriceBean {

            /**
             * RM : {"discount_title":"25% OFF","discounted":149,"original":"200"}
             */

            private RMBean RM;

            public RMBean getRM() {
                return RM;
            }

            public void setRM(RMBean RM) {
                this.RM = RM;
            }

            public static class RMBean {

                /**
                 * discount_title : 25% OFF
                 * discounted : 149
                 * original : 200
                 */

                private String discount_title;

                private int discounted;

                private String original;

                public String getDiscount_title() {
                    return discount_title;
                }

                public void setDiscount_title(String discount_title) {
                    this.discount_title = discount_title;
                }

                public int getDiscounted() {
                    return discounted;
                }

                public void setDiscounted(int discounted) {
                    this.discounted = discounted;
                }

                public String getOriginal() {
                    return original;
                }

                public void setOriginal(String original) {
                    this.original = original;
                }
            }
        }
    }
}
