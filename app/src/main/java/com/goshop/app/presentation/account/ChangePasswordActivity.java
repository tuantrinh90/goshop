package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomPasswordEditText;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.utils.KeyBoardUtils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class ChangePasswordActivity extends BaseActivity<ChangePasswordContract.Presenter>
    implements ChangePasswordContract.View {

    @BindView(R.id.cp_et_confirm)
    CustomPasswordEditText cpEtConfirm;

    @BindView(R.id.cp_et_current)
    CustomPasswordEditText cpEtCurrent;

    @BindView(R.id.cp_et_new)
    CustomPasswordEditText cpEtNew;

    @BindView(R.id.textview_right_menu)
    RobotoMediumTextView textviewRightMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_change_password;
    }

    @Override
    public void inject() {
        textviewRightMenu.setText(getResources().getString(R.string.save));
        hideRightMenu();
        initPresenter();
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.change_password);
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @OnClick({R.id.imageview_left_menu, R.id.textview_right_menu})
    public void onChangeClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.textview_right_menu:
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
            return;
        }
        KeyBoardUtils.hideKeyboard(this);
        Map<String, Object> params = new HashMap<>();
        params.put("website_id", "");
        params.put("store_id", "");
        params.put("customer_id", "");
        params.put("old_password", currentPassword);
        params.put("new_password", newPassword);
        mPresenter.changePasswordRequest(params);
    }

    @Override
    public void success() {
        finish();
    }

    @Override
    public void failed(String message) {
        //todo wait for design
        Log.d("ChangePasswordActivity", message);
    }
}
