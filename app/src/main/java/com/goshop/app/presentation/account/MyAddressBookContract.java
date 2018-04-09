package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.AddressVM;

import java.util.List;
import java.util.Map;

public class MyAddressBookContract {

    interface View extends BaseView {

        void myAddressResult(List<AddressVM> addressVMS);

        void getAddressListSuccess(List<AddressVM> addressVMS);

        void getAddressListFailed(String errorMessage);
    }

    public interface Presenter extends BasePresenter<View> {

        void myAddressRequest(Map<String, Object> params);

        void getAddressList();
    }
}
