package com.goshop.app.presentation.myorder;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.response.MyOrderDetailReponse;
import com.goshop.app.data.model.response.MyOrderListResponse;

import java.util.Map;

/**
 * Created by Administrator on 2018/1/6.
 */

public interface MyOrderContract {

    interface View extends BaseView {

        void showOrderList(MyOrderListResponse response);

        void showNetwordErrorMessage();

        void showFaildMessage(String errorMessage);

        public void showSwipeLayout();

        public void closeSwipeLayout();

        void showOrderDetail(MyOrderDetailReponse reponse);
    }

    interface Presenter extends BasePresenter<View> {

        void getOrderList(Map<String, Object> params);

        void getOrderDetail(Map<String, Object> params);
    }

}
