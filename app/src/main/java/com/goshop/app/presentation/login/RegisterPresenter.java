package com.goshop.app.presentation.login;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.widget.SingleChooseVM;

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
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put("website_id", Const.WEBSITE_ID);
        params.put("store_id", Const.STORE_ID);
        params.put("name", name);
        params.put("email", email);
        params.put("password", password);
        params.put("title", title);
        params.put("gender", gender);
        params.put("dob", birth);
        params.put("mobile_number", mobile);
        params.put("language", language);
        params.put("email_subscribe", sendEmail);
        params.put("sms_subscribe", sendSMS);
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
