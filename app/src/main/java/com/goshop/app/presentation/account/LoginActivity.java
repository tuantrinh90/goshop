package com.goshop.app.presentation.account;

import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.utils.JDataUtils;
import com.goshop.app.utils.ScreenHelper;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.orhanobut.logger.Logger;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

/**
 * Created by img on 2018/1/8.
 */

public class LoginActivity extends BaseActivity<LoginContract.Presenter> implements LoginContract.View {
    @BindView(R.id.iv_login_logo)
    ImageView ivLoginLogo;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.iv_clear_mail)
    ImageView ivClearMail;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.iv_clear_password)
    ImageView ivClearPassword;
    @BindView(R.id.iv_visible_password)
    ImageView ivVisiblePassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_forgot_password)
    TextView tvForgotPassword;
    @BindView(R.id.rl_text_or)
    RelativeLayout rlTextOr;
    @BindView(R.id.iv_login_facebook_icon)
    ImageView ivLoginFacebookIcon;
    @BindView(R.id.rl_login_facebook)
    RelativeLayout rlLoginFacebook;
    @BindView(R.id.view_bottom_line)
    View viewBottomLine;
    @BindView(R.id.tv_new_to_shop)
    TextView tvNewToShop;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.text_email)
    TextInputLayout textEmail;
    @BindView(R.id.text_password)
    TextInputLayout textPassword;

    boolean isVisible;
    private CallbackManager facebookCallbackManager;
    @Override
    public int getContentView() {
        return R.layout.account_login;
    }

    @Override
    public String getScreenTitle() {
        return null;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        facebookCallbackManager = mPresenter.initFaceBook();
        initView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        facebookCallbackManager.onActivityResult(requestCode, resultCode, data);
    }


    private void initView() {
        textEmail.setHintAnimationEnabled(true);
        textEmail.setErrorEnabled(true);

        textPassword.setHintAnimationEnabled(true);
        textPassword.setErrorEnabled(true);

        rxEditTextChange(etEmail,ivClearMail);
        rxEditTextChange(etPassword,ivClearPassword);

    }

    private void rxEditTextChange(EditText editText,ImageView deleteView){
        RxTextView.textChanges(editText).subscribe(charSequence -> {
            if (charSequence.length() > 0) {
                deleteView.setVisibility(View.VISIBLE);
                deleteView.setOnClickListener(v -> {
                    editText.setText("");
                    editText.setFocusable(true);
                    editText.requestFocus();
                    deleteView.setVisibility(View.GONE);
                });
                switch (editText.getId()){
                    case R.id.et_email:
                        isEmail();
                        break;
                    case R.id.et_password:
                        isPassword();
                        break;
                }
            } else {
                deleteView.setVisibility(View.GONE);
            }

        });
    }

    private boolean isEmail(){
        if (!JDataUtils.isEmail(etEmail.getText().toString())) {
            textEmail.setError(ScreenHelper.getString(R.string.loginregister_emailbound_tips_error_email_format));
            return false;
        }else {
            textEmail.setError(null);
            return true;
        }
    }

    private boolean isPassword(){
        if (etPassword.getText().toString().length()<=4){
            textPassword.setError(ScreenHelper.getString(R.string.enter_characters_ignored));
            return false;
        }else {
            textPassword.setError(null);
            return true;
        }
    }

    @OnClick({ R.id.iv_visible_password, R.id
        .btn_login, R.id.tv_forgot_password, R.id.rl_login_facebook,R.id.tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_visible_password:
                if (!TextUtils.isEmpty(etPassword.getText().toString().trim())){
                    if (isVisible){
                        isVisible=false;
                        ivVisiblePassword.setBackgroundResource(R.mipmap.ic_password_not_visible);
                        etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }else {
                        isVisible=true;
                        ivVisiblePassword.setBackgroundResource(R.mipmap.ic_password_visible);
                        etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    }
                }
                break;
            case R.id.btn_login:
                if (isEmail() && isPassword()){

                }
                break;
            case R.id.tv_forgot_password:
                break;
            case R.id.rl_login_facebook:
                //facebook sdk code
                LoginManager.getInstance().logInWithReadPermissions(this, Arrays
                    .asList("public_profile", "email", "user_friends"));
                break;
            case R.id.tv_register:
                break;
        }
    }

    @Override
    public void showLogin(UserInfo userInfo) {
        //TODO joyson temp code
        Logger.e("resposne:"+userInfo.getUsername());
    }

    @Override
    public void showNetwordErrorMessage() {

    }

    @Override
    public void showFaildMessage(String errorMessage) {

    }

    @Override
    public void fbLoginError() {
        Toast.makeText(this,ScreenHelper.getString(R.string.FB_Login_tips_error),Toast.LENGTH_SHORT).show();
    }
}
