package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.OrderDetailData;

public class OrderDetailResponse {

    /**
     * order : {"information":{"number":"123","status":"Shipped",
     * "date_time":"2018-01-30T13:05:45Z"},"shipping_address":{"firstname":"Pankaj",
     * "lastname":"Kavani","street":{"0":"Bukit Jalil","1":"Astro"},"country":"Malaysia",
     * "region":"Kualalumpur","city":"Alor Setar","postcode":12345,"telephone":"9999999999"},
     * "payment_method":"Cash on Delivery","allow_cancel":false,"product":[{"sku":"345","qty":5,
     * "name":"iPhone7","allow_return":false,"super_attributes":[{"name":"Color","value":"red"},
     * {"name":"Size","value":"XL"}],"price":{"RM":{"original":"200","discounted":"149",
     * "discount_title":"25%OFF"}},"image":"http: //image.goshop.com.my/product1.jpg"}],
     * "billing":{"RM":{"sub_total":"100.00","discount":"20.00","shipping":"15.00",
     * "total":"95.00"}}}
     */

    private OrderDetailData order;

    public OrderDetailData getOrder() {
        return order;
    }

    public void setOrder(OrderDetailData order) {
        this.order = order;
    }


}
