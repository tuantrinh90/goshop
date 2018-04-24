package com.goshop.app.presentation.checkout;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.presentation.model.ApplyDiscountVM;
import com.goshop.app.presentation.model.ApplyEGiftVM;
import com.goshop.app.presentation.model.ApplyPointsVM;

public interface CheckoutContract {

    interface View extends BaseView {

        void showCheckout(CheckoutResponse checkoutResponse);

        void showNetwordErrorMessage();

        void showErrorMessage(String errorMessage);

        void applyCouponSuccess(ApplyDiscountVM discountVM);

        void applyPointsSuccess(ApplyPointsVM pointsVM);

        void applyEGiftSuccess(ApplyEGiftVM eGiftVM);

        void showPaymentProgress();
    }

    interface Presenter extends BasePresenter<View> {

        void getCheckout(String sessionKey);

        void applyCoupon(String couponCode, String cartId);

        void applyPoints(String point, String cartId);

        void applyEGiftCard(String egiftCard, String cartId);

        void paymentRequest();
    }

}
