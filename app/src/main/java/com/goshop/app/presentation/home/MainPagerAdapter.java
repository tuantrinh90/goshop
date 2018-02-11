package com.goshop.app.presentation.home;

import com.goshop.app.base.BaseFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by helen on 2018/2/11.
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private List<BaseFragment> fragments = new ArrayList<>();

    private String[] tabTitle;

    public MainPagerAdapter(FragmentManager manager, List<BaseFragment> fragments,
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
