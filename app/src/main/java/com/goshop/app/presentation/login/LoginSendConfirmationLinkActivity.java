package com.goshop.app.presentation.login;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomBoldButton;
import com.goshop.app.common.view.CustomEditText;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.utils.EditTextUtil;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.ToastUtil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

/**
 * Created by helen on 2018/1/9.
 */

public class LoginSendConfirmationLinkActivity extends
    BaseActivity<LoginSendConfirmationLinkContract.Presenter> implements
    LoginSendConfirmationLinkContract.View, ToastUtil.OnToastListener {

    @BindView(R.id.btn_send_confirmation_link_submit)
    CustomBoldButton btnSendConfirmationLinkSubmit;

    @BindView(R.id.et_send_confirmation_link_email)
    CustomEditText etSendConfirmationLinkEmail;

    @BindView(R.id.iv_send_email_delete)
    ImageView ivSendEmailDelete;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_send_link_email)
    CustomTextView tvSendLinkEmail;

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
    public String getScreenTitle() {
        return getResources().getString(R.string.send_confirmation_link);
    }

    @Override
    public void inject() {
        //TODO(helen):this is wait for design
        toolbar.setBackgroundColor(getResources().getColor(R.color.pinkishGrey));
        hideRightMenu();
        initPresenter();
        editActionListener();
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void editActionListener() {
        EditTextUtil.deleteImageShowListener(etSendConfirmationLinkEmail, ivSendEmailDelete);
        EditTextUtil.emailFoucsChangedListener(etSendConfirmationLinkEmail, tvSendLinkEmail);
    }

    @Override
    public void sendConfirmationLinkSuccess() {
        showToast();
    }

    private void showToast() {
        //todo(helen) wait for design then will replase this hard code
        Toast toast = Toast.makeText(this, "Thanks for registering on GO SHOP", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toastUtil = ToastUtil.getInstance(this, this, toast);
        toastUtil.showToastCustomTime(ToastUtil.SHOW_TIME);
    }

    @OnClick({R.id.imageview_left_menu, R.id.btn_send_confirmation_link_submit})
    public void onSendConfirmationLinkClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                KeyBoardUtils.hideKeyboard(this);
                if (toastUtil != null) {
                    toastUtil.cancelToast();
                }
                finish();
                break;
            case R.id.btn_send_confirmation_link_submit:
                EditTextUtil.eidtLoseFocus(btnSendConfirmationLinkSubmit);
                String email = etSendConfirmationLinkEmail.getText().toString();
                //TODO(helen) wait for api
                //mPresenter.sendConfirmationLinkRequest(null);
                break;
        }
    }

    @Override
    public void onToastCancel() {
        finish();
    }


}
