package com.goshop.app.presentation.checkout;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.PaymentStatusVM;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class PaymentStatusActivity extends BaseActivity<PaymentStatusContract.Presenter>
    implements PaymentStatusContract.View {

    @BindView(R.id.imageview_left_menu)
    ImageView imageviewLeftMenu;

    @BindView(R.id.ll_status_success_layout)
    LinearLayout llStatusSuccessLayout;

    @BindView(R.id.ll_status_wrong_layout)
    LinearLayout llStatusWrongLayout;

    @BindView(R.id.tv_status_success_order)
    CustomBoldTextView tvStatusSuccessOrder;

    @BindView(R.id.tv_status_wrong_email)
    CustomTextView tvStatusWrongEmail;

    @BindView(R.id.tv_status_wrong_tel)
    CustomTextView tvStatusWrongTel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO(helen) wait for api
        mPresenter.paymentStatusRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_pament_status;
    }

    @Override
    public void inject() {
        imageviewLeftMenu.setVisibility(View.GONE);
        initPresenter();
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.payment_status);
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @OnClick({R.id.imageview_right_menu, R.id.tv_btn_payment_status, R.id
        .tv_btn_status_success_check})
    public void onStatusClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_right_menu:
                finish();
                break;
            case R.id.tv_btn_payment_status:
                //TODO(helen) this is need decide
                break;
            case R.id.tv_btn_status_success_check:
                //TODO(helen) this is need decide
                break;
        }
    }

    @Override
    public void showFailedLayout(PaymentStatusVM paymentStatusVM) {
        llStatusSuccessLayout.setVisibility(View.GONE);
        llStatusWrongLayout.setVisibility(View.VISIBLE);
        tvStatusWrongEmail.setText(paymentStatusVM.getEmail());
        tvStatusWrongTel.setText(paymentStatusVM.getTel());
    }

    @Override
    public void showSuccessLayout(PaymentStatusVM paymentStatusVM) {
        llStatusWrongLayout.setVisibility(View.GONE);
        llStatusSuccessLayout.setVisibility(View.VISIBLE);
        tvStatusSuccessOrder.setText(paymentStatusVM.getOrderId());
    }
}
