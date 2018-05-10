package com.goshop.app.presentation.goloyalty;

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

public class ExpiredFragment extends BaseFragment<ExpiredContract.Presenter> implements
    ExpiredContract.View {

    @BindView(R.id.recyclerview_expired)
    RecyclerView recyclerviewExpired;

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
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        //todo wait for api
        mPresenter.expiredRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_expired;
    }

    public void initView() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerviewExpired.setLayoutManager(layoutManager);
        expiredAdapter = new ExpiredAdapter(new ArrayList<>());
        recyclerviewExpired.setAdapter(expiredAdapter);
    }

    @Override
    public void inject() {
        initPresenterComponent().inject(this);
    }

    @Override
    public void showExpiredResult(List<GoLoyaltyDealsVM> dealsVMS) {
        expiredAdapter.setUpdateDatas(dealsVMS);
    }
}
