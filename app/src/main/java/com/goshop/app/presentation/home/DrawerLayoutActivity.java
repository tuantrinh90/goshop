package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.base.BasePresenter;
import com.goshop.app.common.view.CustomEditText;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by img on 2018/1/15.
 */

public class DrawerLayoutActivity<T extends BasePresenter> extends BaseActivity<T> {

    @BindView(R.id.et_home_search)
    CustomEditText etHomeSearch;

    @BindView(R.id.appbar_layout)
    AppBarLayout appbarLayout;

    @BindView(R.id.flContainer)
    FrameLayout flContainer;

    @BindView(R.id.root_layout)
    CoordinatorLayout rootLayout;

    @BindView(R.id.iv_user_img)
    ImageView ivUserImg;

    @BindView(R.id.tv_user_name)
    TextView tvUserName;

    @BindView(R.id.ll_profile)
    LinearLayout llProfile;

    @BindView(R.id.iv_home)
    ImageView ivHome;

    @BindView(R.id.tv_home)
    TextView tvHome;

    @BindView(R.id.rl_drawer_home)
    RelativeLayout rlDrawerHome;

    @BindView(R.id.iv_category_tree)
    ImageView ivCategoryTree;

    @BindView(R.id.tv_category_tree)
    TextView tvCategoryTree;

    @BindView(R.id.rl_drawer_categorytree)
    RelativeLayout rlDrawerCategorytree;

    @BindView(R.id.iv_reward)
    ImageView ivReward;

    @BindView(R.id.tv_reward)
    TextView tvReward;

    @BindView(R.id.rl_drawer_reward)
    RelativeLayout rlDrawerReward;

    @BindView(R.id.iv_shopping_cart)
    ImageView ivShoppingCart;

    @BindView(R.id.tv_shopping_cart)
    TextView tvShoppingCart;

    @BindView(R.id.tv_shoppingCart_num)
    TextView tvShoppingCartNum;

    @BindView(R.id.rl_drawer_shoppingcart)
    RelativeLayout rlDrawerShoppingcart;

    @BindView(R.id.iv_wishlist)
    ImageView ivWishlist;

    @BindView(R.id.tv_wishlist)
    TextView tvWishlist;

    @BindView(R.id.tv_wishlist_num)
    TextView tvWishlistNum;

    @BindView(R.id.rl_drawer_wishlist)
    RelativeLayout rlDrawerWishlist;

    @BindView(R.id.iv_orderlist)
    ImageView ivOrderlist;

    @BindView(R.id.tv_order)
    TextView tvOrder;

    @BindView(R.id.rl_drawer_order)
    RelativeLayout rlDrawerOrder;

    @BindView(R.id.iv_notification)
    ImageView ivNotification;

    @BindView(R.id.tv_notification)
    TextView tvNotification;

    @BindView(R.id.tv_notification_num)
    TextView tvNotificationNum;

    @BindView(R.id.rl_drawer_notification)
    RelativeLayout rlDrawerNotification;

    @BindView(R.id.tv_help_support)
    TextView tvHelpSupport;

    @BindView(R.id.tv_setting)
    TextView tvSetting;

    @BindView(R.id.menu_layout)
    LinearLayout menuLayout;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle mActionDrawableToggle;
    @Override
    public int getContentView() {
        return 0;
    }

    @Override
    public String getScreenTitle() {
        return null;
    }

    @Override
    public void inject() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_drawer_layout);
        initDrawLayout();
    }

    @Override
    public void setContentView(int layoutResID) {
        setContentView(View.inflate(this, layoutResID, null));
    }

    @Override
    public void setContentView(View view) {
        flContainer.addView(view);
    }

    private void initDrawLayout() {
        mActionDrawableToggle = new ActionBarDrawerToggle(this, getDrawerLayout(), getToolbar(), R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        getDrawerLayout().addDrawerListener(mActionDrawableToggle);
        mActionDrawableToggle.syncState();
    }

    @OnClick({R.id.ll_profile, R.id.rl_drawer_home, R.id.rl_drawer_categorytree, R.id
        .rl_drawer_reward, R.id.rl_drawer_shoppingcart, R.id.rl_drawer_wishlist, R.id
        .rl_drawer_order, R.id.rl_drawer_notification, R.id.tv_help_support, R.id.tv_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_profile:
                break;
            case R.id.rl_drawer_home:
                break;
            case R.id.rl_drawer_categorytree:
                break;
            case R.id.rl_drawer_reward:
                break;
            case R.id.rl_drawer_shoppingcart:
                break;
            case R.id.rl_drawer_wishlist:
                break;
            case R.id.rl_drawer_order:
                break;
            case R.id.rl_drawer_notification:
                break;
            case R.id.tv_help_support:
                break;
            case R.id.tv_setting:
                break;
        }
    }

    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }


}
