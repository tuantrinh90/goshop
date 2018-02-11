package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.common.CustomSearchEditText;
import com.goshop.app.common.view.CustomBoldTabLayout;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.account.EditProfileActivity;
import com.goshop.app.presentation.account.HelpSupportActivity;
import com.goshop.app.presentation.account.LoginActivity;
import com.goshop.app.presentation.account.NotificationActivity;
import com.goshop.app.presentation.category.CategoryActivity;
import com.goshop.app.presentation.myorder.MyOrderDetailActivity;
import com.goshop.app.presentation.search.SearchActivity;
import com.goshop.app.presentation.settings.SettingsActivity;
import com.goshop.app.presentation.shopping.ShoppingCartActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by helen on 2018/2/8.
 */

public class MainPageActivity extends BaseActivity implements NavigationView
    .OnNavigationItemSelectedListener {

    @BindView(R.id.cset_search)
    CustomSearchEditText csetSearch;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.iv_search_icon)
    ImageView ivSearchIcon;

    @BindView(R.id.navigation_slide_menu)
    NavigationView navigationSlideMenu;

    @BindView(R.id.tablayout_main)
    CustomBoldTabLayout tablayoutMain;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_toolbar_cart_counter)
    CustomTextView tvToolbarCartCounter;

    @BindView(R.id.viewpager_main)
    ViewPager viewpagerMain;

    private boolean drawerHasSelect = false;

    private boolean isLogin = true;

    private ImageView ivSlideUser;

    private LinearLayout llSlideUserInfo;

    private int menuId;

    private MainPagerAdapter pagerAdapter;

    private MenuItem slideMenuHome, slideMenuCategories, slideMenuLoyalty, slideMenuCart,
        slideMenuWishlist, slideMenuOrder, slideMenuRewards, slideMenuNotification,
        slideMenuHelp, slideMenuSettings;

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
        return R.layout.activity_main_page;
    }

    @Override
    public String getScreenTitle() {
        return null;
    }

    @Override
    public void inject() {
        initNavigation();
        drawerLisenter();
        initTabLayoutViewPager();
        initSearch();
    }

    private void initNavigation() {
        navigationSlideMenu.setNavigationItemSelectedListener(this);
        slideMenuHome = getMenuItem(R.id.slide_menu_home);
        slideMenuCategories = getMenuItem(R.id.slide_menu_categories);
        slideMenuLoyalty = getMenuItem(R.id.slide_menu_go_loyalty);
        slideMenuCart = getMenuItem(R.id.slide_menu_cart);
        slideMenuWishlist = getMenuItem(R.id.slide_menu_wishlist);
        slideMenuOrder = getMenuItem(R.id.slide_menu_orders);
        slideMenuRewards = getMenuItem(R.id.slide_menu_rewards);
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
        slideMenuRewards.setVisible(isLogin);
        tvSlideSignUp.setVisibility(isLogin ? View.GONE : View.VISIBLE);
        llSlideUserInfo.setVisibility(isLogin ? View.VISIBLE : View.GONE);
        initSlideMenuHeaderListener();
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
                if (drawerHasSelect) {
                    switch (menuId) {
                        case R.id.tv_slide_sign_up:
                            intent = new Intent(MainPageActivity.this, LoginActivity.class);
                            break;
                        case R.id.ll_slide_user_info:
                            intent = new Intent(MainPageActivity.this, EditProfileActivity.class);
                            break;
                        case R.id.slide_menu_categories:
                            intent = new Intent(MainPageActivity.this, CategoryActivity.class);
                            break;
                        case R.id.slide_menu_go_loyalty:
                            //TODO(helen) this part need to decide
                            break;
                        case R.id.slide_menu_cart:
                            intent = new Intent(MainPageActivity.this, ShoppingCartActivity.class);
                            break;
                        case R.id.slide_menu_wishlist:
                            //TODO(helen) this part need to decide
                            break;
                        case R.id.slide_menu_orders:
                            intent = new Intent(MainPageActivity.this,
                                MyOrderDetailActivity.class);
                            break;
                        case R.id.slide_menu_rewards:
                            //TODO(helen) this part need to decide
                            break;
                        case R.id.slide_menu_notifications:
                            intent = new Intent(MainPageActivity.this, NotificationActivity.class);
                            break;
                        case R.id.slide_menu_help:
                            intent = new Intent(MainPageActivity.this, HelpSupportActivity.class);
                            break;
                        case R.id.slide_menu_setting:
                            intent = new Intent(MainPageActivity.this, SettingsActivity.class);
                            break;
                    }
                }

                drawerHasSelect = false;
                if (intent != null) {
                    slideMenuStartActivity(intent);
                }
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });
    }

    private void initTabLayoutViewPager() {
        String[] tabLayoutArrays = {getResources().getString(
            R.string.trending_now), getResources().getString(
            R.string.tv_shows), getResources().getString(R.string.brands)};

        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(HomePageFragment.getInstance());
        fragments.add(TVShowPageFragment.getInstance());
        fragments.add(BrandsPageFragment.getInstance());
        pagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), fragments,
            tabLayoutArrays);
        viewpagerMain.setAdapter(pagerAdapter);
        tablayoutMain.setupWithViewPager(viewpagerMain);
    }

    private void initSearch() {
        csetSearch.getEditText().setOnFocusChangeListener((View v, boolean hasFocus) -> {
            if (hasFocus) {
                csetSearch.getEditText().clearFocus();
                startActivity(new Intent(MainPageActivity.this, SearchActivity.class));
            }
        });
    }

    private MenuItem getMenuItem(int menuId) {
        return navigationSlideMenu.getMenu().findItem(menuId);
    }

    private void initSlideMenuHeaderListener() {
        tvSlideSignUp.setOnClickListener(v -> {
            drawerHasSelect = true;
            menuId = R.id.tv_slide_sign_up;
            drawerLayout.closeDrawer(GravityCompat.START);
        });
        llSlideUserInfo.setOnClickListener(v -> {
            drawerHasSelect = true;
            menuId = R.id.ll_slide_user_info;
            drawerLayout.closeDrawer(GravityCompat.START);
        });
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
        drawerHasSelect = true;
        menuId = item.getItemId();
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @OnClick({R.id.imageview_right_menu})
    public void onMainPageClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_right_menu:
                startActivity(new Intent(this, ShoppingCartActivity.class));
                break;
        }
    }

}
