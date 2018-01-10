package com.goshop.app.presentation.account;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomButtomLineRelativeLayout;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.Weather;
import com.goshop.app.data.model.response.GetUserResponse;
import com.goshop.app.presentation.home.HomeContract;
import com.goshop.app.utils.JDataUtils;
import com.goshop.app.utils.ScreenHelper;
import com.orhanobut.logger.Logger;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

/**
 * Created by img on 2018/1/8.
 */

public class LoginActivity extends BaseActivity<LoginContract.Presenter> implements LoginContract.View,View.OnFocusChangeListener {
    @BindView(R.id.iv_login_logo)
    ImageView ivLoginLogo;
    @BindView(R.id.tv_email_text2)
    TextView tvEmailText2;
    @BindView(R.id.tv_email_text)
    TextView tvEmailText;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.iv_clear_mail)
    ImageView ivClearMail;
    @BindView(R.id.rl_login_email)
    CustomButtomLineRelativeLayout rlLoginEmail;
    @BindView(R.id.tv_password_text2)
    TextView tvPasswordText2;
    @BindView(R.id.tv_password_text)
    TextView tvPasswordText;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.iv_clear_password)
    ImageView ivClearPassword;
    @BindView(R.id.iv_visible_password)
    ImageView ivVisiblePassword;
    @BindView(R.id.rl_login_password)
    CustomButtomLineRelativeLayout rlLoginPassword;
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
        textEmail.setHint(ScreenHelper.getString(R.string.login_email));
        textEmail.setHintAnimationEnabled(true);
        textEmail.setErrorEnabled(true);
        textEmail.getEditText().addTextChangedListener(new MyTextWatcher(etEmail));

        etEmail.setOnFocusChangeListener(this);
        etPassword.setOnFocusChangeListener(this);
        etEmail.setInputType(EditorInfo.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()!=0 && etEmail.isFocusable()){
                    ivClearMail.setVisibility(View.VISIBLE);
                }else {
                    ivClearMail.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0 && etPassword.isFocused()) {
                    ivClearPassword.setVisibility(View.VISIBLE);
                } else {
                    ivClearPassword.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private class MyTextWatcher implements TextWatcher{
        private View view;

        public MyTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            switch (view.getId()){
                case R.id.et_email:
                    if (!JDataUtils.isEmail(etEmail.getText().toString())) {
                        tvEmailText2.setText(ScreenHelper.getString(R.string.loginregister_emailbound_tips_error_email_format));
                        tvEmailText2.setTextColor(ScreenHelper.getColor(R.color.redC2060A));
                    }
                    break;
                case R.id.et_password:
                    break;
            }
        }
    }

    private boolean isEmail(){

    }

    private boolean isPassword(){

    }

    @OnClick({R.id.iv_clear_mail, R.id.iv_clear_password, R.id.iv_visible_password, R.id
        .btn_login, R.id.tv_forgot_password, R.id.rl_login_facebook,R.id.tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_clear_mail:
                etEmail.setText("");
                break;
            case R.id.iv_clear_password:
                etPassword.setText("");
                break;
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
                break;
            case R.id.tv_forgot_password:
                break;
            case R.id.rl_login_facebook:
                LoginManager.getInstance().logInWithReadPermissions(this, Arrays
                    .asList("public_profile", "email", "user_friends"));
                break;
            case R.id.tv_register:
                break;
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus){
            AnimationSet animationSet = upAnim();
            switch (v.getId()){
                case R.id.et_email:
                    tvEmailText2.setText(ScreenHelper.getString(R.string.login_email));
                    rlLoginEmail.setBottomLineActive(true);
                    if (etEmail.getText().length()!=0){
                        ivClearMail.setVisibility(View.VISIBLE);
                    }else {
                        ivClearMail.setVisibility(View.INVISIBLE);
                    }
                    if (TextUtils.isEmpty(etEmail.getText().toString().trim())){
                        tvEmailText2.setVisibility(View.INVISIBLE);
                        etEmail.setHint("");
                        tvEmailText.startAnimation(animationSet);
                    }else {
                        tvEmailText2.setTextColor(ScreenHelper.getColor(R.color.colorAccent));
                    }
                    break;
                case R.id.et_password:
                    rlLoginPassword.setBottomLineActive(true);
                    tvPasswordText.setText(ScreenHelper.getString(R.string.login_password));
                    if (etPassword.getText().length()!=0){
                        ivClearPassword.setVisibility(View.VISIBLE);
                    }else {
                        ivClearPassword.setVisibility(View.INVISIBLE);
                    }
                    if (TextUtils.isEmpty(etPassword.getText().toString().trim())){
                        tvPasswordText2.setVisibility(View.INVISIBLE);
                        tvPasswordText.setHint("");
                        tvPasswordText.startAnimation(animationSet);
                    }else {
                        tvPasswordText2.setTextColor(ScreenHelper.getColor(R.color.colorAccent));
                    }
                    break;
            }
        }else {
            onBlur(v.getId());
            ivClearMail.setVisibility(View.INVISIBLE);
            ivClearPassword.setVisibility(View.INVISIBLE);
        }
    }


    private boolean onBlur(int id){
        switch (id){
            case R.id.et_email:
                rlLoginEmail.setBottomLineActive(false);
                tvEmailText2.setTextColor(ScreenHelper.getColor(R.color.label_saved));
                tvEmailText2.setVisibility(View.VISIBLE);
                if (TextUtils.isEmpty(etEmail.getText().toString().trim())){
                    etEmail.setHint(ScreenHelper.getString(R.string.login_email));
                    tvEmailText.clearAnimation();
                    tvEmailText2.setText(ScreenHelper.getString(R.string.required_field));
                    tvEmailText2.setTextColor(ScreenHelper.getColor(R.color.redC2060A));
                    return false;
                }else {
                    tvEmailText.clearAnimation();
                    if (!JDataUtils.isEmail(etEmail.getText().toString())) {
                        tvEmailText2.setText(ScreenHelper.getString(R.string.loginregister_emailbound_tips_error_email_format));
                        tvEmailText2.setTextColor(ScreenHelper.getColor(R.color.redC2060A));
                        return false;
                    }
                }
                break;
            case R.id.et_password:
                rlLoginPassword.setBottomLineActive(false);
                tvPasswordText2.setTextColor(ScreenHelper.getColor(R.color.label_saved));
                tvPasswordText2.setVisibility(View.VISIBLE);
                if (TextUtils.isEmpty(etPassword.getText().toString().trim())){
                    etPassword.setHint(ScreenHelper.getString(R.string.login_email));
                    tvPasswordText.clearAnimation();
                    tvPasswordText2.setText(ScreenHelper.getString(R.string.required_field));
                    tvPasswordText2.setTextColor(ScreenHelper.getColor(R.color.redC2060A));
                    return false;
                }else {
                    tvPasswordText.clearAnimation();
                    if (!JDataUtils.isEmail(etPassword.getText().toString())) {
                        tvPasswordText2.setText(ScreenHelper.getString(R.string.enter_characters_ignored));
                        tvPasswordText2.setTextColor(ScreenHelper.getColor(R.color.redC2060A));
                        return false;
                    }
                }
                break;
        }
        return true;
    }

    private AnimationSet upAnim() {
        AnimationSet set = new AnimationSet(true);
        set.setFillAfter(true);
        //上移高度应该为自身的高度
        int textHeight=tvEmailText.getHeight();
        Animation tran;
        if(textHeight>0){
            tran = new TranslateAnimation(0, 0, 0, 0-textHeight);
        }else {
            tran = new TranslateAnimation(0, 0, 0, -50);
        }
        tran.setDuration(300);
        //渐变
        Animation alpha = new AlphaAnimation(0, 1);
        alpha.setDuration(300);
        set.addAnimation(tran);
        set.addAnimation(alpha);
        return set;
    }

    @Override
    public void showLogin(UserInfo userInfo) {
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
