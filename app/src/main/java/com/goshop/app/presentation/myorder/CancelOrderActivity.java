package com.goshop.app.presentation.myorder;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.CustomAnimSpinner;
import com.goshop.app.common.view.CustomTextView;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.BindView;
import butterknife.OnClick;

public class CancelOrderActivity extends BaseActivity {

    @BindView(R.id.et_cancel_detail_reason)
    CustomAnimSpinner etCancelDetailReason;

    @BindView(R.id.et_cancel_order_email)
    CustomAnimEditText etCancelOrderEmail;

    @BindView(R.id.et_cancel_order_handing)
    CustomAnimEditText etCancelOrderHanding;

    @BindView(R.id.et_cancel_order_mobile)
    CustomAnimEditText etCancelOrderMobile;

    @BindView(R.id.et_cancel_order_name)
    CustomAnimEditText etCancelOrderName;

    @BindView(R.id.et_cancel_reason)
    CustomAnimSpinner etCancelReason;

    @BindView(R.id.tv_btn_rewards_detail_download)
    CustomTextView tvBtnRewardsDetailDownload;

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
