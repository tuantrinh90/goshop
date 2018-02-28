package com.goshop.app.presentation.shopping;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.checkout.CheckoutActivity;
import com.goshop.app.presentation.model.ShoppingCartModel;
import com.goshop.app.presentation.model.widget.CarouselItemsVM;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.utils.SlideMenuUtil;
import com.goshop.app.widget.listener.OnBannerItemClickListener;
import com.goshop.app.widget.listener.OnItemMenuClickListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

import static com.goshop.app.utils.SlideMenuUtil.MENU_KEY;

public class ShoppingCartActivity extends BaseActivity<ShoppingCartContract.Presenter> implements
    ShoppingCartContract.View, ShoppingCartAdapter.OnCheckoutClickListener, NavigationView
    .OnNavigationItemSelectedListener, OnBannerItemClickListener, OnItemMenuClickListener,
    PopWindowUtil.OnCartItemMenuClickListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.navigation_slide_menu)
    NavigationView navigationSlideMenu;

    @BindView(R.id.rv_shoppint_cart)
    RecyclerView rvShoppintCart;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private boolean isLogin = true;

    private String menuTag;

    private ShoppingCartAdapter shoppingCartAdapter;

    private SlideMenuUtil slideMenuUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0,
            0);
        toggle.syncState();
        menuTag = getIntent().getStringExtra(MENU_KEY);
        if (menuTag == null) {
            slideMenuUtil.disabledDrawerLayout();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(v -> {
                finish();
            });
        } else {
            if (menuTag.equals(SlideMenuUtil.MENU_VALUE)) {
                slideMenuUtil.liftedDrawerLayout();
            }
        }
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
        initSlideMenuListenerUtil(R.id.slide_menu_cart);
        initPresenter();
        initRecyclerView();
    }

    private void initSlideMenuListenerUtil(int currentMenuId) {
        slideMenuUtil = new SlideMenuUtil(this, currentMenuId, drawerLayout,
            navigationSlideMenu, isLogin, this);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        slideMenuUtil.setDrawerHasSelect(true);
        slideMenuUtil.setSelectMenuId(item.getItemId());
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
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
    public void onItemMenuClick(View parentView) {
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
}
