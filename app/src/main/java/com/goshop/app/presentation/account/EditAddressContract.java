package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.request.AddressRequest;
import com.goshop.app.presentation.model.ProfileMetaVM;

import java.util.List;

public class EditAddressContract {

    interface View extends BaseView {

        void editAddressSuccess();

        void editAddressFailed(String errorMessage);

        void onStatesRequestSuccess(List<ProfileMetaVM> response);

        void onCitysRequestSuccess(List<ProfileMetaVM> response);

        void onZipCodeRequestSuccess(List<ProfileMetaVM> response);
    }

    public interface Presenter extends BasePresenter<View> {

        List<ProfileMetaVM> getCountryChooses();

        void editAddressRequest(AddressRequest addressRequest);

        void getStates();

        void getCitys(String stateId);

        void getZipCode(String stateId, String cityCode);
    }

}
