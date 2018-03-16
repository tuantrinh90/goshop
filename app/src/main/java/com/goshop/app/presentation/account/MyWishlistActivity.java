package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.utils.SlideMenuUtil;
import com.goshop.app.widget.listener.OnItemMenuClickListener;

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
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

import static com.goshop.app.utils.SlideMenuUtil.MENU_KEY;

public class MyWishlistActivity extends BaseActivity<MyWishlistContract.Presenter> implements
    MyWishlistContract.View, NavigationView.OnNavigationItemSelectedListener,
    OnItemMenuClickListener, PopWindowUtil.OnCartItemMenuClickListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.navigation_slide_menu)
    NavigationView navigationSlideMenu;

    @BindView(R.id.recyclerview_wishlist)
    RecyclerView recyclerviewWishlist;

    @BindView(R.id.rl_wishlist_nodata)
    RelativeLayout rlWishlistNodata;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_btn_go_shop_now)
    RobotoRegularTextView tvBtnGoShopNow;

    private boolean isLogin = true;

    private String menuTag;

    private SlideMenuUtil slideMenuUtil;

    private MyWishlistAdapter wishlistAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //R.id.slide_menu_wishlist
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0,
            0);
        toggle.syncState();
        menuTag = getIntent().getStringExtra(MENU_KEY);
        if (menuTag == null) {
            slideMenuUtil.disabledDrawerLayout();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(v -> finish());
        } else {
            if (menuTag.equals(SlideMenuUtil.MENU_VALUE)) {
                slideMenuUtil.liftedDrawerLayout();
            }
        }
        //todo wait for api
        mPresenter.myWishlistRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_my_wishlist;
    }

    @Override
    public void inject() {
        imageViewLeftMenu.setVisibility(View.GONE);
        hideRightMenu();
        initSlideMenuListenerUtil(R.id.slide_menu_wishlist);
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
        recyclerviewWishlist.setLayoutManager(layoutManager);
        wishlistAdapter = new MyWishlistAdapter(new ArrayList<>());
        recyclerviewWishlist.setAdapter(wishlistAdapter);
        wishlistAdapter.setOnItemMenuClickListener(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.my_wishlist);
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
    public void showNodata() {
        rlWishlistNodata.setVisibility(View.VISIBLE);
    }

    @Override
    public void showWishlistResult(List<ProductsVM> productsVMS) {
        wishlistAdapter.setUpdateDatas(productsVMS);
    }

    @OnClick(R.id.tv_btn_go_shop_now)
    public void onMyWishlistClick(View view) {
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
