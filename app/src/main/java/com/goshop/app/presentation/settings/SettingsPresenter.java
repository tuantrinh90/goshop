package com.goshop.app.presentation.settings;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.GetSettingsResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.SettingsModel;
import com.goshop.app.presentation.model.SettingsSingleDetailVM;
import com.goshop.app.presentation.model.SettingsSwitchVM;
import com.goshop.app.presentation.model.SettingsTitleVM;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class SettingsPresenter extends RxPresenter<SettingsContract.View> implements
    SettingsContract.Presenter {

    AccountRepository accountRepository;

    public SettingsPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void getSettingsDetail() {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.getSettingsDetail().subscribeWith(
            new DisposableObserver<GetSettingsResponse>() {
                @Override
                public void onNext(GetSettingsResponse getSettingsResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    mView.showSettingView(getMockDatas());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //todo(helen) this is mock data
    private List<SettingsModel> getMockDatas() {
        List<SettingsModel> settingsModels = new ArrayList<>();
        settingsModels.add(new SettingsTitleVM("Newsletter Subscription"));
        settingsModels.add(new SettingsSwitchVM("I wish to receive shopping news via email."));
        settingsModels.add(new SettingsSwitchVM("I wish to receive shopping news via SMS."));
        settingsModels.add(new SettingsSwitchVM("Subscription to Points Expiring Notification."));
        settingsModels.add(new SettingsSwitchVM("SMS Marketing Consent."));

        settingsModels.add(new SettingsTitleVM("Account"));
        settingsModels.add(
            new SettingsSingleDetailVM("Change Password", () -> mView.startChangePasswordScreen()));
        settingsModels.add(new SettingsSingleDetailVM("Logout"));

        return settingsModels;
    }
}
