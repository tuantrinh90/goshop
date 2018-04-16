package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.request.AddressRequest;
import com.goshop.app.data.model.response.AddressResponse;
import com.goshop.app.data.model.response.CityResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.model.response.StatesResponse;
import com.goshop.app.data.model.response.ZipCodeResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.ProfileMetaVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class AddAddressPresenter extends RxPresenter<AddAddressContract.View> implements
    AddAddressContract.Presenter {

    private AccountRepository accountRepository;

    public AddAddressPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void addAddressRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.addAddressRequest(params).subscribeWith(
            new DisposableObserver<AddressResponse>() {
                @Override
                public void onNext(AddressResponse addressResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    mView.addAddressResult();
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void addAddressRequest(AddressRequest addressRequest) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.addAddressRequest(addressRequest).subscribeWith(
            new DisposableObserver<Response<AddressResponse>>() {
                @Override
                public void onNext(Response<AddressResponse> response) {
                    mView.hideLoadingBar();
                    mView.addAddressSuccess();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    mView.addAddressFailed(throwable.getLocalizedMessage().toString());
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

    @Override
    public List<ProfileMetaVM> getStateChooses() {

        List<ProfileMetaVM> profileMetaVMS = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            profileMetaVMS.add(new ProfileMetaVM("State " + (i + 1)));
        }
        return profileMetaVMS;
    }

    @Override
    public List<ProfileMetaVM> getCityChooses() {
        //todo this is mock data
        List<ProfileMetaVM> profileMetaVMS = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            profileMetaVMS.add(new ProfileMetaVM("City " + (i + 1)));
        }
        return profileMetaVMS;
    }

    @Override
    public void getState() {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.getStates().subscribeWith(
            new DisposableObserver<Response<StatesResponse>>() {
                @Override
                public void onNext(Response<StatesResponse> response) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void getCity() {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.getCity().subscribeWith(
            new DisposableObserver<Response<CityResponse>>() {
                @Override
                public void onNext(Response<CityResponse> response) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void getZipCode() {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.getZipCode().subscribeWith(
            new DisposableObserver<Response<ZipCodeResponse>>() {
                @Override
                public void onNext(Response<ZipCodeResponse> response) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onComplete() {

                }
            }));
    }
}
