package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.common.view.CustomTextView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BrandsPageFragment extends BaseFragment {

    @BindView(R.id.tv_test)
    CustomTextView tvTest;

    Unbinder unbinder;

    public static BrandsPageFragment getInstance() {
        return new BrandsPageFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {

        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        assert rootView != null;
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_brands_page;
    }

    @Override
    public void initView() {

    }

    @Override
    public void setup() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
