package com.goshop.app.presentation.goloyalty;

import com.goshop.app.base.BaseFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyRewardsPagerAdapter extends FragmentStatePagerAdapter {

    private List<BaseFragment> fragments = new ArrayList<>();

    private String[] tabTitle;

    public MyRewardsPagerAdapter(FragmentManager manager, List<BaseFragment> fragments,
        String[] tabTitle) {
        super(manager);
        this.fragments = fragments;
        this.tabTitle = tabTitle;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position % tabTitle.length];
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments != null && position < fragments.size()) {
            return fragments.get(position);
        }
        return null;
    }
}
