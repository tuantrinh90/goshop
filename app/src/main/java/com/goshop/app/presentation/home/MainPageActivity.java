package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.common.CustomSearchEditText;
import com.goshop.app.common.view.RobotoMediumTabLayout;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.goloyalty.GoLoyaltyActivity;
import com.goshop.app.presentation.login.LoginActivity;
import com.goshop.app.presentation.search.SearchActivity;
import com.goshop.app.presentation.settings.SettingsActivity;
import com.goshop.app.presentation.shopping.ShoppingCartActivity;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.utils.UserHelper;
import com.goshop.app.widget.listener.OnScheduleClickListener;
import com.longtailvideo.jwplayer.JWPlayerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainPageActivity extends BaseDrawerActivity implements OnScheduleClickListener {

    @BindView(R.id.cset_search)
    CustomSearchEditText csetSearch;

    @BindView(R.id.iv_search_icon)
    ImageView ivSearchIcon;

    @BindView(R.id.imageview_left_menu)
    ImageView ivleftMenu;

    @BindView(R.id.tablayout_main)
    RobotoMediumTabLayout tablayoutMain;

    @BindView(R.id.tv_toolbar_cart_counter)
    RobotoMediumTextView tvToolbarCartCounter;

    @BindView(R.id.viewpager_main)
    ViewPager viewpagerMain;

    private MainPagerAdapter pagerAdapter;

    private String entrance;

    private String type;

    private boolean isFullScreen;

    private JWPlayerView jwPlayerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCurrentMenuType(MenuUtil.MENU_TYPE_HOME);
        setContentView(getContentView());
        initView();
        type = getIntent().getStringExtra(MenuUtil.TYPE);
        entrance = getIntent().getStringExtra(MenuUtil.EXTRA_ENTRANCE);
        Intent newIntent = null;
        if (type != null) {
            switch (type) {
                case MenuUtil.MENU_TYPE_SHOPPING_CART:
                    newIntent = new Intent(this, ShoppingCartActivity.class);
                    break;
                case MenuUtil.MENU_TYPE_GO_LOYALTY:
                    newIntent = new Intent(this, GoLoyaltyActivity.class);
                    break;
                case MenuUtil.MENU_TYPE_SETTINGS:
                    newIntent = new Intent(this, SettingsActivity.class);
                    break;
            }
            if (entrance != null) {
                newIntent.putExtra(MenuUtil.EXTRA_ENTRANCE, entrance);
            }
        }
        if (newIntent != null) {
            startActivity(newIntent);
        }
    }

    private void initView() {
        initTabLayoutViewPager();
        initSearchBar();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_main_page;
    }

    @Override
    public void inject() {
        // don't need to override this method now.
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.home);
    }

    private void initTabLayoutViewPager() {
        String[] tabLayoutArrays = {getResources().getString(
            R.string.trending_now), getResources().getString(
            R.string.tv_shows), getResources().getString(R.string.brands)};
        TrendingNowFragment trendingNowFragment = TrendingNowFragment.getInstance();
        trendingNowFragment.setOnScheduleClickListener(this::onScheduleClick);
        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(trendingNowFragment);
        fragments.add(TVShowPageFragment.getInstance());
        fragments.add(BrandsFragment.getInstance());
        pagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), fragments,
            tabLayoutArrays);
        viewpagerMain.setAdapter(pagerAdapter);
        tablayoutMain.setupWithViewPager(viewpagerMain);
        viewpagerMain.setOffscreenPageLimit(fragments.size());
        viewpagerMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i == 1) {
                    if (pagerAdapter.getItem(0) instanceof TrendingNowFragment) {
                        ((TrendingNowFragment) pagerAdapter.getItem(0)).onPause();
                    }
                    // TODO: 2018/4/26 this need delete later
                    PopWindowUtil.showNoApiPop(viewpagerMain);
                }
                if (i == 0) {
                    if (pagerAdapter.getItem(1) instanceof TrendingNowFragment) {
                        ((TrendingNowFragment) pagerAdapter.getItem(1)).onPause();
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initSearchBar() {
        csetSearch.getEditText().setOnFocusChangeListener((View v, boolean hasFocus) -> {
            if (hasFocus) {
                csetSearch.getEditText().clearFocus();
                startActivity(new Intent(MainPageActivity.this, SearchActivity.class));
            }
        });
        ivleftMenu.setImageResource(R.drawable.ic_menu);
        if (UserHelper.isLogin()) {
            tvToolbarCartCounter.setVisibility(View.VISIBLE);
        } else {
            tvToolbarCartCounter.setVisibility(View.GONE);
        }
    }

    @OnClick({R.id.imageview_right_menu, R.id.imageview_left_menu})
    public void onMainPageClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_right_menu:
                if (UserHelper.isLogin()) {
                    startActivity(new Intent(this, ShoppingCartActivity.class));
                } else {
                    Intent loginIntent = new Intent(this, LoginActivity.class);
                    loginIntent.putExtra(MenuUtil.TYPE, MenuUtil.MENU_TYPE_SHOPPING_CART);
                    UserHelper.goToLogin(this, loginIntent);
                }
                break;
            case R.id.imageview_left_menu:
                openDrawerLayout();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        if (jwPlayerView != null && isFullScreen) {
            jwPlayerView.setFullscreen(false, true);
        } else {
            super.onBackPressed();
        }
    }

    //TODO(helen) this part need decide
    public void slideFinishActivity() {
        finish();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    @Override
    public void onScheduleClick() {
        viewpagerMain.setCurrentItem(1);
    }

    public void onJWPlayerViewFullscreen(boolean isFullScreen, JWPlayerView jwPlayerView) {
        this.isFullScreen = isFullScreen;
        this.jwPlayerView = jwPlayerView;
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            if (isFullScreen) {
                actionBar.hide();
            } else {
                actionBar.show();
            }
        }
    }

}
