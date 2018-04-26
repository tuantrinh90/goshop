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
    public void editAddressRequest(boolean isBilling) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        if(isBilling) {
            params.put(Const.PARAMS_DEFAULT_BILLING, isBilling);
        } else {
            params.put(Const.PARAMS_DEFAULT_SHIPPING, !isBilling);
        }
        addSubscrebe(accountRepository.editAddressRequest(params).subscribeWith(
            new DisposableObserver<Response<AddressResponse>>() {
                @Override
                public void onNext(Response<AddressResponse> response) {
                    mView.hideLoadingBar();
                    mView.getAddressListSuccess(AddressMapper.transform(response));
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showErrorMessage(e.getLocalizedMessage().toString());
                }

                @Override
                public void onComplete() {

                }
            }));

    }

    @Override
    public void getAddressList(int page, boolean isRefresh) {
        if(!isRefresh) {
            mView.showLoadingBar();
        }
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        addSubscrebe(accountRepository.getAddressList(params).subscribeWith(
            new DisposableObserver<Response<AddressResponse>>() {
                @Override
                public void onNext(Response<AddressResponse> response) {
                    mView.hideLoadingBar();
                    mView.stopRefresh();
                    mView.getAddressListSuccess(AddressMapper.transform(response));
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    mView.stopRefresh();
                    mView.showErrorMessage(throwable.getLocalizedMessage().toString());
                }

                @Override
                public void onComplete() {

                }
            }));
    }


}
