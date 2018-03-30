package com.goshop.app.presentation.login;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.RegisterResponse;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.widget.SingleChooseVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class RegisterPresenter extends RxPresenter<RegisterContract.View> implements
    RegisterContract.Presenter {

    private AccountRepository accountRepository;

    @Inject
    public RegisterPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void registerRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.registerRequest(params).subscribeWith(
            new DisposableObserver<RegisterResponse>() {
                @Override
                public void onNext(RegisterResponse response) {
                    mView.hideLoadingBar();
                    mView.registerSuccess();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    if (throwable instanceof ServiceApiFail) {
                        ServiceApiFail serviceApiFail = (ServiceApiFail) throwable;
                        mView.showFaildMessage(serviceApiFail.getErrorMessage());
                    } else {
                        mView.showFaildMessage(throwable.getLocalizedMessage().toString());
                    }
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public List<SingleChooseVM> getTitleChooses() {
        //todo this is mock data
        List<SingleChooseVM> singleChooseVMS = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            singleChooseVMS.add(new SingleChooseVM("Title " + (i + 1)));
        }

        return singleChooseVMS;
    }

    @Override
    public List<SingleChooseVM> getLanguageChooses() {
        //todo this is mock data
        List<SingleChooseVM> singleChooseVMS = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            singleChooseVMS.add(new SingleChooseVM("Languages " + (i + 1)));
        }
        return singleChooseVMS;
    }

}
