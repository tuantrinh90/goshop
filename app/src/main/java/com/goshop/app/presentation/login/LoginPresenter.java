package com.goshop.app.presentation.login;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.LoginResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.FacebookLoginVm;

import org.json.JSONObject;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class LoginPresenter extends RxPresenter<LoginContract.View> implements LoginContract
    .Presenter {

    private AccountRepository accountRepository;

    private CallbackManager facebookCallbackManager;

    public LoginPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public CallbackManager initFaceBook() {
        facebookCallbackManager = CallbackManager.Factory.create();
        FacebookCallback<LoginResult> facebookCallback = new FacebookCallback<LoginResult>() {
            private ProfileTracker mProfileTracker;

            @Override
            public void onSuccess(final LoginResult loginResult) {
                Profile facebookProfile = Profile.getCurrentProfile();
                if (facebookProfile == null || TextUtils.isEmpty(facebookProfile.getId())) {
                    mProfileTracker = new ProfileTracker() {
                        @Override
                        protected void onCurrentProfileChanged(Profile profile, Profile profile2) {
                            if (profile2 == null || TextUtils.isEmpty(profile2.getId())) {
                                mView.fbLoginError();
                                return;
                            }
                            if (loginResult.getAccessToken() != null) {
                                getFacebookAccessToken(loginResult.getAccessToken());
                            }
                            mProfileTracker.stopTracking();
                        }
                    };
                    mProfileTracker.startTracking();
                } else {
                    getFacebookAccessToken(loginResult.getAccessToken());
                }
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException error) {
                try {
                    if (error instanceof FacebookAuthorizationException) {
                        if (AccessToken.getCurrentAccessToken() != null) {
                            LoginManager.getInstance().logOut();
                        }
                    }
                } catch (Exception ex) {
                    ex.getStackTrace();
                }
                mView.fbLoginError();
            }
        };
        LoginManager.getInstance().registerCallback(facebookCallbackManager, facebookCallback);
        return facebookCallbackManager;
    }

    @Override
    public void loginRequest(String email, String password) {
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.PARAMS_EMAIL, email);
        params.put(Const.PARAMS_PASSWORD, password);
        addSubscrebe(accountRepository.loginRequest(params)
            .subscribeWith(new DisposableObserver<Response<LoginResponse>>() {
                @Override
                public void onNext(Response<LoginResponse> response) {
                    mView.hideLoadingBar();
                    mView.loginSuccess(response);
                    saveUserInfo(response);
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

    private void saveUserInfo(Response<LoginResponse> response) {
        addSubscrebe(accountRepository.saveUserInfo(response.getData().getCustomer())
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

    @Override
    public void getFacebookAccessToken(AccessToken accessToken) {
        GraphRequest request = GraphRequest
            .newMeRequest(accessToken, (JSONObject object, GraphResponse response) -> {
                if (object != null) {
                    FacebookLoginVm facebookLoginVm = new FacebookLoginVm();
                    facebookLoginVm.setId(object.optString("id"));
                    facebookLoginVm.setName(object.optString("name"));
                    facebookLoginVm.setEmali(object.optString("email"));
                    facebookLoginVm.setGender(object.optString("gender"));
                    facebookLoginVm.setToken(accessToken.getToken());
                    facebookLoginRequest(facebookLoginVm);
                }
            });
        request.executeAsync();
    }

    private void facebookLoginRequest(FacebookLoginVm facebookLoginVm) {
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
                    if (response != null && response.getData() != null && response.getData()
                        .getCustomer() != null && TextUtils
                        .isEmpty(response.getData().getCustomer().getEmail())) {
                        mView.loginSuccess(response);
                        saveUserInfo(response);
                    } else {
                        mView.setFacebookLoginParams(facebookLoginVm);
                    }
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showServiceErrorMessage(e.getLocalizedMessage().toString());
                }

                @Override
                public void onComplete() {
                    mView.hideLoadingBar();
                }
            }));
    }
}
