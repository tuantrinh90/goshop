package com.goshop.app.presentation.myorder;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;

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

    @OnClick({R.id.imageview_left_menu})
    public void onCancelOrderClick(View view){
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }


}
