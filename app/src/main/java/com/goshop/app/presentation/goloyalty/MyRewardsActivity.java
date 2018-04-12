package com.goshop.app.presentation.goloyalty;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.common.view.RobotoMediumTabLayout;
import com.goshop.app.presentation.model.MenuModel;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.widget.adapter.MenuAdapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MyRewardsActivity extends BaseDrawerActivity {

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.tablayout_my_rewards)
    RobotoMediumTabLayout tablayoutMyRewards;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.viewpager_my_rewards)
    ViewPager viewpagerMyRewards;

    private MyRewardsPagerAdapter rewardsPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCurrentMenuType(MenuUtil.MENU_TYPE_MY_REWARDS);
        setContentView(getContentView());
        initToolbar();
        initTabLayoutViewPager();
    }

    private void initToolbar() {
        hideRightMenu();
        imageViewLeftMenu.setImageResource(R.drawable.ic_menu);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_my_rewards;
    }

    @Override
    public void inject() {
        //don't need to override this method now.
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

    @OnClick({R.id.imageview_left_menu})
    public void onMyRewardsClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                openDrawerLayout();
                break;
        }
    }
}
