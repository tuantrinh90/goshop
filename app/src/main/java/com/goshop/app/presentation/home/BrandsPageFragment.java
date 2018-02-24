package com.goshop.app.presentation.home;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.presentation.model.BrandsVM;

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

public class BrandsPageFragment extends BaseFragment<BrandsPageContract.Presenter> implements
    BrandsPageContract.View {

    @BindView(R.id.recyclerview_brands)
    RecyclerView recyclerviewBrands;

    Unbinder unbinder;

    private BrandsPageAdapter adapter;

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
        initPresenter();
        initRecyclerview();
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initRecyclerview() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerviewBrands.setLayoutManager(manager);
        adapter = new BrandsPageAdapter(new ArrayList<>());
        recyclerviewBrands.setAdapter(adapter);
    }

    @Override
    public void setup() {
        //todo wait for api
        mPresenter.brandsPageRequest(null);
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
}
