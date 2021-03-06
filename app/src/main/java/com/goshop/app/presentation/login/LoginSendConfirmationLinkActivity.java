package com.goshop.app.presentation.login;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.utils.EditTextUtil;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.ToastUtil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginSendConfirmationLinkActivity extends
    BaseActivity<LoginSendConfirmationLinkContract.Presenter> implements
    LoginSendConfirmationLinkContract.View, ToastUtil.OnToastListener {

    @BindView(R.id.ctd_et_confirmation_link)
    CustomAnimEditText ctdEtConfirmationLink;

    @BindView(R.id.tv_btn_send_confirmation_link_submit)
    RobotoRegularTextView tvBtnSendConfirmationLinkSubmit;

    private ToastUtil toastUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_login_send_confirmation_link;
    }

    @Override
    public void inject() {
        hideRightMenu();
        initPresenter();
        toastUtil = new ToastUtil(this, this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.send_confirmation_link);
    }

    private void initPresenter() {
        initPresenterComponent().inject(this);
    }

    @Override
    public void sendConfirmationLinkSuccess() {
        showToast();
    }

    private void showToast() {
        toastUtil.showLinkToast();
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_btn_send_confirmation_link_submit})
    public void onSendConfirmationLinkClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                KeyBoardUtils.hideKeyboard(this);
                if (toastUtil != null) {
                    toastUtil.cancelToast();
                }
                finish();
                break;
            case R.id.tv_btn_send_confirmation_link_submit:
                EditTextUtil.eidtLoseFocus(tvBtnSendConfirmationLinkSubmit);
                String email = ctdEtConfirmationLink.getText();
                if (!TextUtils.isEmpty(email)) {
                    //TODO(helen) wait for api
                    mPresenter.sendConfirmationLinkRequest(null);
                }

                break;
        }
    }

    @Override
    public void onToastCancel() {
        finish();
    }


}
