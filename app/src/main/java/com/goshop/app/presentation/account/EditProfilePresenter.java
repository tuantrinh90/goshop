package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.ProfileResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.mapper.ProfileMapper;
import com.goshop.app.presentation.model.widget.SingleChooseVM;

import java.util.ArrayList;
import java.util.HashMap;
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
    public void editProfileRequest(String name, String email, String title, String gender,
        String birth, String mobile, String language) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put("website_id", "");
        params.put("store_id", "");
        params.put("name", name);
        params.put("email", email);
        params.put("title", title);
        params.put("gender", gender);
        params.put("dob", birth);
        params.put("mobile_number", mobile);
        params.put("language", language);

        addSubscrebe(accountRepository.editProfileRequest(params).subscribeWith(
            new DisposableObserver<Response<ProfileResponse>>() {
                @Override
                public void onNext(Response<ProfileResponse> response) {
                    mView.hideLoadingBar();
                    mView.editProfileSuccess();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    mView.editProfileFailed(throwable.getLocalizedMessage().toString());
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

    @Override
    public void getUserProfile() {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.getUserProfile().subscribeWith(
            new DisposableObserver<Response<ProfileResponse>>() {
                @Override
                public void onNext(Response<ProfileResponse> response) {
                    mView.hideLoadingBar();
                    mView.setProfileVM(ProfileMapper.transform(response));
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();

                }

                @Override
                public void onComplete() {

                }
            }));
    }
}
