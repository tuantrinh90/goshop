package com.goshop.app.presentation.home;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.presentation.model.BrandsVM;

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

public class BrandsFragment extends BaseFragment<BrandsContract.Presenter> implements
    BrandsContract.View, BrandsAdapter.OnBrandsItemClickListener {

    @BindView(R.id.recyclerview_brands)
    RecyclerView recyclerviewBrands;

    Unbinder unbinder;

    private BrandsAdapter adapter;

    public static BrandsFragment getInstance() {
        return new BrandsFragment();
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
        mPresenter.brandsRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_brands;
    }

    public void initView() {
        initRecyclerview();
    }

    private void initRecyclerview() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerviewBrands.setLayoutManager(manager);
        adapter = new BrandsAdapter(new ArrayList<>(), this);
        recyclerviewBrands.setAdapter(adapter);
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
    public void showResult(List<BrandsVM> brandsVMS) {
        adapter.setUpdateDatas(brandsVMS);
    }

    @Override
    public void onBrandsItemClick() {
        startActivity(new Intent(getActivity(), BrandsDetailActivity.class));
    }
}
