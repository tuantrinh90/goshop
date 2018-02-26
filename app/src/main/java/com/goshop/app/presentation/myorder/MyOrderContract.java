package com.goshop.app.presentation.myorder;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.response.MyOrderDetailResponse;
import com.goshop.app.data.model.response.MyOrderListResponse;

import java.util.Map;

public interface MyOrderContract {

    interface View extends BaseView {

        void showOrderList(MyOrderListResponse response);

        void showNetwordErrorMessage();

        void showFaildMessage(String errorMessage);

        public void showSwipeLayout();

        public void closeSwipeLayout();

        void showOrderDetail(MyOrderDetailResponse reponse);
    }

    interface Presenter extends BasePresenter<View> {

        void getOrderList(Map<String, Object> params);

        void getOrderDetail(Map<String, Object> params);
    }

}
