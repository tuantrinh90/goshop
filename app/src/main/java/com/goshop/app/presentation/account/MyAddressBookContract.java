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

        void showErrorMessage(String errorMessage);

        void selectDefaultShippingSuccess(int position);

        void selectDefaultBillingSuccess(int position);
    }

    public interface Presenter extends BasePresenter<View> {

        void myAddressRequest(Map<String, Object> params);

        void getAddressList();

        void selectDefaultShippingRequest(int position);

        void selectDefaultBillingRequest(int position);
    }
}
