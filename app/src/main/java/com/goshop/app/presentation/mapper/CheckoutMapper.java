package com.goshop.app.presentation.mapper;

import com.goshop.app.R;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.data.model.response.common.OrderRMData;
import com.goshop.app.data.model.response.common.PaymentMethodData;
import com.goshop.app.data.model.response.common.ProductData;
import com.goshop.app.data.model.response.common.RMData;
import com.goshop.app.presentation.model.CheckoutVM;
import com.goshop.app.presentation.model.PaymentMethodVM;
import com.goshop.app.presentation.model.common.ProductVM;
import com.goshop.app.presentation.model.widget.ProductCartListVM;
import com.goshop.app.presentation.model.widget.ProductListModel;
import com.goshop.app.presentation.model.widget.ProductPriceRMVM;
import com.goshop.app.presentation.model.widget.ProductPriceVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.utils.NumberFormater;
import com.goshop.app.utils.TextFormater;

import java.util.ArrayList;
import java.util.List;

public class CheckoutMapper {

    public static CheckoutVM transform(CheckoutResponse response) {
        CheckoutVM checkoutVM = new CheckoutVM();
        //todo these hard code is wait for api
        checkoutVM.setShippingUserName("User Name");
        checkoutVM.setShippingAddressOne("Address 1");
        checkoutVM.setShippingAddressTwo("Address 2");
        checkoutVM.setShippingCityStatePost(TextFormater.formatCityStateCode("City", "State", "1000"));
        checkoutVM.setShippingCountry("China");
        checkoutVM.setShippingTel(NumberFormater.formaterTelNo("1234155434232"));
        checkoutVM.setBillingUserName("User Name");
        checkoutVM.setBillingAddressOne("Address 1");
        checkoutVM.setBillingAddressTwo("Address 2");
        checkoutVM.setBillingCityStatePost(TextFormater.formatCityStateCode("City", "State", "1000"));
        checkoutVM.setBillingCountry("China");
        checkoutVM.setBillingTel(NumberFormater.formaterTelNo("1234155434232"));
        PaymentMethodVM paymentMethodVM;
        List<PaymentMethodVM> methodVMS = new ArrayList<>();
        List<PaymentMethodData> paymentMethodDatas =  response.getPaymentMethod();
        for(PaymentMethodData data: paymentMethodDatas) {
            paymentMethodVM = new PaymentMethodVM();
            paymentMethodVM.setId(data.getId());
            paymentMethodVM.setName(data.getName());
            if(data.getMonths() != null && data.getMonths().size() > 0) {
                paymentMethodVM.setMonths(data.getMonths());
            }
            methodVMS.add(paymentMethodVM);
        }
        checkoutVM.setPaymentMethodVMs(methodVMS);

        List<ProductData> productDatas = response.getProducts();
        List<ProductVM> productVMS = new ArrayList<>();
        for (ProductData data : productDatas) {
            ProductVM productVM = new ProductVM();
            productVM.setTitle(data.getName());
            productVM.setId(data.getSku());
            productVM.setAmount(NumberFormater.formaterOrderQty(data.getQty()));
            productVM.setImage(data.getImage());
            productVM.setImageDefault(R.drawable.ic_bought);

            RMData rmData = data.getPrice().getRM();
            productVM.setOldPrice(NumberFormater.formaterPrice(rmData.getOriginal()));
            productVM.setNowPrice(NumberFormater.formaterPrice(rmData.getDiscounted()));
            productVM.setPercent(rmData.getDiscountTitle());
            productVM.setAttrs(data.getAttributes());
            productVMS.add(productVM);
        }

        checkoutVM.setProductVMS(productVMS);
        OrderRMData orderRMData = response.getBilling().getRm();
        checkoutVM.setSubTotal(NumberFormater.formaterPrice(orderRMData.getSubTotal()));
        checkoutVM.setShipping(NumberFormater.formaterPrice(orderRMData.getShipping()));
        checkoutVM.setDiscountCode(TextFormater.formatBillingCode(orderRMData.getDiscount().getCode()));
        checkoutVM.setDiscountAmount(NumberFormater.formaterDiscountPrice(orderRMData.getDiscount().getAmount()));
        checkoutVM.seteGiftCode(TextFormater.formatBillingCode(orderRMData.getEgiftCard().getCode()));
        checkoutVM.seteGiftAmount(NumberFormater.formaterDiscountPrice(orderRMData.getEgiftCard().getAmount()));
        checkoutVM.setBillingTotal(NumberFormater.formaterPrice(orderRMData.getTotal()));

        return checkoutVM;
    }

}
