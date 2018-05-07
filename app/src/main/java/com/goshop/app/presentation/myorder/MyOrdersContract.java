package com.goshop.app.presentation.myorder;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.MyOrdersVM;

import java.util.List;

public class MyOrdersContract {

    interface View extends BaseView {

        void showMyOrdersResult(List<MyOrdersVM> myOrdersVMS);

        void showNetError();

        void showGetListFailedMessage(String errorMessage);

        void stopRefresh();
    }

    public interface Presenter extends BasePresenter<View> {

        void getListOrder(int page, boolean isRefresh);
    }

}
