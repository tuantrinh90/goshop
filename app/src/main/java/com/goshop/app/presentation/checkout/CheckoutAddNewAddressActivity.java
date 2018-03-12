package com.goshop.app.presentation.checkout;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.BindView;

public class CheckoutAddNewAddressActivity extends BaseActivity {

    @BindView(R.id.et_new_address_first)
    CustomAnimEditText etNewAddressFirst;

    @BindView(R.id.et_new_address_last)
    CustomAnimEditText etNewAddressLast;

    @BindView(R.id.et_new_address_one)
    CustomAnimEditText etNewAddressOne;

    @BindView(R.id.et_new_address_phone)
    CustomAnimEditText etNewAddressPhone;

    @BindView(R.id.et_new_address_two)
    CustomAnimEditText etNewAddressTwo;

    @BindView(R.id.et_new_address_zip)
    CustomAnimEditText etNewAddressZip;

    @BindView(R.id.textview_right_menu)
    CustomBoldTextView textviewRightMenu;

    @BindView(R.id.tv_new_address_city)
    CustomTextView tvNewAddressCity;

    @BindView(R.id.tv_new_address_country)
    CustomTextView tvNewAddressCountry;

    @BindView(R.id.tv_new_address_state)
    CustomTextView tvNewAddressState;

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
        textviewRightMenu.setText(getResources().getString(R.string.save));
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.add_new_address);
    }
}
