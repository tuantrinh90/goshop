package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.AddressReponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.AddressVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by helen on 2018/1/26.
 */

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
            new DisposableObserver<AddressReponse>() {
                @Override
                public void onNext(AddressReponse addressReponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    mView.myAddressResult(getMockDatas());

                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //TODO(helen) this is mock data
    private List<AddressVM> getMockDatas() {
        List<AddressVM> addressVMS = new ArrayList<>();
        addressVMS.add(new AddressVM("Test Name", "Address", "City", "State", "1000", "China",
            "T: +1234567890", true));
        addressVMS.add(new AddressVM("Test Name", "Address", "City", "State", "1000", "China",
            "T: +1234567890", false));
        return addressVMS;
    }
}
