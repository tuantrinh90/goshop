package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomPasswordEditText;
import com.goshop.app.common.view.CustomTextView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

/**
 * Created by helen on 2018/1/26.
 */

public class ChangePasswordActivity extends BaseActivity<ChangePasswordContract.Presenter>
    implements ChangePasswordContract.View {

    @BindView(R.id.cp_et_confirm)
    CustomPasswordEditText cpEtConfirm;

    @BindView(R.id.cp_et_current)
    CustomPasswordEditText cpEtCurrent;

    @BindView(R.id.cp_et_new)
    CustomPasswordEditText cpEtNew;

    @BindView(R.id.tv_btn_layout_pink)
    CustomTextView tvBtnLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_change_password;
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.change_password);
    }

    @Override
    public void inject() {
        hideRightMenu();
        initPresenter();
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_btn_layout_pink})
    public void onChangeClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.tv_btn_layout_pink:
                judgmentPassword(cpEtCurrent.getText(), cpEtNew.getText(), cpEtConfirm.getText());
                break;
        }
    }

    private void judgmentPassword(String currentPassword, String newPassword,
        String confirmPassword) {
        if (TextUtils.isEmpty(currentPassword)) {
            cpEtCurrent.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        if (TextUtils.isEmpty(newPassword)) {
            cpEtNew.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        if (TextUtils.isEmpty(confirmPassword)) {
            cpEtConfirm.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        if (!newPassword.equals(confirmPassword)) {
            cpEtConfirm.setErrorMessage(getResources().getString(R.string.confirm_error));
        } else {
            //todo(helen)wait for api
            mPresenter.changePasswordRequest(null);
        }
    }

    @Override
    public void changeResult() {
        finish();
    }
}
