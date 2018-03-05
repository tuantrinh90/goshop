package com.goshop.app.presentation.goloyalty;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.presentation.model.GoLoyaltyDealsVM;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class ExpiredFragment extends BaseFragment<ExpiredContract.Presenter> implements
    ExpiredContract.View {

    @BindView(R.id.recyclerview_expired)
    RecyclerView recyclerviewExpired;

    Unbinder unbinder;

    private ExpiredAdapter expiredAdapter;

    public static ExpiredFragment getInstance() {
        return new ExpiredFragment();
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
        return R.layout.fragment_expired;
    }

    @Override
    public void initView() {
        initPresenter();
        initRecyclerView();
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerviewExpired.setLayoutManager(layoutManager);
        expiredAdapter = new ExpiredAdapter(new ArrayList<>());
        recyclerviewExpired.setAdapter(expiredAdapter);
    }

    @Override
    public void setup() {
        //todo wait for api
        mPresenter.expiredRequest(null);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showExpiredResult(List<GoLoyaltyDealsVM> dealsVMS) {
        expiredAdapter.setUpdateDatas(dealsVMS);
    }
}
