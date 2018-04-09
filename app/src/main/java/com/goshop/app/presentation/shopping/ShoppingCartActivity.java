package com.goshop.app.presentation.shopping;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.checkout.CheckoutActivity;
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

public class ShoppingCartActivity extends BaseActivity<ShoppingCartContract.Presenter> implements
    ShoppingCartContract.View, ShoppingCartAdapter.OnCheckoutClickListener, MenuAdapter
    .OnSlideMenuItemClickListener, OnBannerItemClickListener, OnItemMenuClickListener,
    PopWindowUtil.OnCartItemMenuClickListener {

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

    private int currentMenu;

    private boolean isLogin = true;

    private MenuAdapter menuAdapter;

    private String menuTag;

    private MenuUtil menuUtil;

    private ShoppingCartAdapter shoppingCartAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initMenuUtil();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0,
            0);
        toggle.syncState();
        menuTag = getIntent().getStringExtra(MenuUtil.MENU_KEY);
        if (menuTag == null) {
            menuUtil.disabledDrawerLayout();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(v -> finish());
        } else {
            if (menuTag.equals(MenuUtil.MENU_VALUE)) {
                menuUtil.liftedDrawerLayout();
                getSupportActionBar().setDisplayShowHomeEnabled(true);
                toolbar.setNavigationOnClickListener(v -> {
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                    drawerLayout.openDrawer(Gravity.LEFT);
                });
            }
        }

        initMenuRecyclerview();
        //TODO(helen) wait for api
        mPresenter.shoppingCartRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_shopping_cart;
    }

    @Override
    public void inject() {
        hideRightMenu();
        imageViewLeftMenu.setVisibility(View.GONE);
        initPresenter();
        initRecyclerView();
    }

    private void initPresenter() {
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

    private void initMenuUtil() {
        menuUtil = new MenuUtil(this, isLogin, drawerLayout);
    }

    private void initMenuRecyclerview() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewMenu.setLayoutManager(layoutManager);
        menuAdapter = new MenuAdapter(
            isLogin ? menuUtil.getLoginMenuModel() : menuUtil.getUnLoginMenuModel());
        recyclerViewMenu.setAdapter(menuAdapter);
        currentMenu = isLogin ? MenuUtil.LOGIN_MENU_SHOPPING_CART : MenuUtil
            .UNLOGIN_MENU_SHOPPING_CART;
        menuAdapter.updateSelection(currentMenu);
        menuAdapter.setOnSlideMenuItemClickListener(this);
        menuAdapter.updateLoginState(isLogin);
    }

    @Override
    public void onHeaderUserClick(int position) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (currentMenu != position) {
            menuUtil.startNewScreen(position);
        }
    }

    @Override
    public void onHeaderLoginClick(int position) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (currentMenu != position) {
            menuUtil.startNewScreen(position);
        }
    }

    @Override
    public void onItemClick(int position) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (currentMenu != position) {
            menuUtil.startNewScreen(position);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
