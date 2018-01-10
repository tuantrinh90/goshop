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

public class LoginComplementEmailActivity extends BaseActivity<LoginComplementEmailContract
    .Presenter> implements
    LoginComplementEmailContract.View, ToastUtil.OnToastListener {

    @BindView(R.id.btn_complement_email_submit)
    CustomBoldButton btnComplementEmailSubmit;

    @BindView(R.id.et_complement_email_email)
    CustomEditText etComplementEmailEmail;

    @BindView(R.id.iv_send_email_delete)
    ImageView ivSendEmailDelete;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_complement_email_email)
    CustomTextView tvComplementEmailEmail;

    private ToastUtil toastUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_login_complement_email;
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.complement_email);
    }

    @Override
    public void inject() {
        hideRightMenu();
        //TODO(helen):this is wait for design
        toolbar.setBackgroundColor(getResources().getColor(R.color.pinkishGrey));
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
        EditTextUtil.deleteImageShowListener(etComplementEmailEmail, ivSendEmailDelete);
        EditTextUtil.emailFoucsChangedListener(etComplementEmailEmail, tvComplementEmailEmail);
    }

    @OnClick({R.id.imageview_left_menu, R.id.btn_complement_email_submit})
    public void onComplementEmailClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                KeyBoardUtils.hideKeyboard(this);
                if (toastUtil != null) {
                    toastUtil.cancelToast();
                }
                finish();
                break;
            case R.id.btn_complement_email_submit:
                EditTextUtil.eidtLoseFocus(btnComplementEmailSubmit);
                String email = etComplementEmailEmail.getText().toString();
                //TODO(helen)wait for api
                //mPresenter.complementEmailRequest(null);

                break;
        }
    }

    @Override
    public void onToastCancel() {
        finish();
    }

    @Override
    public void complementEmailSuccess() {
        showToast();
    }

    private void showToast() {
        Toast toast = Toast.makeText(this, "Thanks for registering on GO SHOP", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toastUtil = ToastUtil.getInstance(this, this, toast);
        toastUtil.showToastCustomTime(3000);
    }

    @Override
    public void showErrorMessage() {

    }

    @Override
    public void hideErrorMessage() {

    }
}
