package com.goshop.app.presentation.myorder;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.OrderDetailVM;

public class OrderDetailContract {

    interface View extends BaseView {

        void showOrderDetailResult(OrderDetailVM orderDetailVM);

        void showNetBreak();

        void showErrorMessage(String errorMessage);
    }

    public interface Presenter extends BasePresenter<View> {

        void getOrderDetail();
    }

}
