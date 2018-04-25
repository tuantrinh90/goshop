package com.goshop.app.presentation.account;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.request.AddressRequest;
import com.goshop.app.data.model.response.AddressResponse;
import com.goshop.app.data.model.response.CityResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.model.response.StatesResponse;
import com.goshop.app.data.model.response.ZipCodeResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.mapper.AddressMapper;
import com.goshop.app.presentation.model.ProfileMetaVM;

import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class EditAddressPresenter extends RxPresenter<EditAddressContract.View> implements
    EditAddressContract.Presenter {

    private AccountRepository accountRepository;

    public EditAddressPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void editAddressRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.editAddressRequest(params).subscribeWith(
            new DisposableObserver<AddressResponse>() {
                @Override
                public void onNext(AddressResponse addressResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showEditAddressResult();
                }

                @Override
                public void onComplete() {

                }
            }));

    }

    @Override
    public void editAddressRequest(AddressRequest addressRequest) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.editAddressRequest(addressRequest).subscribeWith(
            new DisposableObserver<Response<AddressResponse>>() {
                @Override
                public void onNext(Response<AddressResponse> response) {
                    mView.hideLoadingBar();
                    mView.editAddressSuccess();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    mView.editAddressFailed(throwable.getLocalizedMessage().toString());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void getStates() {
        Map<String, Object> params = new HashMap<>();
        params.put(Const.REQUEST_PARAM_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.REQUEST_PARAM_STORE_ID, Const.STORE_ID);
        params.put(Const.REQUEST_PARAM_COUNTRY_CODE, Const.COUNTRY_CODE_MY);
        addSubscrebe(accountRepository.getStates(params)
            .subscribeWith(new DisposableObserver<Response<StatesResponse>>() {
                @Override
                public void onNext(Response<StatesResponse> response) {
                    mView.onStatesRequestSuccess(AddressMapper.transformStates(response));
                }

                @Override
                public void onError(Throwable e) {
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void getCitys(String stateId) {
        Map<String, Object> params = new HashMap<>();
        params.put(Const.REQUEST_PARAM_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.REQUEST_PARAM_STORE_ID, Const.STORE_ID);
        params.put(Const.REQUEST_PARAM_COUNTRY_CODE, Const.COUNTRY_CODE_MY);
        params.put(Const.REQUEST_PARAM_STATE_ID, stateId);
        addSubscrebe(accountRepository.getCity(params)
            .subscribeWith(new DisposableObserver<Response<CityResponse>>() {
                @Override
                public void onNext(Response<CityResponse> response) {
                    mView.onCitysRequestSuccess(AddressMapper.transformCitys(response));
                }

                @Override
                public void onError(Throwable e) {
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void getZipCode(String stateId, String cityCode) {
        Map<String, Object> params = new HashMap<>();
        params.put(Const.REQUEST_PARAM_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.REQUEST_PARAM_STORE_ID, Const.STORE_ID);
        params.put(Const.REQUEST_PARAM_COUNTRY_CODE, Const.COUNTRY_CODE_MY);
        params.put(Const.REQUEST_PARAM_STATE_ID, stateId);
        params.put(Const.REQUEST_PARAM_CITY_CODE, cityCode);
        addSubscrebe(accountRepository.getZipCode(params)
            .subscribeWith(new DisposableObserver<Response<ZipCodeResponse>>() {
                @Override
                public void onNext(Response<ZipCodeResponse> response) {
                    mView.onZipCodeRequestSuccess(AddressMapper.transformZipCode(response));
                }

                @Override
                public void onError(Throwable e) {
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public List<ProfileMetaVM> getCountryChooses() {
        //todo this is mock data
        List<ProfileMetaVM> profileMetaVMS = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            profileMetaVMS.add(new ProfileMetaVM("Country " + (i + 1)));
        }
        return profileMetaVMS;
    }

}
