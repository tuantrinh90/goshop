package com.goshop.app.presentation.checkout;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.AddressResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.SelectAddressVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class CheckoutSelectPresenter extends RxPresenter<CheckoutSelectContract.View> implements
    CheckoutSelectContract.Presenter {

    private AccountRepository accountRepository;

    public CheckoutSelectPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void selectAddressRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.selectAddressRequest(params).subscribeWith(
            new DisposableObserver<AddressResponse>() {
                @Override
                public void onNext(AddressResponse addressResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    mView.showResult(getMockData());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //TODO(helen)wait for api
    private List<SelectAddressVM> getMockData() {
        List<SelectAddressVM> addressVMS = new ArrayList<>();
        addressVMS.add(new SelectAddressVM("Test Name", "Address", "City", "State", "1000", "China",
            "T: +1234567890", true));
        addressVMS.add(new SelectAddressVM("Test Name", "Address", "City", "State", "1000", "China",
            "T: +1234567890", false));
        return addressVMS;
    }
}
