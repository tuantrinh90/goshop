package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.FAQReponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.FAQVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class FAQPresenter extends RxPresenter<FAQContract.View> implements FAQContract.Presenter {

    private AccountRepository accountRepository;

    public FAQPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void faqRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.faqRequest(params).subscribeWith(
            new DisposableObserver<FAQReponse>() {
                @Override
                public void onNext(FAQReponse faqReponse) {
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
    private List<FAQVM> getMockData() {
        List<FAQVM> faqvms = new ArrayList<>();
        faqvms.add(new FAQVM("Products"));
        faqvms.add(new FAQVM("Service"));
        faqvms.add(new FAQVM("How To Buy"));
        faqvms.add(new FAQVM("Payment Methods"));
        faqvms.add(new FAQVM("Coupon"));
        faqvms.add(new FAQVM("Promotions"));
        faqvms.add(new FAQVM("Tracking Orders"));
        faqvms.add(new FAQVM("Delivery"));
        faqvms.add(new FAQVM("Returns & Refunds"));
        faqvms.add(new FAQVM("Contact Us"));
        faqvms.add(new FAQVM("Troubleshooting"));

        return faqvms;
    }
}
