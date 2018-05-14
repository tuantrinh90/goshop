package com.goshop.app.presentation.mapper;

import com.goshop.app.Const;
import com.goshop.app.R;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.data.model.response.common.AddressData;
import com.goshop.app.data.model.response.common.EmiOptionsData;
import com.goshop.app.data.model.response.common.PaymentMethodData;
import com.goshop.app.data.model.response.common.ProductData;
import com.goshop.app.data.model.response.common.RMData;
import com.goshop.app.data.model.response.common.SuperAttributeData;
import com.goshop.app.presentation.model.AddressVM;
import com.goshop.app.presentation.model.BillingVM;
import com.goshop.app.presentation.model.CheckoutVM;
import com.goshop.app.presentation.model.PaymentMethodVM;
import com.goshop.app.presentation.model.ProfileMetaVM;
import com.goshop.app.presentation.model.common.ProductVM;
import com.goshop.app.utils.NumberFormater;
import com.goshop.app.utils.TextFormater;

import java.util.ArrayList;
import java.util.List;

public class CheckoutMapper {

    private static final String COMMA = ", ";

    private static final String END = "; ";

    public static CheckoutVM transform(CheckoutResponse response) {
        CheckoutVM checkoutVM = new CheckoutVM();

        List<AddressData> addressDatas = response.getAddress();
        List<AddressVM> addressVMS = new ArrayList<>();
        for (AddressData addressData : addressDatas) {
            AddressVM addressVM = new AddressVM();
            addressVM.setName(TextFormater.formatFirstLastName(addressData.getFirstname(),
                addressData.getLastname()));
            List<String> streets = addressData.getStreet();
            addressVM.setAddress(streets.get(0));
            addressVM.setAddressSecond(streets.get(1));
            addressVM.setCityStatePost(TextFormater.formatCityStateCode(addressData.getCity(),
                addressData.getRegion(), addressData.getPostcode()));
            addressVM.setCountry(addressData.getCountry());
            addressVM.setTel(NumberFormater.formaterTelNo(addressData.getTelephone()));
            addressVM.setShippingDefault(addressData.isDefaultShipping());
            addressVM.setBillingDefault(addressData.isDefaultBilling());
            addressVMS.add(addressVM);
        }
        if (addressVMS.size() == 1) {
            addressVMS.add(addressVMS.get(0));
        }
        checkoutVM.setAddressVMS(addressVMS);
        PaymentMethodVM paymentMethodVM;
        List<PaymentMethodVM> methodVMS = new ArrayList<>();
        List<PaymentMethodData> paymentMethodDatas = response.getPaymentMethod();
        List<EmiOptionsData> emiOptionsDatas = response.getEmiOptions();
        List<ProfileMetaVM> profileMetaVMS = new ArrayList<>();
        if (emiOptionsDatas != null && emiOptionsDatas.size() > 0) {
            for (EmiOptionsData optionsData : emiOptionsDatas) {
                profileMetaVMS
                    .add(new ProfileMetaVM(optionsData.getValue(), optionsData.getLabel()));
            }
        }

        for (PaymentMethodData data : paymentMethodDatas) {
            paymentMethodVM = new PaymentMethodVM();
            paymentMethodVM.setCode(data.getCode());
            paymentMethodVM.setTitle(data.getTitle());
            if (data.getCode().equals(Const.PAYMENT_CODE)) {
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
        RMData rmData = response.getBilling().getRm();
        BillingVM billingVM = new BillingVM();
        billingVM.setBillingSubTotal(NumberFormater.formaterPrice(rmData.getSubTotal()));
        billingVM.setBillingShipping(NumberFormater.formaterPrice(rmData.getShipping()));
        billingVM.setBillingDiscountCode(TextFormater.formatBillingCode(rmData.getDiscount().getCode()));
        billingVM.setBillingDiscountAmount(rmData.getDiscount().getAmount());
        billingVM.setBillingEGiftAmount(rmData.geteGiftCard().getAmount());
        billingVM.setBillingEGiftCode(TextFormater.formatBillingCode(rmData.geteGiftCard().getCode()));
        billingVM.setBillingTotal(NumberFormater.formaterPrice(rmData.getTotal()));
        billingVM.setBillingPointsAmount(rmData.getGoshopPoints().getAmount());
        billingVM.setBillingPointsApplied(rmData.getGoshopPoints().getApplied());
        checkoutVM.setBillingVM(billingVM);
        return checkoutVM;
    }

}
