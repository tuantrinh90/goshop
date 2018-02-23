package com.goshop.app.presentation.account;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;

import android.text.TextUtils;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;



public class LoginPresenter extends RxPresenter<LoginContract.View> implements LoginContract.Presenter {
    AccountRepository accountRepository;
    private CallbackManager facebookCallbackManager;
    @Inject
    public LoginPresenter(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public void getUserLogin(String username, String password) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.getUserInfo(username,password).subscribeWith(
            new DisposableObserver<UserInfo>() {
                @Override
                public void onNext(UserInfo userInfo) {
                    mView.hideLoadingBar();
                    mView.showLogin(userInfo);
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    if(throwable instanceof ServiceApiFail){
                        mView.showFaildMessage(((ServiceApiFail) throwable).getErrorMessage());
                    }else{
                        mView.showNetwordErrorMessage();
                    }
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void thirdLogin(String platform, String accessToken) {

    }

    //TODO facebook sdk code
    @Override
    public CallbackManager initFaceBook(){
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
                            if(loginResult.getAccessToken()!=null) {
                                thirdLogin("facebook", loginResult.getAccessToken().getToken());
                            }
                            mProfileTracker.stopTracking();
                        }
                    };
                    mProfileTracker.startTracking();
                }else{
                    thirdLogin("facebook", loginResult.getAccessToken().getToken());
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
                }catch(Exception ex){
                    ex.getStackTrace();
                }
                mView.fbLoginError();
            }
        };
        LoginManager.getInstance().registerCallback(facebookCallbackManager, facebookCallback);
        return facebookCallbackManager;
    }
}
