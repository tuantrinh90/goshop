package com.goshop.app.presentation.checkout;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.OnClick;

public class CheckoutPaymentActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_checkout_payment;
    }

    @Override
    public void inject() {

    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.payment);
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_btn_checkout_payment})
    public void onPaymentClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.tv_btn_checkout_payment:
                break;
        }
    }
}
