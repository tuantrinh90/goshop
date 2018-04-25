package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.common.CustomSearchEditText;
import com.goshop.app.common.view.RobotoMediumTabLayout;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.search.SearchActivity;
import com.goshop.app.presentation.shopping.ShoppingCartActivity;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.widget.listener.OnScheduleClickListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCurrentMenuType(MenuUtil.MENU_TYPE_HOME);
        setContentView(getContentView());
        initView();
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
    }

    private void initSearchBar() {
        csetSearch.getEditText().setOnFocusChangeListener((View v, boolean hasFocus) -> {
            if (hasFocus) {
                csetSearch.getEditText().clearFocus();
                startActivity(new Intent(MainPageActivity.this, SearchActivity.class));
            }
        });
        ivleftMenu.setImageResource(R.drawable.ic_menu);
    }

    @OnClick({R.id.imageview_right_menu, R.id.imageview_left_menu})
    public void onMainPageClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_right_menu:
                Intent intent = new Intent(this, ShoppingCartActivity.class);
                intent.putExtra(ShoppingCartActivity.EXTRA_ENTRANCE,
                    ShoppingCartActivity.TYPE_ENTRANCE_HOME);
                startActivity(new Intent(this, ShoppingCartActivity.class));
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
        super.onBackPressed();
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
}
