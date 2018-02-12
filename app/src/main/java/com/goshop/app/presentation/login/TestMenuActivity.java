package com.goshop.app.presentation.login;

import com.crashlytics.android.Crashlytics;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.account.EditProfileActivity;
import com.goshop.app.presentation.account.LoginActivity;
import com.goshop.app.presentation.account.MyAddressBookActivity;
import com.goshop.app.presentation.account.MyPointsActivity;
import com.goshop.app.presentation.checkout.CheckoutSelectAddressActivity;
import com.goshop.app.presentation.checkout.PaymentStatusActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.OnClick;
import io.fabric.sdk.android.Fabric;

/**
 * Created by helen on 2018/1/10.
 */
//todo(helen) this activity will delete when merge code
public class TestMenuActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
    }

    @Override
    public int getContentView() {

        return R.layout.activity_test_menu;
    }

    @Override
    public void inject() {
        hideRightMenu();
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.other_page);
    }

    @OnClick({R.id.btn_test_login, R.id.imageview_left_menu, R.id.btn_test_complement_email, R.id
        .btn_test_send_confirmation_link,
        R.id.btn_test_editprofile, R.id.btn_test_my_address, R.id.btn_test_my_points, R.id.btn_test_select_address, R.id.btn_test_paymentstatus})
    public void onMenuClick(View view) {
        switch (view.getId()) {
            case R.id.btn_test_login:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.btn_test_complement_email:
                startActivity(new Intent(this, LoginComplementEmailActivity.class));
                break;
            case R.id.btn_test_send_confirmation_link:
                startActivity(new Intent(this, LoginSendConfirmationLinkActivity.class));
                break;
            case R.id.btn_test_editprofile:
                startActivity(new Intent(this, EditProfileActivity.class));
                break;
            case R.id.btn_test_my_address:
                startActivity(new Intent(this, MyAddressBookActivity.class));
                break;
            case R.id.btn_test_my_points:
                startActivity(new Intent(this, MyPointsActivity.class));
                break;
            case R.id.btn_test_select_address:
                startActivity(new Intent(this, CheckoutSelectAddressActivity.class));
                break;
            case R.id.btn_test_paymentstatus:
                startActivity(new Intent(this, PaymentStatusActivity.class));
                break;

        }
    }


}
