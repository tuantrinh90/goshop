package com.goshop.app.presentation.mapper;

import com.goshop.app.R;
import com.goshop.app.data.model.response.MyOrderListResponse;
import com.goshop.app.data.model.response.common.AttributeData;
import com.goshop.app.data.model.response.common.OrderProductData;
import com.goshop.app.data.model.response.common.OrdersData;
import com.goshop.app.presentation.model.MyOrdersProductVM;
import com.goshop.app.presentation.model.MyOrdersVM;
import com.goshop.app.utils.NumberFormater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOrderMapper {

    public static List<MyOrdersVM> transform(MyOrderListResponse response) {
        List<MyOrdersVM> myOrdersVMS = new ArrayList<>();

        List<OrdersData> orders = response.getOrders();
        for (OrdersData ordersData : orders) {
            String orderNumber = NumberFormater.formaterOrderNumber(ordersData.getNumber());
            String orderStatus = ordersData.getStatus();
            String amount = NumberFormater.formaterPrice(ordersData.getAmount());
            List<OrderProductData> productDatas = ordersData.getProduct();
            List<MyOrdersProductVM> myOrdersProductVMS = new ArrayList<>();
            for (OrderProductData data : productDatas) {
                List<AttributeData> attributeDatas = data.getAttributes();
                Map<String, String> attributeMap = new HashMap<>();
                for (AttributeData attributeData : attributeDatas) {
                    attributeMap.put(attributeData.getName(), attributeData.getValue());
                }
                String olderPrice = NumberFormater
                    .formaterPrice(data.getPrice().getRM().getOriginal());
                String nowPrice = NumberFormater
                    .formaterPrice(data.getPrice().getRM().getDiscounted());
                String qty = NumberFormater.formaterOrderQty(data.getQty());
                MyOrdersProductVM productVM = new MyOrdersProductVM(orderNumber, "",
                    data.getImage(),
                    R.drawable.ic_bought, data.getName(), attributeMap, olderPrice, nowPrice,
                    qty, data.getPrice().getRM().getDiscountTitle());
                myOrdersProductVMS.add(productVM);
            }
            myOrdersVMS.add(new MyOrdersVM(orderNumber, orderStatus, myOrdersProductVMS, amount));
        }
        return myOrdersVMS;
    }

}
