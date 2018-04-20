package com.goshop.app.presentation.goloyalty;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.presentation.model.GoLoyaltyDealsVM;

import android.content.Intent;
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

public class PendingFragment extends BaseFragment<PendingContract.Presenter> implements
    PendingContract.View, PendingAdapter.OnRewardsItemClickListener, PendingAdapter
    .OnCardRedeemClickListener {

    @BindView(R.id.recyclerview_pending)
    RecyclerView recyclerviewPending;

    Unbinder unbinder;

    private PendingAdapter pendingAdapter;

    public static PendingFragment getInstance() {
        return new PendingFragment();
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        //todo wait for api
        mPresenter.pendingRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_pending;
    }

    public void initView() {
        initRecyclerview();
    }

    private void initRecyclerview() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerviewPending.setLayoutManager(layoutManager);
        pendingAdapter = new PendingAdapter(new ArrayList<>());
        recyclerviewPending.setAdapter(pendingAdapter);
        pendingAdapter.setOnRewardsItemClickListener(this);
        pendingAdapter.setOnCardRedeemClickListener(this);
    }

    @Override
    public void inject() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showPendingResult(List<GoLoyaltyDealsVM> dealsVMS) {
        pendingAdapter.setUpdateDatas(dealsVMS);
    }

    @Override
    public void onRewardItemClick() {
        startActivity(new Intent(getActivity(), RewardsDetailActivity.class));
    }

    @Override
    public void onCardClick() {
        startActivity(new Intent(getActivity(), CardRedeemActivity.class));
    }
}
