package com.goshop.app.presentation.mapper;

import com.goshop.app.R;
import com.goshop.app.data.model.response.OrderDetailResponse;
import com.goshop.app.data.model.response.common.InformationData;
import com.goshop.app.data.model.response.common.OrderBillingData;
import com.goshop.app.data.model.response.common.OrderDetailData;
import com.goshop.app.data.model.response.common.OrderRMData;
import com.goshop.app.data.model.response.common.ProductData;
import com.goshop.app.data.model.response.common.RMData;
import com.goshop.app.data.model.response.common.ShippingAddressData;
import com.goshop.app.data.model.response.common.SuperAttributeData;
import com.goshop.app.presentation.model.BillingVM;
import com.goshop.app.presentation.model.MyOrdersProductVM;
import com.goshop.app.presentation.model.OrderDetailVM;
import com.goshop.app.utils.DateFormater;
import com.goshop.app.utils.NumberFormater;
import com.goshop.app.utils.TextFormater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDetailMapper {

    public static OrderDetailVM transform(OrderDetailResponse response) {
        OrderDetailData orderDetailData = response.getOrder();
        InformationData informationData = orderDetailData.getInformation();
        ShippingAddressData shippingAddressData = orderDetailData.getShippingAddress();
        String paymentMethod = orderDetailData.getPaymentMethod();
        List<ProductData> productDatas = orderDetailData.getProduct();
        OrderBillingData billingData = response.getOrder().getBilling();

        List<MyOrdersProductVM> myOrdersProductVMS = new ArrayList<>();
        for (ProductData productData : productDatas) {
            String sku = NumberFormater.formaterOrderNumber(productData.getSku());
            String thumb = productData.getImage();
            String title = productData.getName();
            List<SuperAttributeData> superAttributeDatas = productData.getSuperAttributes();
            Map<String, String> attributeMap = new HashMap<>();
            for (SuperAttributeData attributeData : superAttributeDatas) {
                attributeMap.put(attributeData.getName(), attributeData.getValue());
            }
            String qty = NumberFormater.formaterOrderQty(productData.getQty());
            RMData rmData = productData.getPrice().getRM();
            String oldPrice = rmData.getOriginal();
            String nowPrice = rmData.getDiscounted();
            String percent = rmData.getDiscountTitle();
            MyOrdersProductVM productVM = new MyOrdersProductVM(sku, "", thumb,
                R.drawable.ic_image_404_small, title, attributeMap, oldPrice, nowPrice,
                qty, percent);
            myOrdersProductVMS.add(productVM);
        }

        Map<String, Object> street = shippingAddressData.getStreet();
        String shipAddress = "";
        for (Map.Entry<String, Object> entry : street.entrySet()) {
            shipAddress = shipAddress + entry.getValue();
        }
        String shipCity = shippingAddressData.getCity() + ",\t" + shippingAddressData.getPostcode();
        String placeAt = DateFormater.formaterISODate(informationData.getDateTime());
        OrderDetailVM orderDetailVM = new OrderDetailVM(informationData.getNumber(),
            informationData.getStatus(), placeAt, shippingAddressData.getFirstName(),
            shipAddress, shipCity, shippingAddressData.getCountry(),
            NumberFormater.formaterTelNo(shippingAddressData.getTelephone()), paymentMethod,
            myOrdersProductVMS);

        OrderRMData rm = billingData.getRm();
        BillingVM billingVM = new BillingVM();
        billingVM.setBillingSubTotal(NumberFormater.formaterPrice(rm.getSubTotal()));
        billingVM.setBillingShipping(NumberFormater.formaterPrice(rm.getShipping()));
        billingVM.setBillingDiscountAmount(rm.getDiscount().getAmount());
        billingVM.setBillingTotal(NumberFormater.formaterPrice(rm.getTotal()));
        billingVM.setBillingEGiftAmount(rm.getEgiftCard().getAmount());
        billingVM.setBillingPointsAmount(rm.getGoshopPoints().getAmount());
        billingVM
            .setBillingDiscountCode(TextFormater.formatBillingCode(rm.getDiscount().getCode()));
        billingVM.setBillingEGiftCode(TextFormater.formatBillingCode(rm.getEgiftCard().getCode()));
        billingVM.setBillingPointsApplied(
            TextFormater.formatBillingCode(rm.getGoshopPoints().getApplied()));
        orderDetailVM.setBillingVM(billingVM);
        return orderDetailVM;
    }

}
