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
import com.goshop.app.presentation.model.ApplyDiscountVM;
import com.goshop.app.presentation.model.ApplyEGiftVM;
import com.goshop.app.presentation.model.ApplyPointsVM;
import com.goshop.app.presentation.model.CheckoutVM;
import com.goshop.app.presentation.model.PaymentVM;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.PopWindowUtil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

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

    @BindView(R.id.iv_checkout_billing_shipping_more)
    ImageView ivCheckoutBillingShippingMore;

    @BindView(R.id.iv_checkout_shipping_more)
    ImageView ivCheckoutShippingMore;

    @BindView(R.id.ll_checkout_discount)
    LinearLayout llCheckoutDiscount;

    @BindView(R.id.ll_checkout_toolbar)
    LinearLayout llCheckoutToolbar;

    @BindView(R.id.ll_shipping_top)
    LinearLayout llShippingTop;

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

    @BindView(R.id.recyclerview_checkout)
    RecyclerView recyclerView;

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

    @BindView(R.id.tv_checkout_billing_address_first)
    RobotoLightTextView tvCheckoutBillingAddressFirst;

    @BindView(R.id.tv_checkout_billing_address_second)
    RobotoLightTextView tvCheckoutBillingAddressSecond;

    @BindView(R.id.tv_checkout_billing_city_state_code)
    RobotoLightTextView tvCheckoutBillingCityStateCode;

    @BindView(R.id.tv_checkout_billing_country)
    RobotoLightTextView tvCheckoutBillingCountry;

    @BindView(R.id.tv_checkout_billing_shipping)
    RobotoLightTextView tvCheckoutBillingShipping;

    @BindView(R.id.tv_checkout_billing_tel)
    RobotoLightTextView tvCheckoutBillingTel;

    @BindView(R.id.tv_checkout_billing_total)
    RobotoMediumTextView tvCheckoutBillingTotal;

    @BindView(R.id.tv_checkout_billing_username)
    RobotoMediumTextView tvCheckoutBillingUsername;

    @BindView(R.id.tv_checkout_city_state_code)
    RobotoLightTextView tvCheckoutCityStateCode;

    @BindView(R.id.tv_checkout_country)
    RobotoLightTextView tvCheckoutCountry;

    @BindView(R.id.tv_checkout_discount_amount)
    RobotoLightTextView tvCheckoutDiscountAmount;

    @BindView(R.id.tv_checkout_discount_code)
    RobotoLightTextView tvCheckoutDiscountCode;

    @BindView(R.id.tv_checkout_egift_amount)
    RobotoLightTextView tvCheckoutEgiftAmount;

    @BindView(R.id.tv_checkout_egift_code)
    RobotoLightTextView tvCheckoutEgiftCode;

    @BindView(R.id.tv_checkout_sub_total)
    RobotoLightTextView tvCheckoutSubTotal;

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

    @BindView(R.id.fl_content)
    FrameLayout flContent;

    public static final String type_shipping = "shipping";

    public static final String type_billing = "billing";

    public static final String TYPE = "type";

    private static final String TAG = "CheckoutActivity";

    @BindView(R.id.tv_net)
    RobotoRegularTextView tvNet;

    @BindView(R.id.tv_net_refresh)
    RobotoRegularTextView tvNetRefresh;

    private CheckoutListAdapter productListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo wait for api
        mPresenter.checkoutRequest("", "");
    }

    @Override
    public int getContentView() {
        return R.layout.activity_checkout;
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.checkout_title);
    }

    @Override
    public void inject() {
        hideRightMenu();
        initPresenter();
        initRadioGroup();
        initBilling();
        intRecyclerView();
    }

    private void intRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productListAdapter = new CheckoutListAdapter(new ArrayList<>());
        recyclerView.setAdapter(productListAdapter);
    }

    private void initBilling() {
        String pointsTip = String
            .format(getResources().getString(R.string.checkout_points_tip), "300");
        tvCheckoutAttention.setText(Html.fromHtml(pointsTip));
        cbCheckoutUseSame.setChecked(true);
        cbCheckoutUseSame
            .setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
                rlBillingRoot.setVisibility(isChecked ? View.GONE : View.VISIBLE);
            });
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
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
        if (tvBtnCheckDiscountApply.isSelected()) {
            tvBtnCheckDiscountApply.setSelected(false);
            tvBtnCheckDiscountApply.setText(getResources().getString(R.string.apply));
            etCheckoutDiscount.setText(discountVM.getDiscount());
        } else {
            tvBtnCheckDiscountApply.setSelected(true);
            tvBtnCheckDiscountApply.setText(getResources().getString(R.string.cancel));
        }

    }

    @Override
    public void applyPointsSuccess(ApplyPointsVM pointsVM) {
        if (tvBtnCheckPointsApply.isSelected()) {
            tvBtnCheckPointsApply.setSelected(false);
            tvBtnCheckPointsApply.setText(getResources().getString(R.string.apply));
            etCheckoutPoint.setText(pointsVM.getPointsApplied());
        } else {
            tvBtnCheckPointsApply.setSelected(true);
            tvBtnCheckPointsApply.setText(getResources().getString(R.string.cancel));
        }
    }

    @Override
    public void applyEGiftSuccess(ApplyEGiftVM eGiftVM) {
        if (tvBtnCheckGiftCardApply.isSelected()) {
            tvBtnCheckGiftCardApply.setSelected(false);
            tvBtnCheckGiftCardApply.setText(getResources().getString(R.string.apply));
            etCheckoutEgift.setText(eGiftVM.geteGiftApplied());
        } else {
            tvBtnCheckGiftCardApply.setSelected(true);
            tvBtnCheckGiftCardApply.setText(getResources().getString(R.string.cancel));
        }
    }

    @Override
    public void showPaymentProgress() {
        CustomAlertDialog customAlertDialog = CustomAlertDialog
            .getInstance();
        customAlertDialog.show(getSupportFragmentManager(), TAG);
    }

    @Override
    public void checkoutRequestSuccess(CheckoutVM checkoutVM) {
        updateLayoutStatus(flContent, true);
        updateShippingAddress(checkoutVM.getShippingUserName(), checkoutVM.getShippingAddressOne()
            , checkoutVM.getShippingAddressTwo(), checkoutVM.getShippingCityStatePost(),
            checkoutVM.getShippingCountry(), checkoutVM.getShippingTel());
        updateBillingAddress(checkoutVM.getBillingUserName(), checkoutVM.getBillingAddressOne(),
            checkoutVM.getBillingAddressTwo(),
            checkoutVM.getBillingCityStatePost(), checkoutVM.getBillingCountry(),
            checkoutVM.getBillingTel());
        productListAdapter.setProductVMS(checkoutVM.getProductVMS());
        updateBilling(checkoutVM.getSubTotal(), checkoutVM.getShipping(),
            checkoutVM.getDiscountCode(),
            checkoutVM.getDiscountAmount(), checkoutVM.geteGiftCode(), checkoutVM.geteGiftAmount(),
            checkoutVM.getBillingTotal());
    }

    @Override
    public void placeOrderSuccess(PaymentVM paymentVM) {
        finish();
    }

    private void updateBilling(String sub, String shipping, String discountCode,
        String discountAmount, String eGiftCode, String eGiftAmount,
        String total) {
        tvCheckoutSubTotal.setText(sub);
        tvCheckoutBillingShipping.setText(shipping);
        tvCheckoutDiscountCode.setText(discountCode);
        tvCheckoutDiscountAmount.setText(discountAmount);
        tvCheckoutEgiftCode.setText(eGiftCode);
        tvCheckoutEgiftAmount.setText(eGiftAmount);
        tvCheckoutBillingTotal.setText(total);
    }

    private void updateBillingAddress(String username, String first, String second, String place,
        String country, String tel) {
        tvCheckoutBillingUsername.setText(username);
        tvCheckoutBillingAddressFirst.setText(first);
        tvCheckoutBillingAddressSecond.setText(second);
        tvCheckoutBillingCityStateCode.setText(place);
        tvCheckoutBillingCountry.setText(country);
        tvCheckoutBillingTel.setText(tel);
    }

    private void updateShippingAddress(String username, String first, String second, String place,
        String country, String tel) {
        tvCheckoutUsername.setText(username);
        tvCheckoutAddressFirst.setText(first);
        tvCheckoutAddressSecond.setText(second);
        tvCheckoutCityStateCode.setText(place);
        tvCheckoutCountry.setText(country);
        tvCheckoutTel.setText(tel);
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
                mPresenter.paymentRequest("", "", "", "");
                break;
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.tv_net_refresh:
                updateLayoutStatus(flConnectionBreak, false);
                //todo wait for api
                mPresenter.checkoutRequest("", "");
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
