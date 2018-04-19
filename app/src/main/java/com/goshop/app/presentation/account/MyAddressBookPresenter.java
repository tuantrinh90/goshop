package com.goshop.app.presentation.account;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.AddressResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.mapper.AddressMapper;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class MyAddressBookPresenter extends RxPresenter<MyAddressBookContract.View> implements
    MyAddressBookContract.Presenter {

    private AccountRepository accountRepository;

    public MyAddressBookPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void myAddressRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.myAddressRequest(params).subscribeWith(
            new DisposableObserver<AddressResponse>() {
                @Override
                public void onNext(AddressResponse addressResponse) {
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
    public void getAddressList() {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        addSubscrebe(accountRepository.getAddressList(params).subscribeWith(
            new DisposableObserver<Response<AddressResponse>>() {
                @Override
                public void onNext(Response<AddressResponse> response) {
                    mView.hideLoadingBar();
                    mView.getAddressListSuccess(AddressMapper.transform(response));
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    mView.showErrorMessage(throwable.getLocalizedMessage().toString());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void selectDefaultShippingRequest(int position) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        addSubscrebe(accountRepository.selectDefaultShippingRequest(params).subscribeWith(
            new DisposableObserver<Response>() {
                @Override
                public void onNext(Response response) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    //todo wait for api
                    mView.selectDefaultShippingSuccess(position);
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void selectDefaultBillingRequest(int position) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        addSubscrebe(accountRepository.selectDefaultBillingRequest(params).subscribeWith(
            new DisposableObserver<Response>() {
                @Override
                public void onNext(Response response) {
                    mView.hideLoadingBar();

                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    //todo wait for api
                    mView.selectDefaultBillingSuccess(position);
                }

                @Override
                public void onComplete() {

                }
            }));
    }

}
