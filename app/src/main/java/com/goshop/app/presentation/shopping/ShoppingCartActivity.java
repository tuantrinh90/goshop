package com.goshop.app.presentation.shopping;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularEditText;
import com.goshop.app.presentation.checkout.CheckoutActivity;
import com.goshop.app.presentation.home.MainPageActivity;
import com.goshop.app.presentation.model.ApplyDiscountVM;
import com.goshop.app.presentation.model.ShoppingCartProductVM;
import com.goshop.app.presentation.model.widget.ProductCartListVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.utils.NumberFormater;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.widget.adapter.WidgetProductListAdapter;
import com.goshop.app.widget.listener.OnItemMenuClickListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class ShoppingCartActivity extends BaseDrawerActivity<ShoppingCartContract.Presenter>
    implements ShoppingCartContract.View, OnItemMenuClickListener,
    PopWindowUtil.OnCartItemMenuClickListener {

    public static final String EXTRA_ENTRANCE = "extra_entrance";

    public static final String TYPE_ENTRANCE_DRAWER = "drawer";

    public static final String TYPE_ENTRANCE_HOME = "pdp";

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

    @BindView(R.id.tv_cart_billing_subtotal)
    RobotoLightTextView tvCartBillingSubtotal;

    @BindView(R.id.tv_cart_billing_shipping)
    RobotoLightTextView tvCartBillingShipping;

    @BindView(R.id.tv_cart_billing_disscount)
    RobotoLightTextView tvCartBillingDisscount;

    @BindView(R.id.tv_cart_billing_total)
    RobotoMediumTextView tvCartBillingTotal;

    @BindView(R.id.rl_cart_disscount)
    RelativeLayout rlCartDisscount;

    private WidgetProductListAdapter shoppingCartAdapter;

    private String entranceType;

    private ProductsVM productsVM;

    private String cartId;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private int page = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCurrentMenuType(MenuUtil.MENU_TYPE_SHOPPING_CART);
        setContentView(getContentView());
        initIntent();
        initToolbar();
        initRecyclerView();
        initSwipRefreshLayout();
        mPresenter.viewCartDetails(page, false);
    }

    private void initIntent() {
        entranceType = getIntent().getStringExtra(EXTRA_ENTRANCE);
    }

    private void initToolbar() {
        hideRightMenu();
        if (TYPE_ENTRANCE_DRAWER.equals(entranceType)) {
            imageViewLeftMenu.setImageResource(R.drawable.ic_menu);
        } else {
            imageViewLeftMenu.setImageResource(R.drawable.ic_icon_back);
        }
    }

    @Override
    public int getContentView() {
        return R.layout.activity_shopping_cart;
    }

    @Override
    public void inject() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
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
        shoppingCartAdapter = new WidgetProductListAdapter(new ArrayList<>());
        rvShoppintCart.setAdapter(shoppingCartAdapter);
        shoppingCartAdapter.setOnItemMenuClickListener(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.shopping_cart);
    }

    @Override
    public void showCartDetail(ShoppingCartProductVM cartProductVM) {
        if (cartProductVM.getProductListModels() != null && cartProductVM.getProductListModels()
            .size() > 0) {
            updateLayoutStatus(flContent, true);
            cartId = cartProductVM.getId();
            shoppingCartAdapter.setListModels(cartProductVM.getProductListModels());

            if (cartProductVM.getDiscount() != null && TextUtils
                .isEmpty(cartProductVM.getDiscount())) {
                rlCartDisscount.setVisibility(View.GONE);
                tvBtnCartApply.setText(getResources().getString(R.string.apply));
                tvBtnCartApply.setSelected(false);
                etCartApply.setFocusableInTouchMode(true);
                etCartApply.setFocusable(true);
                etCartApply.requestFocus();
            } else {
                rlCartDisscount.setVisibility(View.VISIBLE);
                tvCartBillingDisscount.setText(
                    NumberFormater.formaterDiscountPrice(cartProductVM.getDiscount()));
                etCartApply.setText(cartProductVM.getDiscount());
                tvBtnCartApply.setText(getResources().getString(R.string.cancel));
                tvBtnCartApply.setSelected(true);
                etCartApply.setFocusable(false);
                etCartApply.setFocusableInTouchMode(false);
            }
            tvCartBillingSubtotal.setText(cartProductVM.getSubTotal());
            tvCartBillingShipping.setText(cartProductVM.getShipping());
            tvCartBillingTotal.setText(cartProductVM.getTotal());
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
    public void removeSuccess() {
        PopWindowUtil
            .showRequestMessagePop(rvShoppintCart, getResources().getString(R.string.success));
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
    public void applySuccess(ApplyDiscountVM discountVM) {
        if (tvBtnCartApply.isSelected()) {
            rlCartDisscount.setVisibility(View.GONE);
            tvBtnCartApply.setText(getResources().getString(R.string.apply));
            tvBtnCartApply.setSelected(false);
            etCartApply.setText("");
            etCartApply.setFocusableInTouchMode(true);
            etCartApply.setFocusable(true);
            etCartApply.requestFocus();
        } else {
            rlCartDisscount.setVisibility(View.VISIBLE);
            tvBtnCartApply.setText(getResources().getString(R.string.cancel));
            tvBtnCartApply.setSelected(true);
            etCartApply.setText(discountVM.getDiscount());
            etCartApply.setFocusable(false);
            etCartApply.setFocusableInTouchMode(false);
            tvCartBillingDisscount.setText(NumberFormater.formaterDiscountPrice(discountVM.getDiscount()));
        }

        tvCartBillingTotal.setText(discountVM.getOriginalPrice());
    }

    @Override
    public void onItemMenuClick(View parentView, Object object) {
        productsVM = ((ProductCartListVM) object).getProductsVM();
        PopWindowUtil.showShoppingCartMenuPop(parentView, this);
    }

    @Override
    public void onCartWishlist() {
        mPresenter.addWishlistRequest(productsVM.getId());
    }

    @Override
    public void onCartDeleteClick() {
        mPresenter.removeFromCartRequest(productsVM.getId(), productsVM.getAmount());
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
                    mPresenter.applyCoupon(code, cartId);
                }

                break;
            case R.id.imageview_left_menu:
                if (TYPE_ENTRANCE_DRAWER.equals(entranceType)) {
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

}
