package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.HelpSupportResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.HelpSupportContentVM;
import com.goshop.app.presentation.model.HelpSupportModel;
import com.goshop.app.presentation.model.HelpSupportTitleVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class HelpSupportPresenter extends RxPresenter<HelpSupportContract.View> implements
    HelpSupportContract.Presenter {

    AccountRepository accountRepository;

    public HelpSupportPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void helpSupportRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.helpSupportRequest(params).subscribeWith(
            new DisposableObserver<HelpSupportResponse>() {
                @Override
                public void onNext(HelpSupportResponse helpSupportResponse) {
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
    private List<HelpSupportModel> getMockData() {
        List<HelpSupportModel> helpSupportModels = new ArrayList<>();
        helpSupportModels.add(new HelpSupportTitleVM("Help Center"));
        helpSupportModels.add(new HelpSupportContentVM("FAQ", () -> mView.startFAQ()));
        helpSupportModels.add(new HelpSupportContentVM("Online Support"));
        helpSupportModels.add(new HelpSupportContentVM("Notice"));
        helpSupportModels.add(new HelpSupportContentVM("Terms and Conditions",
            () -> mView.startTermsAndConditions()));
        helpSupportModels.add(new HelpSupportContentVM("Privacy Policy"));

        helpSupportModels.add(new HelpSupportTitleVM("Services"));
        helpSupportModels.add(new HelpSupportContentVM("Customer Service"));
        helpSupportModels.add(new HelpSupportContentVM("Shipping & Returns"));
        helpSupportModels.add(new HelpSupportContentVM("Delivery Information"));

        helpSupportModels.add(new HelpSupportTitleVM("Company"));
        helpSupportModels.add(new HelpSupportContentVM("Overview & Vision"));
        helpSupportModels.add(new HelpSupportContentVM("Careers"));
        helpSupportModels.add(new HelpSupportContentVM("Contact Us", () -> mView.startContactUs()));
        helpSupportModels.add(new HelpSupportContentVM("Sell on Go Shop"));

        return helpSupportModels;
    }
}
