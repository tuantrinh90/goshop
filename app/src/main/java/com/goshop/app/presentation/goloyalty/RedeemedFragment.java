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

public class RedeemedFragment extends BaseFragment<RedeemedContract.Presenter> implements
    RedeemedContract.View {

    @BindView(R.id.recyclerview_redeemed)
    RecyclerView recyclerviewRedeemed;

    Unbinder unbinder;

    private RedeemedAdapter redeemedAdapter;

    public static RedeemedFragment getInstance() {
        return new RedeemedFragment();
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
        mPresenter.redeemedRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_redeemed;
    }

    public void initView() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerviewRedeemed.setLayoutManager(layoutManager);
        redeemedAdapter = new RedeemedAdapter(new ArrayList<>());
        recyclerviewRedeemed.setAdapter(redeemedAdapter);
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
    public void showRedeemedResult(List<GoLoyaltyDealsVM> dealsVMS) {
        redeemedAdapter.setUpdateDatas(dealsVMS);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
