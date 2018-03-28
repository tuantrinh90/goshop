package com.goshop.app.presentation.shopping;

import com.goshop.app.base.BaseFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PdpVideoImageAdapter extends FragmentStatePagerAdapter {

    private List<BaseFragment> fragments = new ArrayList<>();

    public PdpVideoImageAdapter(FragmentManager manager, List<BaseFragment> fragments) {
        super(manager);
        this.fragments = fragments;
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
    public Fragment getItem(int position) {
        if (fragments != null && position < fragments.size()) {
            return fragments.get(position);
        }
        return null;
    }
}
