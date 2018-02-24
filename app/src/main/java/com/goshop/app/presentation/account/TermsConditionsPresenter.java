package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.TermsConditionsReponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.TermsConditionsVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class TermsConditionsPresenter extends RxPresenter<TermsConditionsContract.View>
    implements TermsConditionsContract.Presenter {

    private AccountRepository accountRepository;

    public TermsConditionsPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void termsConditionsRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.termsConditionsRequest(params).subscribeWith(
            new DisposableObserver<TermsConditionsReponse>() {
                @Override
                public void onNext(TermsConditionsReponse reponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    //TODO  wait for api
                    mView.showResult(getMockData());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //TODO  this is mock data
    private List<TermsConditionsVM> getMockData() {
        List<TermsConditionsVM> termsConditionsVMS = new ArrayList<>();
        termsConditionsVMS.add(new TermsConditionsVM("ECMC Customer Terms And Conditions"));
        termsConditionsVMS.add(new TermsConditionsVM("TV Home Shopping Customer Terms And …"));

        return termsConditionsVMS;
    }
}
