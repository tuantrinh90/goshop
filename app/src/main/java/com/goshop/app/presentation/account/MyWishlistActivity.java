package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.MenuModel;
import com.goshop.app.presentation.model.WishlistVM;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.widget.adapter.MenuAdapter;
import com.goshop.app.widget.listener.OnItemMenuClickListener;

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
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class MyWishlistActivity extends BaseDrawerActivity<MyWishlistContract.Presenter> implements
    MyWishlistContract.View,
    OnItemMenuClickListener, PopWindowUtil.OnWishlistDeleteListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.recyclerview_menu)
    RecyclerView recyclerViewMenu;

    @BindView(R.id.recyclerview_wishlist)
    RecyclerView recyclerviewWishlist;

    @BindView(R.id.rl_wishlist_nodata)
    RelativeLayout rlWishlistNodata;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_btn_go_shop_now)
    RobotoRegularTextView tvBtnGoShopNow;

    private MyWishlistAdapter wishlistAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCurrentMenuType(MenuUtil.MENU_TYPE_MY_WISHLIST);
        setContentView(getContentView());
        initRecyclerView();
        initToolbar();
        mPresenter.getWishlistItems();
    }

    private void initToolbar() {
        hideLeftMenu();
        hideRightMenu();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_my_wishlist;
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
    public void showNodata() {
        rlWishlistNodata.setVisibility(View.VISIBLE);
    }

    @Override
    public void showWishlistItems(List<WishlistVM> wishlistVMS) {
        wishlistAdapter.setUpdateDatas(wishlistVMS);
    }

    @Override
    public void showError(String errorMessage) {
        //todo wait for design
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void deleteSuccess(List<WishlistVM> wishlistVMS) {
        wishlistAdapter.setUpdateDatas(wishlistVMS);
    }

    @OnClick(R.id.tv_btn_go_shop_now)
    public void onMyWishlistClick(View view) {
        //todo wait for api
    }

    @Override
    public void onItemMenuClick(View parentView, Object object) {
        PopWindowUtil.showWishlistMenuPop(parentView, this, (WishlistVM) object);
    }

    @Override
    public void onWishlistDelete(WishlistVM wishlistVM) {
        mPresenter.wishlistDeleteRequest(1, 3, wishlistVM.getSku());
    }
}
