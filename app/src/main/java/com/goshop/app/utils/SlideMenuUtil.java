package com.goshop.app.utils;

import com.goshop.app.R;
import com.goshop.app.common.RobotoRegularTypefaceSpan;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.account.HelpSupportActivity;
import com.goshop.app.presentation.account.MyAccountLandingActivity;
import com.goshop.app.presentation.account.MyWishlistActivity;
import com.goshop.app.presentation.account.NotificationActivity;
import com.goshop.app.presentation.category.CategoryActivity;
import com.goshop.app.presentation.goloyalty.GoLoyaltyActivity;
import com.goshop.app.presentation.goloyalty.MyRewardsActivity;
import com.goshop.app.presentation.home.MainPageActivity;
import com.goshop.app.presentation.login.LoginActivity;
import com.goshop.app.presentation.myorder.MyOrdersActivity;
import com.goshop.app.presentation.settings.SettingsActivity;
import com.goshop.app.presentation.shopping.ShoppingCartActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class SlideMenuUtil {

    public final static String MENU_KEY = "menu";

    public final static String MENU_VALUE = "slideMenu";

    private Activity activity;

    private int currentMenuId;

    private boolean drawerHasSelect = false;

    private DrawerLayout drawerLayout;

    private NavigationView.OnNavigationItemSelectedListener itemSelectedListener;

    private ImageView ivSlideUser;

//    private RelativeLayout rlSlideUserInfo;

    private NavigationView navigationView;

    private OnStartNextScreenListener nextScreenListener;

    private int selectMenuId;

    private MenuItem slideMenuHome, slideMenuCategories, slideMenuLoyalty, slideMenuCart,
        slideMenuWishlist, slideMenuOrder, slideMenuRewards, slideMenuNotification,
        slideMenuHelp, slideMenuSettings, slideMenuOthers;

    private RobotoMediumTextView tvSlideSignUp;

    private RobotoMediumTextView tvSlideUserName;

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
        //todo need decide
//        llSlideUserInfo = headerView.findViewById(R.id.ll_slide_user_info);
        ivSlideUser = headerView.findViewById(R.id.iv_slide_user);
        tvSlideUserName = headerView.findViewById(R.id.tv_slide_user_name);

        slideMenuWishlist.setVisible(isLogin);
        slideMenuOrder.setVisible(isLogin);
        slideMenuRewards.setVisible(isLogin);
        tvSlideSignUp.setVisibility(isLogin ? View.GONE : View.VISIBLE);
//        rlSlideUserInfo.setVisibility(isLogin ? View.VISIBLE : View.GONE);
        initSlideMenuHeaderListener();
        disableNavigationViewScrollbars();
        initSlideMenuItem(currentMenuId);
        setTypeFonts();
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
                        case R.id.rl_slide_user_info:
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
                            intent = new Intent(activity, MyWishlistActivity.class);
                            break;
                        case R.id.slide_menu_orders:
                            intent = new Intent(activity, MyOrdersActivity.class);
                            break;
                        case R.id.slide_menu_rewards:
                            intent = new Intent(activity, MyRewardsActivity.class);
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
                            //todo need decide
//                            intent = new Intent(activity, TestMenuActivity.class);
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
//        rlSlideUserInfo.setOnClickListener(v -> {
//            setDrawerHasSelect(true);
//            setSelectMenuId(R.id.rl_slide_user_info);
//            drawerLayout.closeDrawer(GravityCompat.START);
//        });
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

    private void setTypeFonts() {
        applyFontToMenuItem(slideMenuHome);
        applyFontToMenuItem(slideMenuCategories);
        applyFontToMenuItem(slideMenuLoyalty);
        applyFontToMenuItem(slideMenuCart);
        applyFontToMenuItem(slideMenuWishlist);
        applyFontToMenuItem(slideMenuOrder);
        applyFontToMenuItem(slideMenuRewards);
        applyFontToMenuItem(slideMenuNotification);
        applyFontToMenuItem(slideMenuHelp);
        applyFontToMenuItem(slideMenuSettings);
    }

    public void setDrawerHasSelect(boolean hasSelect) {
        this.drawerHasSelect = hasSelect;
    }

    public void setSelectMenuId(int menuId) {
        this.selectMenuId = menuId;
    }

    private void applyFontToMenuItem(MenuItem menuItem) {
        Typeface font = Typeface.createFromAsset(activity.getAssets(), "fonts/Roboto-Regular.ttf");
        SpannableString newTitle = new SpannableString(menuItem.getTitle());
        newTitle.setSpan(new RobotoRegularTypefaceSpan("", font), 0, newTitle.length(),
            Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        menuItem.setTitle(newTitle);
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
