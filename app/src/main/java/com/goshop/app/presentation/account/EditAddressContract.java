package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.request.AddressRequest;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.model.response.StatesResponse;
import com.goshop.app.presentation.model.ProfileMetaVM;

import android.view.View;

import java.util.List;
import java.util.Map;

public class EditAddressContract {

    interface View extends BaseView {

        void showEditAddressResult();

        void editAddressSuccess();

        void editAddressFailed(String errorMessage);

        void onStatesRequestSuccess(List<ProfileMetaVM> response);

        void onCitysRequestSuccess(List<ProfileMetaVM> response);

        void onZipCodeRequestSuccess(List<ProfileMetaVM> response);
    }

    public interface Presenter extends BasePresenter<View> {

        void editAddressRequest(Map<String, Object> params);

        List<ProfileMetaVM> getCountryChooses();

        void editAddressRequest(AddressRequest addressRequest);

        void getStates();

        void getCitys(String stateId);

        void getZipCode(String stateId, String cityCode);
    }

}
