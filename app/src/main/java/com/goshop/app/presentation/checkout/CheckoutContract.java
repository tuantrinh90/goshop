package com.goshop.app.presentation.checkout;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.response.CheckoutResponse;

public interface CheckoutContract {

    interface View extends BaseView {

        void showCheckout(CheckoutResponse checkoutResponse);

        void showNetwordErrorMessage();

        void showFaildMessage(String errorMessage);
    }

    interface Presenter extends BasePresenter<View> {

        void getCheckout(String sessionKey);
    }

}
