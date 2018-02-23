package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.AddressReponse;
import com.goshop.app.domian.AccountRepository;

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
            new DisposableObserver<AddressReponse>() {
                @Override
                public void onNext(AddressReponse addressReponse) {
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
}
