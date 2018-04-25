package com.goshop.app.presentation.checkout;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;

public class CheckoutAddNewAddressActivity extends BaseActivity {

    @BindView(R.id.et_new_address_name)
    CustomAnimEditText etNewAddressName;

    @BindView(R.id.et_new_address_one)
    CustomAnimEditText etNewAddressOne;

    @BindView(R.id.et_new_address_phone)
    CustomAnimEditText etNewAddressPhone;

    @BindView(R.id.et_new_address_two)
    CustomAnimEditText etNewAddressTwo;

    @BindView(R.id.et_new_address_zip)
    CustomAnimEditText etNewAddressZip;

    @BindView(R.id.textview_right_menu)
    RobotoMediumTextView textviewRightMenu;

    @BindView(R.id.tv_new_address_city)
    RobotoRegularTextView tvNewAddressCity;

    @BindView(R.id.tv_new_address_country)
    RobotoRegularTextView tvNewAddressCountry;

    @BindView(R.id.tv_new_address_state)
    RobotoRegularTextView tvNewAddressState;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_checkout_add_new_address;
    }

    @Override
    public void inject() {
        hideRightMenu();
        textviewRightMenu.setText(getResources().getString(R.string.done));
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.add_new_address);
    }

    @OnClick({R.id.imageview_left_menu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }
}
