package com.goshop.app.utils;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.account.HelpSupportActivity;
import com.goshop.app.presentation.account.MyAccountLandingActivity;
import com.goshop.app.presentation.account.NotificationActivity;
import com.goshop.app.presentation.category.CategoryActivity;
import com.goshop.app.presentation.goloyalty.GoLoyaltyActivity;
import com.goshop.app.presentation.home.MainPageActivity;
import com.goshop.app.presentation.login.LoginActivity;
import com.goshop.app.presentation.login.TestMenuActivity;
import com.goshop.app.presentation.myorder.MyOrderListActivity;
import com.goshop.app.presentation.settings.SettingsActivity;
import com.goshop.app.presentation.shopping.ShoppingCartActivity;

import android.app.Activity;
import android.content.Intent;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SlideMenuUtil {

    public final static String MENU_KEY = "menu";

    public final static String MENU_VALUE = "slideMenu";

    private Activity activity;

    private int currentMenuId;

    private boolean drawerHasSelect = false;

    private DrawerLayout drawerLayout;

    private NavigationView.OnNavigationItemSelectedListener itemSelectedListener;

    private ImageView ivSlideUser;

    private LinearLayout llSlideUserInfo;

    private NavigationView navigationView;

    private OnStartNextScreenListener nextScreenListener;

    private int selectMenuId;

    private MenuItem slideMenuHome, slideMenuCategories, slideMenuLoyalty, slideMenuCart,
        slideMenuWishlist, slideMenuOrder, slideMenuRewards, slideMenuNotification,
        slideMenuHelp, slideMenuSettings, slideMenuOthers;

    private CustomBoldTextView tvSlideSignUp;

    private CustomTextView tvSlideUserName;

    public SlideMenuUtil(Activity activity, int currentMenuId, DrawerLayout drawerLayout,
        NavigationView navigationView, boolean isLogin,
        NavigationView.OnNavigationItemSelectedListener itemSelectedListener) {
        this.drawerLayout = drawerLayout;
        this.currentMenuId = currentMenuId;
        this.activity = activity;
        this.navigationView = navigationView;
        this.itemSelectedListener = itemSelectedListener;
        initNavigation(isLogin);
        drawerLisenter();
    }

    private void initNavigation(boolean isLogin) {
        navigationView.setNavigationItemSelectedListener(itemSelectedListener);
        slideMenuHome = getMenuItem(navigationView, R.id.slide_menu_home);
        slideMenuCategories = getMenuItem(navigationView, R.id.slide_menu_categories);
        slideMenuLoyalty = getMenuItem(navigationView, R.id.slide_menu_go_loyalty);
        slideMenuCart = getMenuItem(navigationView, R.id.slide_menu_cart);
        slideMenuWishlist = getMenuItem(navigationView, R.id.slide_menu_wishlist);
        slideMenuOrder = getMenuItem(navigationView, R.id.slide_menu_orders);
        slideMenuRewards = getMenuItem(navigationView, R.id.slide_menu_rewards);
        slideMenuNotification = getMenuItem(navigationView, R.id.slide_menu_notifications);
        slideMenuHelp = getMenuItem(navigationView, R.id.slide_menu_help);
        slideMenuSettings = getMenuItem(navigationView, R.id.slide_menu_setting);
        slideMenuOthers = getMenuItem(navigationView, R.id.slide_menu_others);
        View headerView = navigationView.getHeaderView(0);
        tvSlideSignUp = headerView.findViewById(R.id.tv_slide_sign_up);
        llSlideUserInfo = headerView.findViewById(R.id.ll_slide_user_info);
        ivSlideUser = headerView.findViewById(R.id.iv_slide_user);
        tvSlideUserName = headerView.findViewById(R.id.tv_slide_user_name);

        slideMenuWishlist.setVisible(isLogin);
        slideMenuOrder.setVisible(isLogin);
        slideMenuRewards.setVisible(isLogin);
        tvSlideSignUp.setVisibility(isLogin ? View.GONE : View.VISIBLE);
        llSlideUserInfo.setVisibility(isLogin ? View.VISIBLE : View.GONE);
        initSlideMenuHeaderListener();
        disableNavigationViewScrollbars();
        initSlideMenuItem(currentMenuId);
    }

    public void drawerLisenter() {
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
                if (drawerHasSelect && currentMenuId != selectMenuId) {
                    switch (selectMenuId) {
                        case R.id.tv_slide_sign_up:
                            intent = new Intent(activity, LoginActivity.class);
                            break;
                        case R.id.slide_menu_home:
                            intent = new Intent(activity, MainPageActivity.class);
                            break;
                        case R.id.ll_slide_user_info:
                            intent = new Intent(activity, MyAccountLandingActivity.class);
                            break;
                        case R.id.slide_menu_categories:
                            intent = new Intent(activity, CategoryActivity.class);
                            break;
                        case R.id.slide_menu_go_loyalty:
                            intent = new Intent(activity, GoLoyaltyActivity.class);
                            break;
                        case R.id.slide_menu_cart:
                            intent = new Intent(activity, ShoppingCartActivity.class);
                            break;
                        case R.id.slide_menu_wishlist:
                            //TODO  this part need to decide
                            break;
                        case R.id.slide_menu_orders:
                            intent = new Intent(activity, MyOrderListActivity.class);
                            break;
                        case R.id.slide_menu_rewards:
                            //TODO  this part need to decide
                            break;
                        case R.id.slide_menu_notifications:
                            intent = new Intent(activity, NotificationActivity.class);
                            break;
                        case R.id.slide_menu_help:
                            intent = new Intent(activity, HelpSupportActivity.class);
                            break;
                        case R.id.slide_menu_setting:
                            intent = new Intent(activity, SettingsActivity.class);
                            break;
                        case R.id.slide_menu_others:
                            intent = new Intent(activity, TestMenuActivity.class);
                            break;
                    }
                }

                drawerHasSelect = false;
                if (intent != null) {
                    intent.putExtra(MENU_KEY, MENU_VALUE);
                    activity.startActivity(intent);
                    activity.overridePendingTransition(R.anim.slide_menu_in,
                        R.anim.slide_menu_out);
                    activity.finish();
                    //todo this may use later please keep it
//                    nextScreenListener.startNextScreen(intent);
                }
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });
    }

    private MenuItem getMenuItem(NavigationView navigationView, int menuId) {
        return navigationView.getMenu().findItem(menuId);
    }

    private void initSlideMenuHeaderListener() {
        tvSlideSignUp.setOnClickListener(v -> {
            setDrawerHasSelect(true);
            setSelectMenuId(R.id.tv_slide_sign_up);
            drawerLayout.closeDrawer(GravityCompat.START);
        });
        llSlideUserInfo.setOnClickListener(v -> {
            setDrawerHasSelect(true);
            setSelectMenuId(R.id.ll_slide_user_info);
            drawerLayout.closeDrawer(GravityCompat.START);
        });
    }

    private void disableNavigationViewScrollbars() {
        if (navigationView != null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView
                .getChildAt(0);
            if (navigationMenuView != null) {
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
    }

    private void initSlideMenuItem(int initId) {
        switch (initId) {
            case R.id.slide_menu_home:
                slideMenuHome.setChecked(true);
                break;
            case R.id.slide_menu_categories:
                slideMenuCategories.setChecked(true);
                break;
            case R.id.slide_menu_go_loyalty:
                slideMenuLoyalty.setChecked(true);
                break;
            case R.id.slide_menu_cart:
                slideMenuCart.setChecked(true);
                break;
            case R.id.slide_menu_wishlist:
                slideMenuWishlist.setChecked(true);
                break;
            case R.id.slide_menu_orders:
                slideMenuOrder.setChecked(true);
                break;
            case R.id.slide_menu_rewards:
                slideMenuRewards.setChecked(true);
                break;
            case R.id.slide_menu_notifications:
                slideMenuNotification.setChecked(true);
                break;
            case R.id.slide_menu_help:
                slideMenuHelp.setChecked(true);
                break;
            case R.id.slide_menu_setting:
                slideMenuSettings.setChecked(true);
                break;
            case R.id.slide_menu_others:
                slideMenuOthers.setChecked(true);
                break;
        }
    }

    public void setDrawerHasSelect(boolean hasSelect) {
        this.drawerHasSelect = hasSelect;
    }

    public void setSelectMenuId(int menuId) {
        this.selectMenuId = menuId;
    }

//    public void setOnNavigationItemSelectedListener(
//        NavigationView.OnNavigationItemSelectedListener itemSelectedListener) {
//        this.itemSelectedListener = itemSelectedListener;
//    }

    public void setOnNextScreenListener(OnStartNextScreenListener nextScreenListener) {
        this.nextScreenListener = nextScreenListener;
    }

    public void disabledDrawerLayout() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    public void liftedDrawerLayout() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    public interface OnStartNextScreenListener {

        void startNextScreen(Intent intent);
    }
}
