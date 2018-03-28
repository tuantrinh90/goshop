package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.ProfileResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.widget.SingleChooseVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

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
            new DisposableObserver<ProfileResponse>() {
                @Override
                public void onNext(ProfileResponse profileResponse) {
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
    public List<SingleChooseVM> getLanguageChoose() {
        //todo this is mock data
        List<SingleChooseVM> singleChooseVMS = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            singleChooseVMS.add(new SingleChooseVM("Language " + (i + 1)));
        }
        return singleChooseVMS;
    }

    @Override
    public List<SingleChooseVM> getRaceChoose() {
        //todo this is mock data
        List<SingleChooseVM> singleChooseVMS = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            singleChooseVMS.add(new SingleChooseVM("Race " + (i + 1)));
        }
        return singleChooseVMS;
    }
}
