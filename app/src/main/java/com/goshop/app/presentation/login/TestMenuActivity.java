package com.goshop.app.presentation.login;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;

import android.content.Intent;
import android.view.View;

import butterknife.OnClick;

/**
 * Created by helen on 2018/1/10.
 */
//todo(helen) this activity will delete when merge code
public class TestMenuActivity extends BaseActivity {

    @Override
    public int getContentView() {
        return R.layout.activity_test_menu;
    }

    @Override
    public String getScreenTitle() {
        return null;
    }

    @Override
    public void inject() {

    }

    @OnClick({R.id.btn_test_register, R.id.btn_test_complement_email, R.id
        .btn_test_forgot_password, R.id.btn_test_send_confirmation_link})
    public void onMenuClick(View view) {
        switch (view.getId()) {
            case R.id.btn_test_register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.btn_test_complement_email:
                startActivity(new Intent(this, LoginComplementEmailActivity.class));
                break;
            case R.id.btn_test_forgot_password:
                startActivity(new Intent(this, LoginResetPasswordActivity.class));
                break;
            case R.id.btn_test_send_confirmation_link:
                startActivity(new Intent(this, LoginSendConfirmationLinkActivity.class));
                break;
        }
    }


}
