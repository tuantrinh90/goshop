package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.request.AddressRequest;
import com.goshop.app.data.model.response.AddressResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.widget.SingleChooseVM;

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
            new DisposableObserver<AddressResponse>() {
                @Override
                public void onNext(AddressResponse addressResponse) {
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
    public List<SingleChooseVM> getCountryChooses() {
        //todo this is mock data
        List<SingleChooseVM> singleChooseVMS = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            singleChooseVMS.add(new SingleChooseVM("Country " + (i + 1)));
        }
        return singleChooseVMS;
    }

    @Override
    public List<SingleChooseVM> getStateChooses() {
        //todo this is mock data
        List<SingleChooseVM> singleChooseVMS = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            singleChooseVMS.add(new SingleChooseVM("State " + (i + 1)));
        }
        return singleChooseVMS;
    }

    @Override
    public List<SingleChooseVM> getCityChooses() {
        //todo this is mock data
        List<SingleChooseVM> singleChooseVMS = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            singleChooseVMS.add(new SingleChooseVM("City " + (i + 1)));
        }
        return singleChooseVMS;
    }
}
