package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.request.AddressRequest;
import com.goshop.app.presentation.model.ProfileMetaVM;

import java.util.List;
import java.util.Map;

public class AddAddressContract {

    interface View extends BaseView {

        void addAddressResult();

        void addAddressSuccess();

        void addAddressFailed(String errorMessage);
    }

    public interface Presenter extends BasePresenter<View> {

        void addAddressRequest(Map<String, Object> params);

        void addAddressRequest(AddressRequest addressRequest);

        List<ProfileMetaVM> getCountryChooses();

        List<ProfileMetaVM> getStateChooses();

        List<ProfileMetaVM> getCityChooses();
    }
}
