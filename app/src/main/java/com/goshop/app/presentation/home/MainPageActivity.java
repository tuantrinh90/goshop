package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.common.CustomSearchEditText;
import com.goshop.app.common.view.RobotoMediumTabLayout;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.search.SearchActivity;
import com.goshop.app.presentation.shopping.ShoppingCartActivity;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.widget.adapter.MenuAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainPageActivity extends BaseActivity implements MenuAdapter
    .OnSlideMenuItemClickListener {

    @BindView(R.id.cset_search)
    CustomSearchEditText csetSearch;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.iv_search_icon)
    ImageView ivSearchIcon;

    @BindView(R.id.recyclerview_menu)
    RecyclerView recyclerViewMenu;

    @BindView(R.id.tablayout_main)
    RobotoMediumTabLayout tablayoutMain;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_toolbar_cart_counter)
    RobotoMediumTextView tvToolbarCartCounter;

    @BindView(R.id.viewpager_main)
    ViewPager viewpagerMain;

    private int currentMenu;

    private boolean isLogin = true;

    private MenuAdapter menuAdapter;

    private MenuUtil menuUtil;

    private MainPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMenuUtil();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0,
            0);
        toggle.syncState();
        initMenuRecyclerview();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_main_page;
    }

    @Override
    public void inject() {
        initTabLayoutViewPager();
        initSearch();
    }

    @Override
    public String getScreenTitle() {
        return null;
    }

    private void initTabLayoutViewPager() {
        String[] tabLayoutArrays = {getResources().getString(
            R.string.trending_now), getResources().getString(
            R.string.tv_shows), getResources().getString(R.string.brands)};

        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(TrendingNowFragment.getInstance());
        fragments.add(TVShowPageFragment.getInstance());
        fragments.add(BrandsFragment.getInstance());
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

    private void initMenuUtil() {
        menuUtil = new MenuUtil(this, isLogin, drawerLayout);
    }

    private void initMenuRecyclerview() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewMenu.setLayoutManager(layoutManager);
        menuAdapter = new MenuAdapter(
            isLogin ? menuUtil.getLoginMenuModel() : menuUtil.getUnLoginMenuModel());
        recyclerViewMenu.setAdapter(menuAdapter);
        currentMenu = isLogin ? MenuUtil.LOGIN_MENU_HOME : MenuUtil.UNLOGIN_MENU_HOME;
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

    @OnClick({R.id.imageview_right_menu})
    public void onMainPageClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_right_menu:
                startActivity(new Intent(this, ShoppingCartActivity.class));
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //TODO(helen) this part need decide
    public void slideFinishActivity() {
        finish();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }


}
