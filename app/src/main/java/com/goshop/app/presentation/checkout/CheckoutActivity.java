package com.goshop.app.presentation.checkout;

import com.goshop.app.R;
import com.goshop.app.adapter.CheckoutListAdapter;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.dialogs.CustomAlertDialog;
import com.goshop.app.common.view.RobotoLightCheckBox;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumEditText;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularEditText;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.AddressVM;
import com.goshop.app.presentation.model.ApplyDiscountVM;
import com.goshop.app.presentation.model.ApplyEGiftVM;
import com.goshop.app.presentation.model.ApplyPointsVM;
import com.goshop.app.presentation.model.BillingVM;
import com.goshop.app.presentation.model.CheckoutVM;
import com.goshop.app.presentation.model.PaymentMethodVM;
import com.goshop.app.presentation.model.PaymentVM;
import com.goshop.app.presentation.model.ProfileMetaVM;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.NumberFormater;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.utils.TextFormater;

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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class CheckoutActivity extends BaseActivity<CheckoutContract.Presenter> implements
    CheckoutContract.View, PopWindowUtil.OnPopWindowDismissListener, CheckoutPaymentAdapter
    .PaymentSelectListener {

    public static final String type_shipping = "shipping";

    public static final String type_billing = "billing";

    public static final String TYPE = "type";

    private static final String TAG = "CheckoutActivity";

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

    @BindView(R.id.ll_checkout_toolbar)
    LinearLayout llCheckoutToolbar;

    @BindView(R.id.ll_shipping_top)
    LinearLayout llShippingTop;

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

    @BindView(R.id.tv_checkout_billing_tel)
    RobotoLightTextView tvCheckoutBillingTel;

    @BindView(R.id.tv_checkout_billing_username)
    RobotoMediumTextView tvCheckoutBillingUsername;

    @BindView(R.id.tv_checkout_city_state_code)
    RobotoLightTextView tvCheckoutCityStateCode;

    @BindView(R.id.tv_checkout_country)
    RobotoLightTextView tvCheckoutCountry;

    @BindView(R.id.tv_checkout_tel)
    RobotoLightTextView tvCheckoutTel;

    @BindView(R.id.tv_checkout_username)
    RobotoMediumTextView tvCheckoutUsername;

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

    @BindView(R.id.tv_net)
    RobotoRegularTextView tvNet;

    @BindView(R.id.tv_net_refresh)
    RobotoRegularTextView tvNetRefresh;

    @BindView(R.id.recyclerview_checkout_payment)
    RecyclerView recyclerviewCheckoutPayment;

    @BindView(R.id.tv_billing_subtotal_amount)
    RobotoLightTextView tvBillingSubtotalAmount;

    @BindView(R.id.ll_billing_subtotal)
    LinearLayout llBillingSubtotal;

    @BindView(R.id.tv_billing_shipping_amount)
    RobotoLightTextView tvBillingShippingAmount;

    @BindView(R.id.ll_billing_shipping)
    LinearLayout llBillingShipping;

    @BindView(R.id.tv_billing_discount_code)
    RobotoLightTextView tvBillingDiscountCode;

    @BindView(R.id.tv_billing_discount_amount)
    RobotoLightTextView tvBillingDiscountAmount;

    @BindView(R.id.ll_billing_discount)
    LinearLayout llBillingDiscount;

    @BindView(R.id.tv_billing_egift_code)
    RobotoLightTextView tvBillingEgiftCode;

    @BindView(R.id.tv_billing_egift_amount)
    RobotoLightTextView tvBillingEgiftAmount;

    @BindView(R.id.tv_billing_points_code)
    RobotoLightTextView tvBillingPointsCode;

    @BindView(R.id.ll_billing_egift)
    LinearLayout llBillingEgift;

    @BindView(R.id.tv_billing_points_amount)
    RobotoLightTextView tvBillingPointsAmount;

    @BindView(R.id.ll_billing_points)
    LinearLayout llBillingPoints;

    @BindView(R.id.tv_billing_total)
    RobotoMediumTextView tvBillingTotal;

    @BindView(R.id.ll_billing_total)
    LinearLayout llBillingTotal;

    private CheckoutListAdapter productListAdapter;

    private List<ProfileMetaVM> months;

    private CheckoutPaymentAdapter paymentAdapter;

    private OnPaymentListListener onPaymentListListener;

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
        months = new ArrayList<>();
        hideRightMenu();
        initPresenter();
        initBilling();
        intRecyclerView();
        initPaymentRecyclerView();
    }

    private void initPaymentRecyclerView() {
        recyclerviewCheckoutPayment.setLayoutManager(new LinearLayoutManager(this));
        paymentAdapter = new CheckoutPaymentAdapter(new ArrayList<>());
        recyclerviewCheckoutPayment.setAdapter(paymentAdapter);
        paymentAdapter.setPaymentSelectListener(this);
    }

    private void intRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productListAdapter = new CheckoutListAdapter(new ArrayList<>());
        recyclerView.setAdapter(productListAdapter);
    }

    private void initBilling() {
        cbCheckoutUseSame.setChecked(true);
        cbCheckoutUseSame
            .setOnCheckedChangeListener(
                (CompoundButton buttonView, boolean isChecked) -> rlBillingRoot
                    .setVisibility(isChecked ? View.GONE : View.VISIBLE));
    }

    private void initPresenter() {
        initPresenterComponent().inject(this);
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
            etCheckoutDiscount.setFocusableInTouchMode(true);
            etCheckoutDiscount.setFocusable(true);
            etCheckoutDiscount.requestFocus();
            llBillingDiscount.setVisibility(View.GONE);
        } else {
            tvBtnCheckDiscountApply.setSelected(true);
            tvBtnCheckDiscountApply.setText(getResources().getString(R.string.cancel));
            etCheckoutDiscount.setFocusable(false);
            etCheckoutDiscount.setFocusableInTouchMode(false);
            etCheckoutDiscount.setText(discountVM.getDiscount());
            llBillingDiscount.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void applyPointsSuccess(ApplyPointsVM pointsVM) {
        if (tvBtnCheckPointsApply.isSelected()) {
            tvBtnCheckPointsApply.setSelected(false);
            tvBtnCheckPointsApply.setText(getResources().getString(R.string.apply));
            etCheckoutPoint.setText(pointsVM.getPointsApplied());
            etCheckoutPoint.setFocusableInTouchMode(true);
            etCheckoutPoint.setFocusable(true);
            etCheckoutPoint.requestFocus();
        } else {
            tvBtnCheckPointsApply.setSelected(true);
            tvBtnCheckPointsApply.setText(getResources().getString(R.string.cancel));
            etCheckoutPoint.setFocusable(false);
            etCheckoutPoint.setFocusableInTouchMode(false);
            etCheckoutPoint.setText(pointsVM.getPointsApplied());
        }
    }

    @Override
    public void applyEGiftSuccess(ApplyEGiftVM eGiftVM) {
        if (tvBtnCheckGiftCardApply.isSelected()) {
            tvBtnCheckGiftCardApply.setSelected(false);
            tvBtnCheckGiftCardApply.setText(getResources().getString(R.string.apply));
            etCheckoutEgift.setText(eGiftVM.geteGiftApplied());
            etCheckoutEgift.setFocusableInTouchMode(true);
            etCheckoutEgift.setFocusable(true);
            etCheckoutEgift.requestFocus();
            llBillingEgift.setVisibility(View.GONE);
        } else {
            tvBtnCheckGiftCardApply.setSelected(true);
            tvBtnCheckGiftCardApply.setText(getResources().getString(R.string.cancel));
            etCheckoutEgift.setFocusable(false);
            etCheckoutEgift.setFocusableInTouchMode(false);
            etCheckoutEgift.setText(eGiftVM.geteGiftApplied());
            llBillingEgift.setVisibility(View.VISIBLE);
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
        List<AddressVM> addressVMS = checkoutVM.getAddressVMS();

        for (AddressVM addressVM : addressVMS) {
            if (addressVM.isShippingDefault()) {
                updateShippingAddress(addressVM.getName(), addressVM.getAddress()
                    , addressVM.getAddressSecond(), addressVM.getCityStatePost(),
                    addressVM.getCountry(), addressVM.getTel());
            } else {
                updateBillingAddress(addressVM.getName(), addressVM.getAddress(),
                    addressVM.getAddressSecond(),
                    addressVM.getCityStatePost(), addressVM.getCountry(),
                    addressVM.getTel());
            }
        }
        cbCheckoutUseSame.setChecked(checkoutVM.isUseSame());
        paymentAdapter.setPaymentMethodVMS(checkoutVM.getPaymentMethodVMs());
        productListAdapter.setProductVMS(checkoutVM.getProductVMS());
        BillingVM billingVM = checkoutVM.getBillingVM();
        updateBilling(billingVM);
        List<PaymentMethodVM> paymentMethodVMs = checkoutVM.getPaymentMethodVMs();
        for (PaymentMethodVM methodVM : paymentMethodVMs) {
            if (methodVM.getMonths() != null && methodVM.getMonths().size() > 0) {
                months = methodVM.getMonths();
                break;
            }
        }
        updateInputEditLayout(billingVM.getBillingDiscountAmount(), billingVM.getBillingEGiftAmount(),
            billingVM.getBillingPointsApplied(), billingVM.getBillingPointsAmount());
    }

    private void updateInputEditLayout(String discountAmount, String egiftAmount,
        String appliedPoints, String pointsAmount) {
        if (!TextUtils.isEmpty(discountAmount)) {
            tvBtnCheckDiscountApply.setSelected(true);
            tvBtnCheckDiscountApply.setText(getResources().getString(R.string.cancel));
            etCheckoutDiscount.setFocusable(false);
            etCheckoutDiscount.setFocusableInTouchMode(false);
            etCheckoutDiscount.setText(discountAmount);
            llBillingDiscount.setVisibility(View.VISIBLE);
        } else {
            tvBtnCheckDiscountApply.setSelected(false);
            tvBtnCheckDiscountApply.setText(getResources().getString(R.string.apply));
            etCheckoutDiscount.setText("");
            etCheckoutDiscount.setFocusableInTouchMode(true);
            etCheckoutDiscount.setFocusable(true);
            etCheckoutDiscount.requestFocus();
            llBillingDiscount.setVisibility(View.GONE);
        }

        if (TextUtils.isEmpty(egiftAmount)) {
            tvBtnCheckGiftCardApply.setSelected(false);
            tvBtnCheckGiftCardApply.setText(getResources().getString(R.string.apply));
            etCheckoutEgift.setText("");
            etCheckoutEgift.setFocusableInTouchMode(true);
            etCheckoutEgift.setFocusable(true);
            etCheckoutEgift.requestFocus();
            llBillingEgift.setVisibility(View.GONE);
        } else {
            tvBtnCheckGiftCardApply.setSelected(true);
            tvBtnCheckGiftCardApply.setText(getResources().getString(R.string.cancel));
            etCheckoutEgift.setFocusable(false);
            etCheckoutEgift.setFocusableInTouchMode(false);
            etCheckoutEgift.setText(egiftAmount);
            llBillingEgift.setVisibility(View.VISIBLE);
        }

        if (TextUtils.isEmpty(pointsAmount)) {
            tvBtnCheckPointsApply.setSelected(false);
            tvBtnCheckPointsApply.setText(getResources().getString(R.string.apply));
            etCheckoutPoint.setText("");
            etCheckoutPoint.setFocusableInTouchMode(true);
            etCheckoutPoint.setFocusable(true);
            etCheckoutPoint.requestFocus();
        } else {
            tvBtnCheckPointsApply.setSelected(true);
            tvBtnCheckPointsApply.setText(getResources().getString(R.string.cancel));
            etCheckoutPoint.setFocusable(false);
            etCheckoutPoint.setFocusableInTouchMode(false);
            etCheckoutPoint.setText(pointsAmount);
            String pointsTip = String
                .format(getResources().getString(R.string.checkout_points_tip), appliedPoints);
            tvCheckoutAttention.setText(Html.fromHtml(pointsTip));
        }
    }

    @Override
    public void placeOrderSuccess(PaymentVM paymentVM) {
        finish();
    }

    private void updateBilling(BillingVM billingVM) {
        tvBillingSubtotalAmount.setText(billingVM.getBillingSubTotal());
        tvBillingShippingAmount.setText(billingVM.getBillingShipping());
        llBillingShipping
            .setVisibility(TextUtils.isEmpty(billingVM.getBillingShipping()) ? View.GONE : View.VISIBLE);
        tvBillingDiscountCode.setText(billingVM.getBillingDiscountCode());
        tvBillingDiscountAmount
            .setText(NumberFormater.formaterOfferPrice(billingVM.getBillingDiscountAmount()));
        llBillingDiscount
            .setVisibility(
                TextUtils.isEmpty(billingVM.getBillingDiscountAmount()) ? View.GONE : View.VISIBLE);
        tvBillingEgiftCode.setText(billingVM.getBillingEGiftCode());
        tvBillingEgiftAmount
            .setText(NumberFormater.formaterOfferPrice(billingVM.getBillingEGiftAmount()));
        llBillingEgift.setVisibility(
            TextUtils.isEmpty(billingVM.getBillingEGiftAmount()) ? View.GONE : View.VISIBLE);
        tvBillingPointsAmount
            .setText(NumberFormater.formaterOfferPrice(billingVM.getBillingPointsAmount()));
        tvBillingPointsCode.setText(TextFormater.formatBillingCode(billingVM.getBillingPointsApplied()));
        llBillingPoints.setVisibility(
            TextUtils.isEmpty(billingVM.getBillingPointsAmount()) ? View.GONE : View.VISIBLE);
        tvBillingTotal.setText(billingVM.getBillingTotal());
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

    @Override
    public void onPopItemClick(int position) {
        months = PopWindowUtil.updateSinglePopDatas(position, months);
        onPaymentListListener.onListSelect(months.get(position).getValue());
    }

    @Override
    public void onDismiss() {
        //don't need to implement it yet.
    }

    @Override
    public void onPaymentSelect() {
        //todo paymentSelect content
    }

    @Override
    public void onOptionsPop(List<ProfileMetaVM> profileMetaVMS) {
        PopWindowUtil.showSingleChoosePop(recyclerviewCheckoutPayment,
            getResources().getString(R.string.installment_plan_optional), months, this);
    }

    public void setOnPaymentListListener(OnPaymentListListener onPaymentListListener) {
        this.onPaymentListListener = onPaymentListListener;
    }

    public interface OnPaymentListListener {

        void onListSelect(String content);
    }
}
