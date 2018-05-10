package com.goshop.app.presentation.account;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomPasswordEditText;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.utils.EncryptPasswordHandler;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.PasswordEncoderUtil;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.utils.UserHelper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.OnClick;

public class ChangePasswordActivity extends BaseActivity<ChangePasswordContract.Presenter>
    implements ChangePasswordContract.View, EncryptPasswordHandler.OnPasswordEncryptListener {

    @BindView(R.id.ll_container)
    LinearLayout llContainer;

    @BindView(R.id.cp_et_current)
    CustomPasswordEditText cpEtCurrent;

    @BindView(R.id.cp_et_new)
    CustomPasswordEditText cpEtNew;

    @BindView(R.id.textview_right_menu)
    RobotoMediumTextView textviewRightMenu;

    private String oldPassword;

    private String newPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        textviewRightMenu.setText(getResources().getString(R.string.done));
        hideRightMenu();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_change_password;
    }

    @Override
    public void inject() {
        initPresenterComponent().inject(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.change_password);
    }

    @OnClick({R.id.imageview_left_menu, R.id.textview_right_menu})
    public void onChangeClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.textview_right_menu:
                oldPassword = cpEtCurrent.getText();
                newPassword = cpEtNew.getText();
                judgmentPassword();
                break;
        }
    }

    private void judgmentPassword() {
        if (TextUtils.isEmpty(oldPassword)) {
            cpEtCurrent.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        if (TextUtils.isEmpty(newPassword)) {
            cpEtNew.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        KeyBoardUtils.hideKeyboard(this);
        showLoadingBar();
        PasswordEncoderUtil
            .getEncryptPasswords(new EncryptPasswordHandler(this), oldPassword, newPassword);
    }

    @Override
    public void onPasswordEncrypted(String password) {
        String old = password.substring(0, password.indexOf("/"));
        String news = password.substring(password.indexOf("/") + 1);
        mPresenter.changePasswordRequest(UserHelper.getUserId(), old, news);
    }

    @Override
    public void onChangePasswordSuccess() {
        finish();
    }

    @Override
    public void showServiceErrorMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(llContainer, errorMessage);
    }

    @Override
    public void showNetworkErrorMessage(String message) {
        PopWindowUtil.showRequestMessagePop(llContainer, message);
    }
}
