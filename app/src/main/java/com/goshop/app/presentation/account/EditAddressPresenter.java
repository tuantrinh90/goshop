package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.AddressResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.widget.SingleChooseVM;

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
    public List<SingleChooseVM> getCountryChooses() {
        return null;
    }

    @Override
    public List<SingleChooseVM> getStateChooses() {
        return null;
    }

    @Override
    public List<SingleChooseVM> getCityChooses() {
        return null;
    }
}
