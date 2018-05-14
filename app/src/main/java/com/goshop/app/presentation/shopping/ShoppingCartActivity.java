package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularEditText;
import com.goshop.app.presentation.checkout.CheckoutActivity;
import com.goshop.app.presentation.home.MainPageActivity;
import com.goshop.app.presentation.model.ApplyDiscountVM;
import com.goshop.app.presentation.model.BillingVM;
import com.goshop.app.presentation.model.ShoppingCartProductVM;
import com.goshop.app.presentation.model.common.ProductVM;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.utils.NumberFormater;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.utils.TextFormater;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class ShoppingCartActivity extends BaseDrawerActivity<ShoppingCartContract.Presenter>
    implements ShoppingCartContract.View, ShoppingCartAdapter.OnCartItemClickListener,
    PopWindowUtil.OnCartItemMenuClickListener {

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.rv_shoppint_cart)
    RecyclerView rvShoppintCart;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fl_no_data)
    FrameLayout flNoData;

    @BindView(R.id.fl_content)
    FrameLayout flContent;

    @BindView(R.id.fl_connection_break)
    FrameLayout flConnectionBreak;

    @BindView(R.id.tv_btn_cart_apply)
    RobotoMediumTextView tvBtnCartApply;

    @BindView(R.id.et_cart_apply)
    RobotoRegularEditText etCartApply;

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

    @BindView(R.id.ll_billing_egift)
    LinearLayout llBillingEgift;

    @BindView(R.id.tv_billing_points_code)
    RobotoLightTextView tvBillingPointsCode;

    @BindView(R.id.tv_billing_points_amount)
    RobotoLightTextView tvBillingPointsAmount;

    @BindView(R.id.ll_billing_points)
    LinearLayout llBillingPoints;

    @BindView(R.id.tv_billing_total)
    RobotoMediumTextView tvBillingTotal;

    @BindView(R.id.ll_billing_total)
    LinearLayout llBillingTotal;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private ShoppingCartAdapter shoppingCartAdapter;

    private String quoteId;

    private int page = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRecyclerView();
        initSwipRefreshLayout();
        mPresenter.viewCartDetails(page, false);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_shopping_cart;
    }

    @Override
    public void inject() {
        initPresenterComponent().inject(this);
        setCurrentMenuType(MenuUtil.MENU_TYPE_SHOPPING_CART);
        setContentView(getContentView());
    }

    private void initSwipRefreshLayout() {
        swipeRefreshLayout.setColorSchemeResources(R.color.color_main_pink);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            page = 1;
            mPresenter.viewCartDetails(page, true);
        });
    }

    @Override
    public void stopRefresh() {
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvShoppintCart.setLayoutManager(layoutManager);
        shoppingCartAdapter = new ShoppingCartAdapter(new ArrayList<>());
        rvShoppintCart.setAdapter(shoppingCartAdapter);
        shoppingCartAdapter.setOnCartItemClickListener(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.shopping_cart);
    }

    @Override
    public void showCartDetail(ShoppingCartProductVM cartProductVM) {
        if (cartProductVM.getProductVMS() != null && !cartProductVM.getProductVMS().isEmpty()) {
            updateLayoutStatus(flContent, true);
            quoteId = cartProductVM.getId();
            shoppingCartAdapter.setProductVMS(cartProductVM.getProductVMS());
            BillingVM billingVM = cartProductVM.getBillingVM();
            if (billingVM.getBillingDiscountAmount() != null && TextUtils
                .isEmpty(billingVM.getBillingDiscountAmount())) {
                llBillingDiscount.setVisibility(View.GONE);
                tvBtnCartApply.setText(getResources().getString(R.string.apply));
                tvBtnCartApply.setSelected(false);
                etCartApply.setFocusableInTouchMode(true);
                etCartApply.setFocusable(true);
                etCartApply.requestFocus();
            } else {
                llBillingDiscount.setVisibility(View.VISIBLE);
                tvBillingDiscountAmount.setText(
                    NumberFormater.formaterOfferPrice(billingVM.getBillingDiscountAmount()));
                tvBillingDiscountCode.setText(billingVM.getBillingDiscountCode());
                etCartApply.setText(billingVM.getBillingDiscountAmount());
                tvBtnCartApply.setText(getResources().getString(R.string.cancel));
                tvBtnCartApply.setSelected(true);
                etCartApply.setFocusable(false);
                etCartApply.setFocusableInTouchMode(false);
            }
            tvBillingSubtotalAmount.setText(billingVM.getBillingSubTotal());
            tvBillingShippingAmount.setText(billingVM.getBillingShipping());
            tvBillingPointsAmount
                .setText(NumberFormater.formaterOfferPrice(billingVM.getBillingPointsAmount()));
            tvBillingPointsCode.setText(billingVM.getBillingPointsApplied());
            tvBillingEgiftAmount
                .setText(NumberFormater.formaterOfferPrice(billingVM.getBillingEGiftAmount()));
            tvBillingEgiftCode.setText(billingVM.getBillingEGiftCode());
            llBillingEgift.setVisibility(
                TextUtils.isEmpty(billingVM.getBillingEGiftAmount()) ? View.GONE : View.VISIBLE);
            llBillingPoints.setVisibility(
                TextUtils.isEmpty(billingVM.getBillingPointsAmount()) ? View.GONE : View.VISIBLE);
            tvBillingTotal.setText(billingVM.getBillingTotal());
        } else {
            updateLayoutStatus(flNoData, true);
        }
    }

    @Override
    public void showNetError() {
        page = 1;
        updateLayoutStatus(flConnectionBreak, true);
    }

    @Override
    public void removeFailed(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(rvShoppintCart, errorMessage);
    }

    @Override
    public void addWishlistSuccess() {
        Toast.makeText(this, getResources().getString(R.string.success), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(rvShoppintCart, errorMessage);
    }

    @Override
    public void applySuccess(BillingVM billingVM) {
        if (tvBtnCartApply.isSelected()) {
            llBillingDiscount.setVisibility(View.GONE);
            tvBtnCartApply.setText(getResources().getString(R.string.apply));
            tvBtnCartApply.setSelected(false);
            etCartApply.setText("");
            etCartApply.setFocusableInTouchMode(true);
            etCartApply.setFocusable(true);
            etCartApply.requestFocus();
        } else {
            llBillingDiscount.setVisibility(View.VISIBLE);
            tvBtnCartApply.setText(getResources().getString(R.string.cancel));
            tvBtnCartApply.setSelected(true);
            etCartApply.setText(billingVM.getBillingDiscountAmount());
            etCartApply.setFocusable(false);
            etCartApply.setFocusableInTouchMode(false);
        }
        updateBilling(billingVM);
    }

    @Override
    public void onCartWishlist(ProductVM productVM) {
        mPresenter.addWishlistRequest(productVM.getId());
    }

    @Override
    public void onCartDeleteClick(ProductVM productVM) {
        mPresenter.removeFromCartRequest(productVM.getId(), productVM.getAmount());
    }

    @OnClick({R.id.tv_btn_cart_apply, R.id.tv_btn_cart_checkout, R.id.imageview_left_menu, R.id
        .tv_net_refresh})
    public void onCartClick(View view) {
        switch (view.getId()) {
            case R.id.tv_btn_cart_apply:
                KeyBoardUtils.hideKeyboard(this);
                String code = etCartApply.getText().toString();
                if (TextUtils.isEmpty(code)) {
                    Toast.makeText(this, getResources().getString(R.string.empty_error),
                        Toast.LENGTH_SHORT).show();
                } else {
                    mPresenter.applyCoupon(code, quoteId, tvBtnCartApply.isSelected());
                }

                break;
            case R.id.imageview_left_menu:
                if (MenuUtil.TYPE_ENTRANCE_DRAWER.equals(entranceType)) {
                    openDrawerLayout();
                } else {
                    finish();
                }
                break;
            case R.id.tv_btn_cart_checkout:
                startActivity(new Intent(this, CheckoutActivity.class));
                break;
            case R.id.tv_shop_now:
                updateLayoutStatus(flNoData, false);
                startActivity(new Intent(this, MainPageActivity.class));
                break;
            case R.id.tv_net_refresh:
                updateLayoutStatus(flConnectionBreak, false);
                mPresenter.viewCartDetails(page, false);
                break;

        }
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

    @Override
    public void onPlusMinusClick(boolean isPlus, String qty, ProductVM productVM) {
        //todo this is wait for api
        mPresenter.updateCartRequest("", qty);
    }

    @Override
    public void onEditSend(String qty, ProductVM productVM) {
        KeyBoardUtils.hideKeyboard(this);
        //todo this is wait for api
        mPresenter.updateCartRequest("", qty);
    }

    @Override
    public void onProductItemClick(ProductVM productVM) {
        Intent intent = new Intent(this, ProductDetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemMenuClick(View parentView, ProductVM productVM) {
        PopWindowUtil.showShoppingCartMenuPop(parentView, productVM, this);
    }
}
