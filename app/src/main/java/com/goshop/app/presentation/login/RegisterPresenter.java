package com.goshop.app.presentation.login;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.ProfileMetaVM;

import java.util.ArrayList;
import java.util.HashMap;
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
    public void registerRequest(String name, String email, String password, String title,
        String gender, String birth, String mobile, String language, boolean sendEmail,
        boolean sendSMS) {
        Map<String, Object> params = new HashMap<>();
        params.put(Const.REQUEST_PARAM_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.REQUEST_PARAM_STORE_ID, Const.STORE_ID);
        params.put(Const.REQUEST_PARAM_NAME, name);
        params.put(Const.REQUEST_PARAM_EMAIL, email);
        params.put(Const.REQUEST_PARAM_PASSWORD, password);
        params.put(Const.REQUEST_PARAM_TITLE, title);
        params.put(Const.REQUEST_PARAM_GENDER, gender);
        params.put(Const.REQUEST_PARAM_DOB, birth);
        params.put(Const.REQUEST_PARAM_MOBILE_NUMBER, mobile);
        params.put(Const.REQUEST_PARAM_LANGUAGE, language);
        params.put(Const.REQUEST_PARAM_EMAIL_SUBSCRIBE, sendEmail);
        params.put(Const.REQUEST_PARAM_SMS_SUBSCRIBE, sendSMS);
        addSubscrebe(accountRepository.registerRequest(params).subscribeWith(
            new DisposableObserver<Response>() {
                @Override
                public void onNext(Response response) {
                    mView.hideLoadingBar();
                    mView.registerSuccess();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    if (throwable instanceof ServiceApiFail) {
                        ServiceApiFail serviceApiFail = (ServiceApiFail) throwable;
                        mView.showServiceErrorMessage(serviceApiFail.getErrorMessage());
                    } else {
                        mView.showNetworkErrorMessage(throwable.getLocalizedMessage().toString());
                    }
                }

                @Override
                public void onComplete() {
                    mView.hideLoadingBar();
                }
            }));
    }

    @Override
    public List<ProfileMetaVM> getTitleChooses() {
        //todo this is mock data
        List<ProfileMetaVM> profileMetaVMS = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            profileMetaVMS.add(new ProfileMetaVM("Title " + (i + 1)));
        }
        return profileMetaVMS;
    }

    @Override
    public List<ProfileMetaVM> getLanguageChooses() {
        //todo this is mock data
        List<ProfileMetaVM> profileMetaVMS = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            profileMetaVMS.add(new ProfileMetaVM("Languages " + (i + 1)));
        }
        return profileMetaVMS;
    }

}
