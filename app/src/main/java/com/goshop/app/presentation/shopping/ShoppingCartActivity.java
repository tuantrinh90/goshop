package com.goshop.app.presentation.shopping;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.presentation.checkout.CheckoutActivity;
import com.goshop.app.presentation.model.MenuModel;
import com.goshop.app.presentation.model.ShoppingCartModel;
import com.goshop.app.presentation.model.widget.CarouselItemsVM;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.widget.adapter.MenuAdapter;
import com.goshop.app.widget.listener.OnBannerItemClickListener;
import com.goshop.app.widget.listener.OnItemMenuClickListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class ShoppingCartActivity extends BaseDrawerActivity<ShoppingCartContract.Presenter> implements
    ShoppingCartContract.View, ShoppingCartAdapter.OnCheckoutClickListener,
    OnBannerItemClickListener, OnItemMenuClickListener,
    PopWindowUtil.OnCartItemMenuClickListener {

    public static final String EXTRA_ENTRANCE = "extra_entrance";

    public static final String TYPE_ENTRANCE_DRAWER = "drawer";

    public static final String TYPE_ENTRANCE_PDP = "pdp";

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.recyclerview_menu)
    RecyclerView recyclerViewMenu;

    @BindView(R.id.rv_shoppint_cart)
    RecyclerView rvShoppintCart;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private ShoppingCartAdapter shoppingCartAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCurrentMenuType(MenuUtil.MENU_TYPE_SHOPPING_CART);
        setContentView(getContentView());
        initToolbar();
        initRecyclerView();
        //TODO(helen) wait for api
        mPresenter.shoppingCartRequest(null);
    }

    private void initToolbar() {
        hideLeftMenu();
        hideRightMenu();
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

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvShoppintCart.setLayoutManager(layoutManager);
        shoppingCartAdapter = new ShoppingCartAdapter(new ArrayList<>(), this);
        rvShoppintCart.setAdapter(shoppingCartAdapter);
        shoppingCartAdapter.setOnBannerItemClickListener(this);
        shoppingCartAdapter.setOnItemMenuClickListener(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.shopping_cart);
    }

    @Override
    public void showCartDetail(List<ShoppingCartModel> cartModels) {
        shoppingCartAdapter.setDatas(cartModels);
    }

    @Override
    public void onCheckoutClick() {
        startActivity(new Intent(ShoppingCartActivity.this, CheckoutActivity.class));
    }

    @Override
    public void onBannerItemClick(CarouselItemsVM carouselItemsVM) {
        //todo wait for api
    }

    @Override
    public void onItemMenuClick(View parentView, Object object) {
        PopWindowUtil.showShoppingCartMenuPop(parentView, this);
    }

    @Override
    public void onCartWishlist() {
        //todo wait for api
    }

    @Override
    public void onCartDeleteClick() {
        //todo wait for api
    }

    @OnClick(R.id.tv_btn_cart_checkout)
    public void onCartClick(View view) {
        startActivity(new Intent(this, CheckoutActivity.class));
    }
}
