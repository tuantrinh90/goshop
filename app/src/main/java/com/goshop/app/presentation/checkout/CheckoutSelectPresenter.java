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
    public void selectAddressRequest(String type, Map<String, Object> params) {
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
                    mView.showResult(getMockData(type));
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //TODO wait for api
    private List<SelectAddressVM> getMockData() {
        List<SelectAddressVM> addressVMS = new ArrayList<>();
        addressVMS.add(new SelectAddressVM("Test Name", "Address", "City", "State", "1000", "China",
            "T: +1234567890", true));
        addressVMS.add(new SelectAddressVM("Test Name", "Address", "City", "State", "1000", "China",
            "T: +1234567890", false));
        return addressVMS;
    }

    //TODO this is mock data
    private List<SelectAddressVM> getMockData(String type) {
        List<SelectAddressVM> addressVMS = getMockData();
        for(SelectAddressVM addressVM:addressVMS) {
            addressVM.setType(type);
        }
        return addressVMS;
    }
}
