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
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.response.LoginResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;

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
    public void getUserLogin(String username, String password) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.getUserInfo(username, password).subscribeWith(
            new DisposableObserver<UserInfo>() {
                @Override
                public void onNext(UserInfo userInfo) {
                    mView.hideLoadingBar();
                    mView.showLogin(userInfo);
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    if (throwable instanceof ServiceApiFail) {
                        mView.showFaildMessage(((ServiceApiFail) throwable).getErrorMessage());
                    } else {
                        mView.showNetwordErrorMessage();
                    }
                }

                @Override
                public void onComplete() {

                }
            }));
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
        mView.showLoadingBar();
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
                    mView.loginSuccess();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showFaildMessage(e.getLocalizedMessage().toString());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void facebookLoginRequest(String email, String fbId, String token, String name,
        String gender) {
        mView.showLoadingBar();

        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.PARAMS_EMAIL, email);
        params.put(Const.PARAMS_FB_ID, fbId);
        params.put(Const.PARAMS_USER_ACCESS_TOKEN, token);
        params.put(Const.PARAMS_NAME, name);
        params.put(Const.PARAMS_GENDER, gender);
        addSubscrebe(accountRepository.facebookLoginRequest(params).subscribeWith(
            new DisposableObserver<Response<LoginResponse>>() {
                @Override
                public void onNext(Response<LoginResponse> response) {
                    mView.hideLoadingBar();
                    mView.loginSuccess();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showFaildMessage(e.getLocalizedMessage().toString());
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
                    String id = object.optString("id");
                    String name = object.optString("name");
                    String gender = object.optString("gender");
                    String emali = object.optString("email");
                    mView.setFacebookLoginParams(emali, id, accessToken.getToken(), name, gender);
                }
            });
        request.executeAsync();
    }
}
