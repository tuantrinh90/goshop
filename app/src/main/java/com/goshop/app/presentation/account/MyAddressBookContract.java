package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.AddressVM;

import java.util.List;
import java.util.Map;



public class MyAddressBookContract {

    interface View extends BaseView {

        void myAddressResult(List<AddressVM> addressVMS);
    }

    public interface Presenter extends BasePresenter<View> {

        void myAddressRequest(Map<String, Object> params);
    }
}
