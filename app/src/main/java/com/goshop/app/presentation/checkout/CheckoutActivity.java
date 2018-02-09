package com.goshop.app.presentation.checkout;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.adapter.CheckoutListAdapter;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomButton;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.utils.ScreenHelper;
import com.goshop.app.utils.ViewUtils;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

/**
 * Created by img on 2018/2/2.
 */

public class CheckoutActivity extends BaseActivity<CheckoutContract.Presenter> implements
    CheckoutContract.View {

    @BindView(R.id.imageview_left_menu)
    ImageView imageviewLeftMenu;

    @BindView(R.id.tv_checkout_shipping_title)
    CustomBoldTextView tvCheckoutShippingTitle;

    @BindView(R.id.tv_checkout_username)
    CustomTextView tvCheckoutUsername;

    @BindView(R.id.tv_checkout_address_first)
    CustomTextView tvCheckoutAddressFirst;

    @BindView(R.id.tv_checkout_address_second)
    CustomTextView tvCheckoutAddressSecond;

    @BindView(R.id.tv_checkout_city_state_code)
    CustomTextView tvCheckoutCityStateCode;

    @BindView(R.id.tv_checkout_country)
    CustomTextView tvCheckoutCountry;

    @BindView(R.id.tv_checkout_tel)
    CustomTextView tvCheckoutTel;

    @BindView(R.id.rl_shipping_root)
    RelativeLayout rlShippingRoot;

    @BindView(R.id.radio_payment_type)
    RadioGroup radioPaymentType;

    @BindView(R.id.rb_checkout_payment_banking)
    RadioButton rbCheckoutPaymentBanking;

    @BindView(R.id.rb_checkout_payment_credit)
    RadioButton rbCheckoutPaymentCredit;

    @BindView(R.id.rb_checkout_payment_cash_on_deliery)
    RadioButton rbCheckoutPaymentCashOnDeliery;

    @BindView(R.id.rv_order_list)
    RecyclerView rvOrderList;

    @BindView(R.id.tv_checkout_sub_total)
    CustomTextView tvCheckoutSubTotal;

    @BindView(R.id.tv_checkout_rounding_amout)
    CustomTextView tvCheckoutRoundingAmout;

    @BindView(R.id.tv_checkout_shipping)
    CustomTextView tvCheckoutShipping;

    @BindView(R.id.tv_checkout_discount)
    CustomTextView tvCheckoutDiscount;

    @BindView(R.id.tv_checkout_total)
    CustomBoldTextView tvCheckoutTotal;

    @BindView(R.id.btn_checkout_place_my_order)
    CustomButton btnCheckoutPlaceMyOrder;

    private static final int RADIO_BUTTON_W_AND_H = 25;
    String paymentType;

    @Override
    public int getContentView() {
        return R.layout.activity_checkout;
    }

    @Override
    public String getScreenTitle() {
        return ScreenHelper.getString(R.string.checkout_title);
    }

    @Override
    public void inject() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public void showCheckout(CheckoutResponse checkoutResponse) {
        initCheckoutPage(checkoutResponse);
        initRecycler(checkoutResponse);
    }

    private void initCheckoutPage(CheckoutResponse checkoutResponse) {
        tvCheckoutUsername.setText(checkoutResponse.getUserName());
        tvCheckoutAddressFirst.setText(checkoutResponse.getFirstAddress());
        tvCheckoutAddressSecond.setText(checkoutResponse.getSecondAddress());
        tvCheckoutCityStateCode.setText(checkoutResponse.getCity()+","+checkoutResponse.getPostcode());
        tvCheckoutCountry.setText(checkoutResponse.getCountry());
        tvCheckoutTel.setText(checkoutResponse.getTel());

        setRadioButtonDrawable(rbCheckoutPaymentBanking);
        setRadioButtonDrawable(rbCheckoutPaymentCredit);
        setRadioButtonDrawable(rbCheckoutPaymentCashOnDeliery);
        radioPaymentType.check(R.id.rb_checkout_payment_banking);
        radioPaymentType.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId){
                case R.id.rb_checkout_payment_banking:
                    paymentType= rbCheckoutPaymentBanking.getText().toString();
                    break;
                case R.id.rb_checkout_payment_credit:
                    paymentType= rbCheckoutPaymentCredit.getText().toString();
                    break;
                case R.id.rb_checkout_payment_cash_on_deliery:
                    paymentType= rbCheckoutPaymentCashOnDeliery.getText().toString();
                    break;
                default:
                    paymentType= rbCheckoutPaymentBanking.getText().toString();
                    break;
            }
        });
    }

    private void setRadioButtonDrawable(RadioButton radioButton){
        Drawable rbDrawable = getResources().getDrawable(R.drawable.selector_check);
        rbDrawable.setBounds(0, 0, ScreenHelper.dip2px(this,RADIO_BUTTON_W_AND_H), ScreenHelper.dip2px(this,RADIO_BUTTON_W_AND_H));
        radioButton.setCompoundDrawables(rbDrawable, null, null, null);
    }


    @Override
    public void showNetwordErrorMessage() {
    //TODO(helen)wait for api
    }

    @Override
    public void showFaildMessage(String errorMessage) {
//TODO(helen)wait for api
    }

    private void initRecycler(CheckoutResponse response) {
        rvOrderList.setLayoutManager(new LinearLayoutManager(this));
        rvOrderList.setNestedScrollingEnabled(false);
        rvOrderList.setAdapter(new CheckoutListAdapter(response.getCheckoutItems()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.setBg(imageviewLeftMenu,R.mipmap.back);
        mPresenter.getCheckout("");

    }

    @OnClick({R.id.rl_shipping_root, R.id.btn_checkout_place_my_order})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_shipping_root:
                break;
            case R.id.btn_checkout_place_my_order:
                break;
        }
    }
}
