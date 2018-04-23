package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.PDPProductData;

public class ProductDetailResponse {

    /**
     * product : {"sku":"9102820","name":"Manjung Korean Crispy Seaweed 3",
     * "images":["https://image.goshop.com
     * .my/resources/ms/image/contents/prd/22/32/9102820_01_400.jpg","https://image.goshop.com
     * .my/resources/ms/image/contents/prd/22/32/9102820_01_400.jpg","https://image.goshop.com
     * .my/resources/ms/image/contents/prd/22/32/9102820_01_400.jpg"],"video_url":["https://image
     * .goshop.com.my/resources/ms/image/contents/prd/22/32/9102820_01_400.jpg"],
     * "link":"/prd/9102820","categories":["123","456"],"cod":true,"availability":"In Stock",
     * "summary":"Meylana Jubah Amanina Set","details":"Lorem ipsum","free_gift":[{"sku":"123",
     * "name":"Free gift","image":"https://image.goshop.com
     * .my/resources/ms/image/contents/prd/22/32/9102820_01_35.jpg"}],
     * "price":{"RM":{"original":"200.00","discounted":"149.00","discount_title":"25% OFF"}},
     * "labels":["New","Best Selling"],"super_attribute":[{"id":"361","name":"Size",
     * "variant":[{"id":"1709","name":"S"},{"id":"1701","name":"L"}]},{"id":"362","name":"Color",
     * "variant":[{"id":"1709","name":"Red"},{"id":"1701","name":"Blue"}]}],
     * "additional_information":[{"attribute_label":"Brands","value_label":"Meylana Jubah
     * Amanina"}]}
     */

    private PDPProductData product;

    public PDPProductData getProduct() {
        return product;
    }

    public void setProduct(PDPProductData product) {
        this.product = product;
    }

}
