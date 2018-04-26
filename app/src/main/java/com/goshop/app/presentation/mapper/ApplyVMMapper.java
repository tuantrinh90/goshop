package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.ApplyCouponResponse;
import com.goshop.app.data.model.response.ApplyEGiftResponse;
import com.goshop.app.data.model.response.ApplyPointsResponse;
import com.goshop.app.presentation.model.ApplyDiscountVM;
import com.goshop.app.presentation.model.ApplyEGiftVM;
import com.goshop.app.presentation.model.ApplyPointsVM;
import com.goshop.app.utils.NumberFormater;

public class ApplyVMMapper {

    public static ApplyDiscountVM transform(ApplyCouponResponse response) {
        ApplyDiscountVM discountVM = new ApplyDiscountVM();
        discountVM.setDiscount(response.getDiscount().getDiscount());
        discountVM.setDiscountedPrice(response.getDiscount().getDiscountedPrice());
        discountVM.setOriginalPrice(NumberFormater.formaterPrice(response.getDiscount().getOriginalPrice()));
        discountVM.setType(response.getDiscount().getType());
        return discountVM;
    }

    public static ApplyPointsVM transform(ApplyPointsResponse response) {
        ApplyPointsVM pointsVM = new ApplyPointsVM();
        pointsVM.setPointsTotal(response.getGoshopPoints().getTotal());
        pointsVM.setPointsApplied(response.getGoshopPoints().getApplied());
        pointsVM.setPointsBalance(response.getGoshopPoints().getBalance());
        pointsVM.setPriceNew(response.getPrice().getNewPrice());
        pointsVM.setPriceOriginal(response.getPrice().getOriginalPrice());
        return pointsVM;
    }

    public static ApplyEGiftVM transform(ApplyEGiftResponse response) {
        ApplyEGiftVM eGiftVM = new ApplyEGiftVM();
        eGiftVM.seteGiftAmount(response.getEGiftCard().getAmount());
        eGiftVM.seteGiftApplied(response.getEGiftCard().getApplied());
        eGiftVM.seteGiftBalance(response.getEGiftCard().getBalance());
        eGiftVM.setPriceNew(response.getPrice().getNewPrice());
        eGiftVM.setPriceOriginal(response.getPrice().getOriginalPrice());
        return eGiftVM;
    }

}
