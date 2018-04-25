package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.data.model.response.common.OrderRMData;
import com.goshop.app.data.model.response.common.PaymentMethodData;
import com.goshop.app.data.model.response.common.ProductData;
import com.goshop.app.data.model.response.common.RMData;
import com.goshop.app.presentation.model.CheckoutVM;
import com.goshop.app.presentation.model.PaymentMethodVM;
import com.goshop.app.presentation.model.widget.ProductCartListVM;
import com.goshop.app.presentation.model.widget.ProductListModel;
import com.goshop.app.presentation.model.widget.ProductPriceRMVM;
import com.goshop.app.presentation.model.widget.ProductPriceVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.utils.NumberFormater;

import java.util.ArrayList;
import java.util.List;

public class CheckoutMapper {

    public static CheckoutVM transform(CheckoutResponse response) {
        CheckoutVM checkoutVM = new CheckoutVM();
        checkoutVM.setShippingUserName("");
        checkoutVM.setShippingAddressOne("");
        checkoutVM.setShippingAddressTwo("");
        checkoutVM.setShippingCityStatePost("");
        checkoutVM.setShippingCountry("");
        checkoutVM.setShippingTel("");
        checkoutVM.setBillingUserName("");
        checkoutVM.setBillingAddressOne("");
        checkoutVM.setBillingAddressTwo("");
        checkoutVM.setBillingCityStatePost("");
        checkoutVM.setBillingCountry("");
        checkoutVM.setBillingTel("");
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
        List<ProductListModel> listModels = new ArrayList<>();
        for (ProductData data : productDatas) {
            ProductsVM productsVM = new ProductsVM();
            productsVM.setTitle(data.getName());
            productsVM.setId(data.getSku());
            productsVM.setAmount(data.getQty());
            productsVM.setImage(data.getImage());
            RMData rmData = data.getPrice().getRM();
            ProductPriceRMVM rmvm = new ProductPriceRMVM(rmData.getDiscountTitle(),
                rmData.getDiscounted(), rmData.getOriginal());
            ProductPriceVM priceVM = new ProductPriceVM(rmvm);
            productsVM.setPriceVM(priceVM);
            productsVM.setAttributes(data.getAttributes());
            listModels.add(new ProductCartListVM(productsVM));
        }


        checkoutVM.setProductListModels(listModels);
        OrderRMData orderRMData = response.getBilling().getRm();
        checkoutVM.setSubTotal(NumberFormater.formaterPrice(orderRMData.getSubTotal()));
        checkoutVM.setShipping(NumberFormater.formaterPrice(orderRMData.getShipping()));
        checkoutVM.setDiscountCode();
        checkoutVM.setDiscountAmount();
        checkoutVM.seteGiftCode();
        checkoutVM.seteGiftAmount(NumberFormater.formaterPrice(orderRMData.getEgiftCard().getAmount()));
        checkoutVM.setBillingTotal(NumberFormater.formaterPrice(orderRMData.getTotal()));

        return checkoutVM;
    }

}
