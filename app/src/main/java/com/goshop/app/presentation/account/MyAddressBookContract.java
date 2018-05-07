package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.AddressVM;

import java.util.List;

public class MyAddressBookContract {

    interface View extends BaseView {

        void getAddressListSuccess(List<AddressVM> addressVMS);

        void showErrorMessage(String errorMessage);

        void stopRefresh();
    }

    public interface Presenter extends BasePresenter<View> {

        void editAddressRequest(boolean isBilling);

        void getAddressList(int page, boolean isRefresh);
    }
}
