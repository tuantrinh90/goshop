package com.goshop.app.presentation.account;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.HelpSupportResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.mapper.HelpSupportMapper;
import com.goshop.app.presentation.model.HelpSupportActionVM;
import com.goshop.app.presentation.model.HelpSupportContentVM;
import com.goshop.app.presentation.model.HelpSupportModel;
import com.goshop.app.presentation.model.HelpSupportSectionVM;
import com.goshop.app.presentation.model.HelpSupportTitleVM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class HelpSupportPresenter extends RxPresenter<HelpSupportContract.View> implements
    HelpSupportContract.Presenter {

    AccountRepository accountRepository;

    public HelpSupportPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void helpSupportRequest() {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.REQUEST_PARAM_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.REQUEST_PARAM_STORE_ID, Const.STORE_ID);
        addSubscrebe(accountRepository.helpSupportRequest(params)
            .subscribeWith(new DisposableObserver<Response<HelpSupportResponse>>() {
                @Override
                public void onNext(Response<HelpSupportResponse> helpSupportResponse) {
                    mView.hideLoadingBar();
                    mView.onHelpSupportRequestSuccess(
                        maskData(HelpSupportMapper.transform(helpSupportResponse)));
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    if (throwable instanceof ServiceApiFail) {
                        ServiceApiFail serviceApiFail = (ServiceApiFail) throwable;
                        mView.showServiceErrorMessage(serviceApiFail.getErrorMessage());
                    } else {
                        mView.showNetworkErrorMessage(throwable.getMessage());
                    }
                }

                @Override
                public void onComplete() {
                    mView.hideLoadingBar();
                }
            }));
    }

    private ArrayList<HelpSupportModel> maskData(
        ArrayList<HelpSupportSectionVM> transformResponse) {
        ArrayList<HelpSupportModel> helpSupportModels = new ArrayList<>();
        for (HelpSupportSectionVM helpSupportSectionVM : transformResponse) {
            helpSupportModels.add(new HelpSupportTitleVM(helpSupportSectionVM.getSectionTitle()));
            for (HelpSupportActionVM helpSupportActionVM : helpSupportSectionVM.getActions()) {
                helpSupportModels.add(new HelpSupportContentVM(helpSupportActionVM.getTitle(),
                    helpSupportActionVM.getLink()));
            }
        }
        return helpSupportModels;
    }
}
