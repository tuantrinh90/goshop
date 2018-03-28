package com.goshop.app.presentation.myorder;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.MyOrdersVM;

import java.util.List;
import java.util.Map;

public class MyOrdersContract {

    interface View extends BaseView {

        void showMyOrdersResult(List<MyOrdersVM> myOrdersVMS);
    }

    public interface Presenter extends BasePresenter<View> {

        void myOrdersRequest(Map<String, Object> params);
    }

}
