package com.goshop.app.presentation.checkout;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.SelectAddressVM;

import java.util.List;
import java.util.Map;

public class CheckoutSelectContract {

    interface View extends BaseView {

        void showResult(List<SelectAddressVM> selectAddressVMS);
    }

    public interface Presenter extends BasePresenter<View> {

        void selectAddressRequest(String type, Map<String, Object> params);
    }
}
