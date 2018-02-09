package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomSearchEditText;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.account.HelpSupportActivity;
import com.goshop.app.presentation.account.LoginActivity;
import com.goshop.app.presentation.account.NotificationActivity;
import com.goshop.app.presentation.category.CategoryActivity;
import com.goshop.app.presentation.login.RegisterActivity;
import com.goshop.app.presentation.myorder.MyOrderDetailActivity;
import com.goshop.app.presentation.settings.SettingsActivity;
import com.goshop.app.presentation.shopping.ShoppingCartActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;

/**
 * Created by helen on 2018/2/8.
 */

public class HomeSlideMenuActivity extends BaseActivity implements NavigationView
    .OnNavigationItemSelectedListener {

    @BindView(R.id.cset_search)
    CustomSearchEditText csetSearch;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.navigation_slide_menu)
    NavigationView navigationSlideMenu;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private boolean isLogin = false;

    private ImageView ivSlideUser;

    private LinearLayout llSlideUserInfo;

    private int menuId;

    private MenuItem slideMenuHome, slideMenuCategories, slideMenuLoyalty, slideMenuCart,
        slideMenuWishlist, slideMenuOrder, slideMenuNotification, slideMenuHelp, slideMenuSettings;

    private CustomBoldTextView tvSlideSignUp;

    private CustomTextView tvSlideUserName;

    private CustomTextView tvToolbarShoppingCartNum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0,
            0);

        toggle.syncState();

    }

    @Override
    public int getContentView() {
        return R.layout.activity_home_slide_menu;
    }

    @Override
    public String getScreenTitle() {
        return null;
    }

    @Override
    public void inject() {
        initNavigation();
        drawerLisenter();
    }

    private void initNavigation() {
        navigationSlideMenu.setNavigationItemSelectedListener(this);
        slideMenuHome = getMenuItem(R.id.slide_menu_home);
        slideMenuCategories = getMenuItem(R.id.slide_menu_categories);
        slideMenuLoyalty = getMenuItem(R.id.slide_menu_go_loyalty);
        slideMenuCart = getMenuItem(R.id.slide_menu_cart);
        slideMenuWishlist = getMenuItem(R.id.slide_menu_wishlist);
        slideMenuOrder = getMenuItem(R.id.slide_menu_orders);
        slideMenuNotification = getMenuItem(R.id.slide_menu_notifications);
        slideMenuHelp = getMenuItem(R.id.slide_menu_help);
        slideMenuSettings = getMenuItem(R.id.slide_menu_setting);

        View headerView = navigationSlideMenu.getHeaderView(0);
        tvSlideSignUp = headerView.findViewById(R.id.tv_slide_sign_up);
        llSlideUserInfo = headerView.findViewById(R.id.ll_slide_user_info);
        ivSlideUser = headerView.findViewById(R.id.iv_slide_user);
        tvSlideUserName = headerView.findViewById(R.id.tv_slide_user_name);

        slideMenuWishlist.setVisible(isLogin);
        slideMenuOrder.setVisible(isLogin);
        tvSlideSignUp.setVisibility(isLogin ? View.GONE : View.VISIBLE);
        llSlideUserInfo.setVisibility(isLogin ? View.VISIBLE : View.GONE);
    }

    private void drawerLisenter() {
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Intent intent = null;
                switch (menuId) {
                    case R.id.slide_menu_categories:
                        intent = new Intent(HomeSlideMenuActivity.this, CategoryActivity.class);
                        break;
                    case R.id.slide_menu_go_loyalty:
                        //TODO(helen) this part need to decide
                        break;
                    case R.id.slide_menu_cart:
                        intent = new Intent(HomeSlideMenuActivity.this, ShoppingCartActivity.class);
                        break;
                    case R.id.slide_menu_wishlist:
                        //TODO(helen) this part need to decide
                        break;
                    case R.id.slide_menu_orders:
                        intent = new Intent(HomeSlideMenuActivity.this, MyOrderDetailActivity.class);
                        break;
                    case R.id.slide_menu_notifications:
                        intent = new Intent(HomeSlideMenuActivity.this, NotificationActivity.class);
                        break;
                    case R.id.slide_menu_help:
                        intent = new Intent(HomeSlideMenuActivity.this, HelpSupportActivity.class);
                        break;
                    case R.id.slide_menu_setting:
                        intent = new Intent(HomeSlideMenuActivity.this, SettingsActivity.class);
                        break;
                }

                if(intent != null) {
                    slideMenuStartActivity(intent);
                }
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });
    }

    private MenuItem getMenuItem(int menuId) {
        return navigationSlideMenu.getMenu().findItem(menuId);
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
    public boolean onNavigationItemSelected(MenuItem item) {
        menuId = item.getItemId();
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
