package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.MyEGiftResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.MyEGiftCardsDetailsVM;
import com.goshop.app.presentation.model.MyEGiftModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class MyEGiftCardPresenter extends RxPresenter<MyEGiftCardContract.View> implements
    MyEGiftCardContract.Presenter {

    private AccountRepository accountRepository;

    public MyEGiftCardPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void eGiftCardsRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.eGiftCardsRequest(params).subscribeWith(
            new DisposableObserver<MyEGiftResponse>() {
                @Override
                public void onNext(MyEGiftResponse myEGiftResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showGiftCardsResult(getMockData());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //todo this is mock data
    private List<MyEGiftModel> getMockData() {
        List<MyEGiftModel> myEGiftModels = new ArrayList<>();
        myEGiftModels.add(new MyEGiftModel(MyEGiftModel.VIEW_TYPE_TOP));
        myEGiftModels.add(new MyEGiftModel(MyEGiftModel.VIEW_TYPE_CENTER));
        MyEGiftCardsDetailsVM detailsVM = new MyEGiftCardsDetailsVM("ABCDE", "Sent by Sender Name",
            "Expire till 12 Feb 2018", "120", "Active");
        myEGiftModels.add(detailsVM);
        myEGiftModels.add(detailsVM);
        myEGiftModels.add(detailsVM);
        myEGiftModels.add(detailsVM);
        return myEGiftModels;
    }
}
