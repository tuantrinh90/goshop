package com.goshop.app.presentation.checkout;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.adapter.CheckoutListAdapter;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.dialogs.CustomAlertDialog;
import com.goshop.app.common.view.RobotoLightCheckBox;
import com.goshop.app.common.view.RobotoLightRadioButton;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumEditText;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularEditText;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.presentation.model.ApplyDiscountVM;
import com.goshop.app.presentation.model.ApplyEGiftVM;
import com.goshop.app.presentation.model.ApplyPointsVM;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.utils.ScreenHelper;
import com.jakewharton.rxbinding2.widget.RxTextView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class CheckoutActivity extends BaseActivity<CheckoutContract.Presenter> implements
    CheckoutContract.View {

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

    @BindView(R.id.tv_checkout_installment)
    RobotoRegularTextView tvCheckoutInstallment;

    @BindView(R.id.fl_connection_break)
    FrameLayout flConnectionBreak;

    @BindView(R.id.et_checkout_point)
    RobotoMediumEditText etCheckoutPoint;

    @BindView(R.id.cb_checkout_use_same)
    RobotoLightCheckBox cbCheckoutUseSame;

    @BindView(R.id.rl_billing_root)
    RelativeLayout rlBillingRoot;

    public static final  String type_shipping = "shipping";

    public static final  String type_billing = "billing";

    public static final String TYPE = "type";

    private static final String TAG = "CheckoutActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.getCheckout("");
        cbCheckoutUseSame.setChecked(true);
        cbCheckoutUseSame.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked)->{
            rlBillingRoot.setVisibility(isChecked ?View.GONE:View.VISIBLE);
        });
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
        String pointsTip = String
            .format(getResources().getString(R.string.checkout_points_tip), "300");
        tvCheckoutAttention.setText(Html.fromHtml(pointsTip));
    }

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
    }

    private void initRecycler(CheckoutResponse response) {
        rvOrderList.setLayoutManager(new LinearLayoutManager(this));
        rvOrderList.setNestedScrollingEnabled(false);
        rvOrderList.setAdapter(new CheckoutListAdapter(response.getCheckoutItems()));
    }

    @Override
    public void showNetwordErrorMessage() {
        updateLayoutStatus(flConnectionBreak, true);
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(btnCheckoutPlaceMyOrder, errorMessage);
    }

    @Override
    public void applyCouponSuccess(ApplyDiscountVM discountVM) {
        if(tvBtnCheckDiscountApply.isSelected()) {
            tvBtnCheckDiscountApply.setSelected(false);
            tvBtnCheckDiscountApply.setText(getResources().getString(R.string.cancel));
            etCheckoutDiscount.setText(discountVM.getDiscount());
        } else {
            tvBtnCheckDiscountApply.setSelected(true);
            tvBtnCheckDiscountApply.setText(getResources().getString(R.string.apply));
        }

    }

    @Override
    public void applyPointsSuccess(ApplyPointsVM pointsVM) {
        if(tvBtnCheckPointsApply.isSelected()) {
            tvBtnCheckPointsApply.setSelected(false);
            tvBtnCheckPointsApply.setText(getResources().getString(R.string.cancel));
            etCheckoutPoint.setText(pointsVM.getPointsApplied());
        } else {
            tvBtnCheckPointsApply.setSelected(true);
            tvBtnCheckPointsApply.setText(getResources().getString(R.string.apply));
        }
    }

    @Override
    public void applyEGiftSuccess(ApplyEGiftVM eGiftVM) {
        if(tvBtnCheckGiftCardApply.isSelected()) {
            tvBtnCheckGiftCardApply.setSelected(false);
            tvBtnCheckGiftCardApply.setText(getResources().getString(R.string.cancel));
            etCheckoutEgift.setText(eGiftVM.geteGiftApplied());
        } else {
            tvBtnCheckGiftCardApply.setSelected(true);
            tvBtnCheckGiftCardApply.setText(getResources().getString(R.string.apply));
        }
    }

    @Override
    public void showPaymentProgress() {
        CustomAlertDialog customAlertDialog = CustomAlertDialog
            .getInstance();
        customAlertDialog.show(getSupportFragmentManager(),TAG);
    }

    private void initRadioGroup() {
        rbCheckoutPaymentCredit.setSelected(true);
        radioPaymentType.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_checkout_payment_banking:
                    paymentType = rbCheckoutPaymentBanking.getText().toString();
                    tvCheckoutInstallment.setVisibility(View.GONE);
                    break;
                case R.id.rb_checkout_payment_credit:
                    paymentType = rbCheckoutPaymentCredit.getText().toString();
                    tvCheckoutInstallment.setVisibility(View.VISIBLE);
                    break;
                case R.id.rb_checkout_payment_cash_on_deliery:
                    paymentType = rbCheckoutPaymentCashOnDeliery.getText().toString();
                    tvCheckoutInstallment.setVisibility(View.GONE);
                    break;
                default:
                    paymentType = rbCheckoutPaymentBanking.getText().toString();
                    tvCheckoutInstallment.setVisibility(View.GONE);
                    break;
            }
        });
    }

    @Override
    public String getScreenTitle() {
        return ScreenHelper.getString(R.string.checkout_title);
    }


    @OnClick({R.id.rl_shipping_root, R.id.btn_checkout_place_my_order,
        R.id.imageview_left_menu, R.id.tv_net_refresh, R.id.tv_btn_check_discount_apply,
        R.id.tv_btn_check_gift_card_apply, R.id.tv_btn_check_points_apply, R.id.rl_billing_root})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_shipping_root:
                Intent shippingIntent = new Intent(this, CheckoutSelectAddressActivity.class);
                shippingIntent.putExtra(TYPE, type_shipping);
                startActivity(shippingIntent);
                break;
            case R.id.btn_checkout_place_my_order:
                //todo this part need decide
                mPresenter.paymentRequest();
//                startActivity(new Intent(this, CheckoutPaymentActivity.class));
                break;
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.tv_net_refresh:
                updateLayoutStatus(flConnectionBreak, false);
                mPresenter.getCheckout("");
                break;
            case R.id.tv_btn_check_discount_apply:
                KeyBoardUtils.hideKeyboard(this);
                String discount = etCheckoutDiscount.getText().toString();
                if (TextUtils.isEmpty(discount)) {
                    Toast.makeText(this, getResources().getString(R.string.empty_error),
                        Toast.LENGTH_SHORT).show();
                } else {
                    mPresenter.applyCoupon(discount, "");
                }
                break;
            case R.id.tv_btn_check_gift_card_apply:
                KeyBoardUtils.hideKeyboard(this);
                String card = etCheckoutEgift.getText().toString();
                if (TextUtils.isEmpty(card)) {
                    Toast.makeText(this, getResources().getString(R.string.empty_error),
                        Toast.LENGTH_SHORT).show();
                } else {
                    mPresenter.applyEGiftCard(card, "");
                }
                break;
            case R.id.tv_btn_check_points_apply:
                KeyBoardUtils.hideKeyboard(this);
                String points = etCheckoutPoint.getText().toString();
                if (TextUtils.isEmpty(points)) {
                    Toast.makeText(this, getResources().getString(R.string.empty_error),
                        Toast.LENGTH_SHORT).show();
                } else {
                    mPresenter.applyPoints(points, "");
                }
                break;
            case R.id.rl_billing_root:
                Intent billingIntent = new Intent(this, CheckoutSelectAddressActivity.class);
                billingIntent.putExtra(TYPE, type_billing);
                startActivity(billingIntent);
                break;
        }
    }
}
