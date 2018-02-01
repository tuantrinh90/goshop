package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.ProfileReponse;
import com.goshop.app.domian.AccountRepository;

import java.util.Map;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by helen on 2018/1/26.
 */

public class EditProfilePresenter extends RxPresenter<EditProfileContract.View> implements
    EditProfileContract.Presenter {

    private AccountRepository accountRepository;

    public EditProfilePresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void editProfileRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.editProfileRequest(params).subscribeWith(
            new DisposableObserver<ProfileReponse>() {
                @Override
                public void onNext(ProfileReponse profileReponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    mView.editProfileResult();
                }

                @Override
                public void onComplete() {

                }
            }));
    }
}
