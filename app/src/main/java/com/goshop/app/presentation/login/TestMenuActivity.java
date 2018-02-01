package com.goshop.app.presentation.login;

import com.crashlytics.android.Crashlytics;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.account.ChangePasswordActivity;
import com.goshop.app.presentation.account.ContactUsActivity;
import com.goshop.app.presentation.account.EditProfileActivity;
import com.goshop.app.presentation.account.FAQActivity;
import com.goshop.app.presentation.account.HelpSupportActivity;
import com.goshop.app.presentation.account.MyAddressBookActivity;
import com.goshop.app.presentation.account.TermsConditionsActivity;
import com.goshop.app.presentation.account.WebContentActivity;
import com.goshop.app.presentation.search.SearchActivity;
import com.goshop.app.presentation.search.SearchResultActivity;
import com.goshop.app.presentation.shopping.ProductDetailActivity;
import com.goshop.app.presentation.shopping.ShoppingCartActivity;

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
    public String getScreenTitle() {
        return null;
    }

    @Override
    public void inject() {

    }

    @OnClick({R.id.btn_test_register, R.id.btn_test_complement_email, R.id
        .btn_test_forgot_password, R.id.btn_test_send_confirmation_link, R.id.btn_test_changepwd,
        R.id.btn_test_editprofile, R.id.btn_test_pdp, R.id.btn_test_my_address, R.id
        .btn_test_search, R.id.btn_test_search_result, R.id.btn_test_cart, R.id.btn_test_contact_us,
        R.id.btn_test_help, R.id.btn_test_faq, R.id.btn_test_ecmc, R.id.btn_test_term})
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
            case R.id.btn_test_pdp:
                startActivity(new Intent(this, ProductDetailActivity.class));
                break;
            case R.id.btn_test_search:
                startActivity(new Intent(this, SearchActivity.class));
                break;
            case R.id.btn_test_search_result:
                startActivity(new Intent(this, SearchResultActivity.class));
                break;
            case R.id.btn_test_changepwd:
                startActivity(new Intent(this, ChangePasswordActivity.class));
                break;
            case R.id.btn_test_editprofile:
                startActivity(new Intent(this, EditProfileActivity.class));
                break;
            case R.id.btn_test_my_address:
                startActivity(new Intent(this, MyAddressBookActivity.class));
                break;
            case R.id.btn_test_cart:
                startActivity(new Intent(this, ShoppingCartActivity.class));
                break;
            case R.id.btn_test_contact_us:
                startActivity(new Intent(this, ContactUsActivity.class));
                break;

            case R.id.btn_test_help:
                startActivity(new Intent(this, HelpSupportActivity.class));
                break;
            case R.id.btn_test_faq:
                startActivity(new Intent(this, FAQActivity.class));
                break;
            case R.id.btn_test_ecmc:
                startActivity(new Intent(this, WebContentActivity.class));
                break;
            case R.id.btn_test_term:
                startActivity(new Intent(this, TermsConditionsActivity.class));
                break;
        }
    }


}
