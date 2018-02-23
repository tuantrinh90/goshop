package com.goshop.app.presentation.checkout;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.view.CustomTextView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;

public class CheckoutEditAddressActivity extends BaseActivity {

    @BindView(R.id.et_checkout_address_first)
    CustomAnimEditText etCheckoutAddressFirst;

    @BindView(R.id.et_checkout_address_last)
    CustomAnimEditText etCheckoutAddressLast;

    @BindView(R.id.et_checkout_address_one)
    CustomAnimEditText etCheckoutAddressOne;

    @BindView(R.id.et_checkout_address_phone)
    CustomAnimEditText etCheckoutAddressPhone;

    @BindView(R.id.et_checkout_address_two)
    CustomAnimEditText etCheckoutAddressTwo;

    @BindView(R.id.et_checkout_address_zip)
    CustomAnimEditText etCheckoutAddressZip;

    @BindView(R.id.textview_right_menu)
    CustomTextView textviewRightMenu;

    @BindView(R.id.tv_checkout_address_city)
    CustomTextView tvCheckoutAddressCity;

    @BindView(R.id.tv_checkout_address_country)
    CustomTextView tvCheckoutAddressCountry;

    @BindView(R.id.tv_checkout_address_state)
    CustomTextView tvCheckoutAddressState;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_checkout_edit_address;
    }

    @Override
    public void inject() {
        hideRightMenu();
        textviewRightMenu.setText(getResources().getString(R.string.save));
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.edit_address);
    }

    @OnClick({R.id.imageview_left_menu, R.id.textview_right_menu})
    public void onEditClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.textview_right_menu:
                //TODO(helen) this is need decide
                break;
        }
    }
}
