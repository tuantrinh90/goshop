package com.goshop.app.presentation.login;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.data.model.response.LoginResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.presentation.home.MainPageActivity;
import com.goshop.app.presentation.model.FacebookLoginVm;
import com.goshop.app.utils.EditTextUtil;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.utils.ToastUtil;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class LoginComplementEmailActivity extends BaseActivity<LoginComplementEmailContract
    .Presenter> implements
    LoginComplementEmailContract.View, ToastUtil.OnToastListener {

    public static final String EXTRA_FACEBOOK_INFO = "facebookInfo";

    @BindView(R.id.ctd_et_complement_email)
    CustomAnimEditText ctdEtComplementEmail;

    @BindView(R.id.ll_container)
    LinearLayout llContainer;

    @BindView(R.id.tv_btn_complement_email_submit)
    RobotoMediumTextView tvBtnComplementEmailSubmit;

    private ToastUtil toastUtil;

    private FacebookLoginVm facebookLoginVm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        if (getIntent() != null && getIntent().getParcelableExtra(EXTRA_FACEBOOK_INFO) != null) {
            facebookLoginVm = getIntent().getParcelableExtra(EXTRA_FACEBOOK_INFO);
        }
    }

    private void initView() {
        hideRightMenu();
        toastUtil = new ToastUtil(this, this);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_login_complement_email;
    }

    @Override
    public void inject() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.whoops_email);
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_btn_complement_email_submit})
    public void onComplementEmailClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                KeyBoardUtils.hideKeyboard(this);
                if (toastUtil != null) {
                    toastUtil.cancelToast();
                }
                finish();
                break;
            case R.id.tv_btn_complement_email_submit:
                EditTextUtil.eidtLoseFocus(tvBtnComplementEmailSubmit);
                String email = ctdEtComplementEmail.getText();
                if (!TextUtils.isEmpty(email)) {
                    facebookLoginVm.setEmali(email);
                    mPresenter.facebookLoginRequest(facebookLoginVm);
                }
                break;
        }
    }

    @Override
    public void onToastCancel() {
        goToHomePage();
    }

    private void goToHomePage() {
        Intent intent = new Intent(this, MainPageActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void complementEmailSuccess(Response<LoginResponse> response) {
        if (response != null && response.getData() != null && response.getData()
            .getCustomer() != null && response.getData().getCustomer().getToken() != null) {
            GoShopApplication.setLogin(true);
            GoShopApplication.cacheUserInfo(response.getData().getCustomer());
            toastUtil.showThanksToast();

        }
    }

    @Override
    public void showServiceErrorMessage(String message) {
        PopWindowUtil.showRequestMessagePop(llContainer, message);
    }

    @Override
    public void showNetworkErrorMessage(String message) {
        PopWindowUtil.showRequestMessagePop(llContainer, message);
    }

}
