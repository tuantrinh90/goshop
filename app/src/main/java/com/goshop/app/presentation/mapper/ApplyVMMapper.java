package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.ApplyCouponResponse;
import com.goshop.app.data.model.response.ApplyEGiftResponse;
import com.goshop.app.data.model.response.ApplyPointsResponse;
import com.goshop.app.data.model.response.common.RMData;
import com.goshop.app.presentation.model.ApplyEGiftVM;
import com.goshop.app.presentation.model.ApplyPointsVM;
import com.goshop.app.presentation.model.BillingVM;
import com.goshop.app.utils.NumberFormater;
import com.goshop.app.utils.TextFormater;

public class ApplyVMMapper {

    public static BillingVM transform(ApplyCouponResponse response) {
        BillingVM billingVM = new BillingVM();
        RMData rmData = response.getBilling().getRm();
        billingVM.setBillingDiscountAmount(rmData.getDiscount().getAmount());
        billingVM
            .setBillingDiscountCode(TextFormater.formatBillingCode(rmData.getDiscount().getCode()));
        billingVM.setBillingEGiftAmount(rmData.geteGiftCard().getAmount());
        billingVM
            .setBillingEGiftCode(TextFormater.formatBillingCode(rmData.geteGiftCard().getCode()));
        billingVM.setBillingPointsAmount(rmData.getGoshopPoints().getAmount());
        billingVM.setBillingPointsApplied(
            TextFormater.formatBillingCode(rmData.getGoshopPoints().getApplied()));
        billingVM.setBillingShipping(NumberFormater.formaterPrice(rmData.getShipping()));
        billingVM.setBillingSubTotal(NumberFormater.formaterPrice(rmData.getSubTotal()));
        billingVM.setBillingTotal(NumberFormater.formaterPrice(rmData.getTotal()));
        return billingVM;
    }

    public static BillingVM transform(ApplyPointsResponse response) {
        BillingVM billingVM = new BillingVM();
        RMData rmData = response.getBilling().getRm();
        billingVM.setBillingDiscountAmount(rmData.getDiscount().getAmount());
        billingVM
            .setBillingDiscountCode(TextFormater.formatBillingCode(rmData.getDiscount().getCode()));
        billingVM.setBillingEGiftAmount(rmData.geteGiftCard().getAmount());
        billingVM
            .setBillingEGiftCode(TextFormater.formatBillingCode(rmData.geteGiftCard().getCode()));
        billingVM.setBillingPointsAmount(rmData.getGoshopPoints().getAmount());
        billingVM.setBillingPointsApplied(
            TextFormater.formatBillingCode(rmData.getGoshopPoints().getApplied()));
        billingVM.setBillingShipping(NumberFormater.formaterPrice(rmData.getShipping()));
        billingVM.setBillingSubTotal(NumberFormater.formaterPrice(rmData.getSubTotal()));
        billingVM.setBillingTotal(NumberFormater.formaterPrice(rmData.getTotal()));
        return billingVM;
    }

    public static BillingVM transform(ApplyEGiftResponse response) {
        BillingVM billingVM = new BillingVM();
        RMData rmData = response.getBilling().getRm();
        billingVM.setBillingDiscountAmount(rmData.getDiscount().getAmount());
        billingVM
            .setBillingDiscountCode(TextFormater.formatBillingCode(rmData.getDiscount().getCode()));
        billingVM.setBillingEGiftAmount(rmData.geteGiftCard().getAmount());
        billingVM
            .setBillingEGiftCode(TextFormater.formatBillingCode(rmData.geteGiftCard().getCode()));
        billingVM.setBillingPointsAmount(rmData.getGoshopPoints().getAmount());
        billingVM.setBillingPointsApplied(
            TextFormater.formatBillingCode(rmData.getGoshopPoints().getApplied()));
        billingVM.setBillingShipping(NumberFormater.formaterPrice(rmData.getShipping()));
        billingVM.setBillingSubTotal(NumberFormater.formaterPrice(rmData.getSubTotal()));
        billingVM.setBillingTotal(NumberFormater.formaterPrice(rmData.getTotal()));
        return billingVM;
    }

}
