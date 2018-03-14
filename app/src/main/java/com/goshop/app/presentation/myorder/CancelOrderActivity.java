package com.goshop.app.presentation.myorder;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.BindView;

public class CancelOrderActivity extends BaseActivity {

    @BindView(R.id.et_cancel_order_email)
    CustomAnimEditText etCancelOrderEmail;

    @BindView(R.id.et_cancel_order_handing)
    CustomAnimEditText etCancelOrderHanding;

    @BindView(R.id.et_cancel_order_mobile)
    CustomAnimEditText etCancelOrderMobile;

    @BindView(R.id.et_cancel_order_name)
    CustomAnimEditText etCancelOrderName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_cancel_order;
    }

    @Override
    public void inject() {
        hideRightMenu();
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.order_cancellation_form);
    }


}
