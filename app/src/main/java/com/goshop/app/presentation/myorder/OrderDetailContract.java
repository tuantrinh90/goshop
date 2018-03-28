package com.goshop.app.presentation.myorder;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.OrderDetailVM;

import java.util.Map;

public class OrderDetailContract {

    interface View extends BaseView {

        void showOrderDetailResult(OrderDetailVM orderDetailVM);
    }

    public interface Presenter extends BasePresenter<View> {

        void orderDetailRequest(Map<String, Object> params);
    }

}
