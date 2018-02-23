package com.goshop.app.presentation.checkout;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.PaymentStatusVM;

import java.util.Map;

public class PaymentStatusContract {

    interface View extends BaseView {

        void showFailedLayout(PaymentStatusVM paymentStatusVM);

        void showSuccessLayout(PaymentStatusVM paymentStatusVM);
    }

    public interface Presenter extends BasePresenter<View> {

        void paymentStatusRequest(Map<String, Object> params);
    }

}
