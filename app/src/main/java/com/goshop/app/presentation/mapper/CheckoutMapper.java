package com.goshop.app.presentation.mapper;

import com.goshop.app.R;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.data.model.response.common.AddressesData;
import com.goshop.app.data.model.response.common.OrderRMData;
import com.goshop.app.data.model.response.common.PaymentMethodData;
import com.goshop.app.data.model.response.common.ProductData;
import com.goshop.app.data.model.response.common.RMData;
import com.goshop.app.data.model.response.common.SuperAttributeData;
import com.goshop.app.presentation.model.CheckoutVM;
import com.goshop.app.presentation.model.PaymentMethodVM;
import com.goshop.app.presentation.model.ProfileMetaVM;
import com.goshop.app.presentation.model.common.ProductVM;
import com.goshop.app.utils.NumberFormater;
import com.goshop.app.utils.TextFormater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckoutMapper {

    private static final String COMMA = ", ";

    private static final String END = "; ";

    public static CheckoutVM transform(CheckoutResponse response) {
        CheckoutVM checkoutVM = new CheckoutVM();

        AddressesData addressesData = response.getAddress();
        checkoutVM.setShippingUserName(TextFormater
            .formatFirstLastName(addressesData.getFirstName(), addressesData.getLastName()));
        Map<String, Object> streets = addressesData.getStreet();
        List<String> addresses = new ArrayList<>();
        for (Map.Entry<String, Object> entry : streets.entrySet()) {
            addresses.add((String) entry.getValue());
        }
        checkoutVM.setShippingAddressOne(addresses.get(0));
        checkoutVM.setShippingAddressTwo(addresses.get(1));
        checkoutVM.setShippingCityStatePost(TextFormater
            .formatCityStateCode(addressesData.getCity(), addressesData.getRegionId(),
                addressesData.getCity()));
        checkoutVM.setShippingCountry(addressesData.getCountryId());
        checkoutVM.setShippingTel(NumberFormater.formaterTelNo(addressesData.getTelephone()));
        //todo these hard code is wait for api
        checkoutVM.setBillingUserName("User Name");
        checkoutVM.setBillingAddressOne("Address 1");
        checkoutVM.setBillingAddressTwo("Address 2");
        checkoutVM
            .setBillingCityStatePost(TextFormater.formatCityStateCode("City", "State", "1000"));
        checkoutVM.setBillingCountry("China");
        checkoutVM.setBillingTel(NumberFormater.formaterTelNo("1234155434232"));
        PaymentMethodVM paymentMethodVM;
        List<PaymentMethodVM> methodVMS = new ArrayList<>();
        List<PaymentMethodData> paymentMethodDatas = response.getPaymentMethod();
        for (PaymentMethodData data : paymentMethodDatas) {
            paymentMethodVM = new PaymentMethodVM();
            paymentMethodVM.setId(data.getId());
            paymentMethodVM.setName(data.getName());
            if (data.getMonths() != null && data.getMonths().size() > 0) {
                List<ProfileMetaVM> profileMetaVMS = new ArrayList<>();
                for (String month : data.getMonths()) {
                    profileMetaVMS.add(new ProfileMetaVM(month, month + "month"));
                }
                paymentMethodVM.setMonths(profileMetaVMS);
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
            productVM.setImageDefault(R.drawable.ic_image_404_small);

            RMData rmData = data.getPrice().getRM();
            productVM.setOldPrice(NumberFormater.formaterPrice(rmData.getOriginal()));
            productVM.setNowPrice(NumberFormater.formaterPrice(rmData.getDiscounted()));
            List<SuperAttributeData> superAttributeDatas = data.getSuperAttributes();
            String attribute = "";
            for (SuperAttributeData attributeData : superAttributeDatas) {
                attribute = attribute + attributeData.getName() + COMMA + attributeData
                    .getVariantName() + END;
            }
            productVM.setAttribute(attribute);
            productVM.setPercent(rmData.getDiscountTitle());
            productVM.setAttrs(data.getAttributes());
            productVMS.add(productVM);
        }

        checkoutVM.setProductVMS(productVMS);
        OrderRMData orderRMData = response.getBilling().getRm();
        checkoutVM.setSubTotal(NumberFormater.formaterPrice(orderRMData.getSubTotal()));
        checkoutVM.setShipping(NumberFormater.formaterPrice(orderRMData.getShipping()));
        checkoutVM
            .setDiscountCode(TextFormater.formatBillingCode(orderRMData.getDiscount().getCode()));
        checkoutVM.setDiscountAmount(orderRMData.getDiscount().getAmount());
        checkoutVM
            .seteGiftCode(TextFormater.formatBillingCode(orderRMData.getEgiftCard().getCode()));
        checkoutVM.seteGiftAmount(orderRMData.getEgiftCard().getAmount());
        checkoutVM.setBillingTotal(NumberFormater.formaterPrice(orderRMData.getTotal()));
        checkoutVM.setPointsAmount(orderRMData.getGoshopPoints().getAmount());
        checkoutVM.setPointsApplied(orderRMData.getGoshopPoints().getApplied());
        return checkoutVM;
    }

}
