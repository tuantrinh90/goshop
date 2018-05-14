package com.goshop.app.presentation.checkout;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.ApplyDiscountVM;
import com.goshop.app.presentation.model.ApplyEGiftVM;
import com.goshop.app.presentation.model.ApplyPointsVM;
import com.goshop.app.presentation.model.BillingVM;
import com.goshop.app.presentation.model.CheckoutVM;
import com.goshop.app.presentation.model.PaymentVM;

public interface CheckoutContract {

    interface View extends BaseView {

        void showNetwordErrorMessage();

        void showErrorMessage(String errorMessage);

        void applyCouponSuccess(BillingVM billingVM);

        void applyPointsSuccess(BillingVM billingVM);

        void applyEGiftSuccess(BillingVM billingVM);

        void showPaymentProgress();

        void checkoutRequestSuccess(CheckoutVM checkoutVM);

        void placeOrderSuccess(PaymentVM paymentVM);
    }

    interface Presenter extends BasePresenter<View> {

        void checkoutRequest(String quoteId, String addressId);

        void applyCoupon(String couponCode, String cartId);

        void applyPoints(String point, String cartId);

        void applyEGiftCard(String egiftCard, String cartId);

        void paymentRequest(String quoteId, String addressId, String paymentMethod, String eppMonth);
    }

}
