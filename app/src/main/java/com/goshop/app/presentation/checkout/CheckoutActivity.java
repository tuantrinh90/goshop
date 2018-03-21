package com.goshop.app.presentation.checkout;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.adapter.CheckoutListAdapter;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.RobotoLightRadioButton;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularEditText;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.utils.ScreenHelper;
import com.jakewharton.rxbinding2.widget.RxTextView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class CheckoutActivity extends BaseActivity<CheckoutContract.Presenter> implements
    CheckoutContract.View {

    private static final int RADIO_BUTTON_W_AND_H = 25;

    @BindView(R.id.btn_checkout_place_my_order)
    RobotoMediumTextView btnCheckoutPlaceMyOrder;

    @BindView(R.id.et_checkout_discount)
    RobotoRegularEditText etCheckoutDiscount;

    @BindView(R.id.et_checkout_egift)
    RobotoRegularEditText etCheckoutEgift;

    @BindView(R.id.iv_checkout_shipping_more)
    ImageView ivCheckoutShippingMore;

    String paymentType;

    @BindView(R.id.radio_payment_type)
    RadioGroup radioPaymentType;

    @BindView(R.id.rb_checkout_payment_banking)
    RobotoLightRadioButton rbCheckoutPaymentBanking;

    @BindView(R.id.rb_checkout_payment_cash_on_deliery)
    RobotoLightRadioButton rbCheckoutPaymentCashOnDeliery;

    @BindView(R.id.rb_checkout_payment_credit)
    RobotoLightRadioButton rbCheckoutPaymentCredit;

    @BindView(R.id.rl_shipping_root)
    RelativeLayout rlShippingRoot;

    @BindView(R.id.rv_order_list)
    RecyclerView rvOrderList;

    @BindView(R.id.tv_btn_check_discount_apply)
    RobotoMediumTextView tvBtnCheckDiscountApply;

    @BindView(R.id.tv_btn_check_gift_card_apply)
    RobotoMediumTextView tvBtnCheckGiftCardApply;

    @BindView(R.id.tv_btn_check_points_apply)
    RobotoMediumTextView tvBtnCheckPointsApply;

    @BindView(R.id.tv_checkout_address_first)
    RobotoLightTextView tvCheckoutAddressFirst;

    @BindView(R.id.tv_checkout_address_second)
    RobotoLightTextView tvCheckoutAddressSecond;

    @BindView(R.id.tv_checkout_attention)
    RobotoLightTextView tvCheckoutAttention;

    @BindView(R.id.tv_checkout_city_state_code)
    RobotoLightTextView tvCheckoutCityStateCode;

    @BindView(R.id.tv_checkout_country)
    RobotoLightTextView tvCheckoutCountry;

    @BindView(R.id.tv_checkout_shipping_title)
    RobotoMediumTextView tvCheckoutShippingTitle;

    @BindView(R.id.tv_checkout_tel)
    RobotoLightTextView tvCheckoutTel;

    @BindView(R.id.tv_checkout_username)
    RobotoMediumTextView tvCheckoutUsername;

    @Override
    public void showCheckout(CheckoutResponse checkoutResponse) {
        initCheckoutPage(checkoutResponse);
        initRecycler(checkoutResponse);
    }

    @SuppressLint("SetTextI18n")
    private void initCheckoutPage(CheckoutResponse checkoutResponse) {
        tvCheckoutUsername.setText(checkoutResponse.getUserName());
        tvCheckoutAddressFirst.setText(checkoutResponse.getFirstAddress());
        tvCheckoutAddressSecond.setText(checkoutResponse.getSecondAddress());
        tvCheckoutCityStateCode
            .setText(checkoutResponse.getCity() + "," + checkoutResponse.getPostcode());
        tvCheckoutCountry.setText(checkoutResponse.getCountry());
        tvCheckoutTel.setText(checkoutResponse.getTel());
        radioPaymentType.check(R.id.rb_checkout_payment_banking);
        radioPaymentType.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_checkout_payment_banking:
                    paymentType = rbCheckoutPaymentBanking.getText().toString();
                    break;
                case R.id.rb_checkout_payment_credit:
                    paymentType = rbCheckoutPaymentCredit.getText().toString();
                    break;
                case R.id.rb_checkout_payment_cash_on_deliery:
                    paymentType = rbCheckoutPaymentCashOnDeliery.getText().toString();
                    break;
                default:
                    paymentType = rbCheckoutPaymentBanking.getText().toString();
                    break;
            }
        });
    }

    private void initRecycler(CheckoutResponse response) {
        rvOrderList.setLayoutManager(new LinearLayoutManager(this));
        rvOrderList.setNestedScrollingEnabled(false);
        rvOrderList.setAdapter(new CheckoutListAdapter(response.getCheckoutItems()));
    }

    @Override
    public void showNetwordErrorMessage() {
        //TODO wait for api
    }

    @Override
    public void showFaildMessage(String errorMessage) {
        //TODO wait for api
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.getCheckout("");
    }

    @Override
    public int getContentView() {
        return R.layout.activity_checkout;
    }

    @Override
    public void inject() {
        hideRightMenu();
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
        initRadioGroup();
        initAboutEditText();
    }

    private void initRadioGroup() {
        rbCheckoutPaymentCredit.setSelected(true);
        radioPaymentType.setOnCheckedChangeListener((RadioGroup group, int checkedId) -> {
            switch (checkedId) {
                case R.id.rb_checkout_payment_banking:
                    break;
                case R.id.rb_checkout_payment_cash_on_deliery:
                    break;
                case R.id.rb_checkout_payment_credit:
                    break;

            }
        });
    }

    private void initAboutEditText() {

        RxTextView.textChanges(etCheckoutDiscount).subscribe(charSequence -> {
            if (charSequence.length() > 0) {
                if(!tvBtnCheckDiscountApply.getText().equals(getResources().getString(R.string.cancel))) {
                    tvBtnCheckDiscountApply.setText(getResources().getString(R.string.cancel));
                    tvBtnCheckDiscountApply.setBackgroundResource(R.drawable.drawable_round_cancel);
                }
            } else {
                tvBtnCheckDiscountApply.setText(getResources().getString(R.string.apply));
                tvBtnCheckDiscountApply.setBackgroundResource(R.drawable.drawable_round_black);
            }
        });

        tvBtnCheckDiscountApply.setOnClickListener(v -> {
            if (etCheckoutDiscount.getText().toString().length() > 0) {
                etCheckoutDiscount.setText("");
            }
        });

        RxTextView.textChanges(etCheckoutEgift).subscribe(charSequence -> {
            if (charSequence.length() > 0) {
                if(!tvBtnCheckGiftCardApply.getText().equals(getResources().getString(R.string.cancel))) {
                    tvBtnCheckGiftCardApply.setText(getResources().getString(R.string.cancel));
                    tvBtnCheckGiftCardApply.setBackgroundResource(R.drawable.drawable_round_cancel);
                }
            } else {
                tvBtnCheckGiftCardApply.setText(getResources().getString(R.string.apply));
                tvBtnCheckGiftCardApply.setBackgroundResource(R.drawable.drawable_round_black);
            }
        });

        tvBtnCheckGiftCardApply.setOnClickListener(v -> {
            if (etCheckoutEgift.getText().toString().length() > 0) {
                etCheckoutEgift.setText("");
            }
        });
    }

    @Override
    public String getScreenTitle() {
        return ScreenHelper.getString(R.string.checkout_title);
    }

    @OnClick({R.id.rl_shipping_root, R.id.btn_checkout_place_my_order, R.id.imageview_left_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_shipping_root:
                startActivity(new Intent(this, CheckoutSelectAddressActivity.class));
                break;
            case R.id.btn_checkout_place_my_order:
                startActivity(new Intent(this, CheckoutPaymentActivity.class));
                break;
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }
}
