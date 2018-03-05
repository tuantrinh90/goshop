package com.goshop.app.presentation.goloyalty;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.common.view.CustomBoldTabLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MyRewardsActivity extends BaseActivity {

    @BindView(R.id.tablayout_my_rewards)
    CustomBoldTabLayout tablayoutMyRewards;

    @BindView(R.id.viewpager_my_rewards)
    ViewPager viewpagerMyRewards;

    private MyRewardsPagerAdapter rewardsPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_my_rewards;
    }

    @Override
    public void inject() {
        hideRightMenu();
        initTabLayoutViewPager();
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
                break;
        }
    }
}
