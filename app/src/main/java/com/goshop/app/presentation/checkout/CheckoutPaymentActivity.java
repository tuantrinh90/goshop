package com.goshop.app.presentation.checkout;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.view.RobotoBoldTextView;
import com.goshop.app.common.view.RobotoRegularEditText;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.account.TermsConditionsActivity;
import com.goshop.app.utils.PopWindowUtil;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.OnClick;

public class CheckoutPaymentActivity extends BaseActivity {

    @BindView(R.id.et_checkout_cvv)
    RobotoRegularEditText etCheckoutCvv;

    @BindView(R.id.et_checkout_payment_name)
    CustomAnimEditText etCheckoutPaymentName;

    @BindView(R.id.et_checkout_payment_number)
    CustomAnimEditText etCheckoutPaymentNumber;

    @BindView(R.id.iv_checkout_cvv_tip)
    ImageView ivCheckoutCvvTip;

    @BindView(R.id.textinputlayout_cvv)
    TextInputLayout textinputlayoutCvv;

    @BindView(R.id.tv_btn_checkout_payment)
    RobotoBoldTextView tvBtnCheckoutPayment;

    @BindView(R.id.tv_checkout_payment_amount)
    RobotoBoldTextView tvCheckoutPaymentAmount;

    @BindView(R.id.tv_checkout_payment_amount_percent)
    RobotoRegularTextView tvCheckoutPaymentAmountPercent;

    @BindView(R.id.tv_checkout_payment_date)
    RobotoRegularTextView tvCheckoutPaymentDate;

    @BindView(R.id.tv_checkout_payment_read)
    RobotoRegularTextView tvCheckoutPaymentRead;

    @BindView(R.id.tv_checkout_payment_time)
    RobotoRegularTextView tvCheckoutPaymentTime;

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
        hideRightMenu();
        initRead();
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.payment);
    }

    private void initRead() {
        SpannableString spannableString = new SpannableString(
            getResources().getString(R.string.checkout_payment_tip));

        spannableString
            .setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.color_grayscale_text)),
                11, 29, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                startActivity(
                    new Intent(CheckoutPaymentActivity.this, TermsConditionsActivity.class));
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(ContextCompat.getColor(CheckoutPaymentActivity.this, R.color.color_grayscale_text));
                ds.setUnderlineText(true);
            }
        }, 195, 215, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tvCheckoutPaymentRead.setText(spannableString);
        tvCheckoutPaymentRead.setMovementMethod(LinkMovementMethod.getInstance());
    }


    @OnClick({R.id.imageview_left_menu, R.id.tv_btn_checkout_payment, R.id
        .tv_checkout_payment_date, R.id.iv_checkout_cvv_tip})
    public void onPaymentClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.tv_btn_checkout_payment:
                startActivity(new Intent(this, PaymentStatusActivity.class));
                break;
            case R.id.tv_checkout_payment_date:
                break;
            case R.id.iv_checkout_cvv_tip:
                PopWindowUtil.showInfoDisplayPop(ivCheckoutCvvTip,
                    getResources().getString(R.string.cvv_info));
                break;
        }
    }
}
