package com.goshop.app.presentation.goloyalty;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.common.view.RobotoBoldTabLayout;
import com.goshop.app.common.view.RobotoMediumTabLayout;
import com.goshop.app.utils.SlideMenuUtil;

import android.os.Bundle;
import android.support.annotation.NonNull;
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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.goshop.app.utils.SlideMenuUtil.MENU_KEY;

public class MyRewardsActivity extends BaseActivity implements NavigationView
    .OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.navigation_slide_menu)
    NavigationView navigationSlideMenu;

    @BindView(R.id.tablayout_my_rewards)
    RobotoMediumTabLayout tablayoutMyRewards;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.viewpager_my_rewards)
    ViewPager viewpagerMyRewards;

    private boolean isLogin = true;

    private String menuTag;

    private MyRewardsPagerAdapter rewardsPagerAdapter;

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
            toolbar.setNavigationOnClickListener(v -> finish());
        } else {
            if (menuTag.equals(SlideMenuUtil.MENU_VALUE)) {
                slideMenuUtil.liftedDrawerLayout();
            }
        }
    }

    @Override
    public int getContentView() {
        return R.layout.activity_my_rewards;
    }

    @Override
    public void inject() {
        imageViewLeftMenu.setVisibility(View.GONE);
        hideRightMenu();
        initSlideMenuListenerUtil( R.id.slide_menu_rewards);
        initTabLayoutViewPager();
    }

    private void initSlideMenuListenerUtil(int currentMenuId) {
        slideMenuUtil = new SlideMenuUtil(this, currentMenuId, drawerLayout,
            navigationSlideMenu, isLogin, this);
    }

    private void initTabLayoutViewPager() {
        String[] tabLayoutArrays = {getResources().getString(
            R.string.pending), getResources().getString(
            R.string.redeemed), getResources().getString(R.string.expired)};

        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(PendingFragment.getInstance());
        fragments.add(RedeemedFragment.getInstance());
        fragments.add(ExpiredFragment.getInstance());
        rewardsPagerAdapter = new MyRewardsPagerAdapter(getSupportFragmentManager(), fragments,
            tabLayoutArrays);
        viewpagerMyRewards.setAdapter(rewardsPagerAdapter);
        tablayoutMyRewards.setupWithViewPager(viewpagerMyRewards);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.my_rewards);
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

    @OnClick({R.id.imageview_left_menu})
    public void onMyRewardsClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }
}
