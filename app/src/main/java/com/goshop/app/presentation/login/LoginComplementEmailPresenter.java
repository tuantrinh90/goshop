package com.goshop.app.presentation.login;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.ComplementEmailResponse;
import com.goshop.app.data.model.response.LoginResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.mapper.ProfileMapper;
import com.goshop.app.presentation.model.FacebookLoginVm;
import com.goshop.app.presentation.model.UserDataVM;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class LoginComplementEmailPresenter extends RxPresenter<LoginComplementEmailContract.View>
    implements LoginComplementEmailContract.Presenter {

    AccountRepository accountRepository;

    public LoginComplementEmailPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void facebookLoginRequest(FacebookLoginVm facebookLoginVm) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.PARAMS_EMAIL, facebookLoginVm.getEmali());
        params.put(Const.PARAMS_FB_ID, facebookLoginVm.getId());
        params.put(Const.PARAMS_USER_ACCESS_TOKEN, facebookLoginVm.getToken());
        params.put(Const.PARAMS_NAME, facebookLoginVm.getName());
        params.put(Const.PARAMS_GENDER, facebookLoginVm.getGender());
        addSubscrebe(accountRepository.facebookLoginRequest(params).subscribeWith(
            new DisposableObserver<Response<LoginResponse>>() {
                @Override
                public void onNext(Response<LoginResponse> response) {
                    mView.hideLoadingBar();
                    mView.complementEmailSuccess(
                        ProfileMapper.transformCustomer(response.getData().getCustomer()));

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

    @Override
    public void saveUserInfo(UserDataVM response) {
        addSubscrebe(accountRepository.saveUserInfo(response)
            .subscribeWith(new DisposableObserver<Object>() {
                @Override
                public void onNext(Object response) {
                }

                @Override
                public void onError(Throwable e) {
                }

                @Override
                public void onComplete() {

                }
            }));
    }

}
