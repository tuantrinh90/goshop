package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.OrdersData;
import com.goshop.app.data.model.response.common.PaginationData;

import java.util.List;

public class MyOrderListResponse {

    private List<OrdersData> orders;

    /**
     * orders : [{"id":"3456","number":"123","status":"Shipped","amount":"220.00",
     * "product":[{"sku":"345","qty":5,"name":"iPhone7","attributes":[{"name":"Color",
     * "value":"red"},{"name":"Size","value":"XL"}],"price":{"RM":{"original":"200",
     * "discounted":"149","discount_title":"25% OFF"}},"image":"http://image.goshop.com
     * .my/product1.jpg"},{"sku":"345","qty":5,"name":"iPhone7","attributes":[{"name":"Color",
     * "value":"red"},{"name":"Size","value":"XL"}],"price":{"RM":{"original":"200",
     * "discounted":"149","discount_title":"25% OFF"}},"image":"http://image.goshop.com
     * .my/product1.jpg"}]},{"id":"34567","number":"345","status":"Shipped","amount":"220.00",
     * "product":[{"sku":"345","qty":5,"name":"iPhone7","attributes":[{"name":"Color",
     * "value":"red"},{"name":"Size","value":"XL"}],"price":{"RM":{"original":"200",
     * "discounted":"149","discount_title":"25% OFF"}},"image":"http://image.goshop.com
     * .my/product1.jpg"},{"sku":"345","qty":5,"name":"iPhone7","attributes":[{"name":"Color",
     * "value":"red"},{"name":"Size","value":"XL"}],"price":{"RM":{"original":"200",
     * "discounted":"149","discount_title":"25% OFF"}},"image":"http://image.goshop.com
     * .my/product1.jpg"}]}]
     * pagination : {"total_pages":5,"current_page":2,"limit":10,
     * "next":"http://<domain-name>/<base-path>/customer/<customer_id>/order?website_id=1
     * &store_id=3&page=1&limit=10",
     * "previous":"http://<domain-name>/<base-path>/customer/<customer_id>/order?website_id=1
     * &store_id=3&page=1&limit=10"}
     */

    private PaginationData pagination;

    public PaginationData getPagination() {
        return pagination;
    }

    public void setPagination(PaginationData pagination) {
        this.pagination = pagination;
    }

    public List<OrdersData> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersData> orders) {
        this.orders = orders;
    }

}
