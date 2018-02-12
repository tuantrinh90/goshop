package com.goshop.app.presentation.home;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.presentation.model.widget.CarouselItemsVM;
import com.goshop.app.presentation.model.widget.ProductItemVM;
import com.goshop.app.presentation.model.widget.WidgetSinglePictureVM;
import com.goshop.app.presentation.model.widget.WidgetViewModel;
import com.goshop.app.presentation.shopping.ProductDetailActivity;
import com.goshop.app.widget.WidgetListener.OnBannerItemClickListener;
import com.goshop.app.widget.WidgetListener.OnProductItemClickListener;
import com.goshop.app.widget.WidgetListener.OnSinglePicturClickListener;
import com.goshop.app.widget.WidgetViewAdapter;

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

import static com.goshop.app.utils.PageIntentUtils.PROMOTION_BANNER_URL;

/**
 * Created by helen on 2018/2/11.
 */

public class HomePageFragment extends BaseFragment<HomePageContract.Presenter> implements
    HomePageContract.View, OnProductItemClickListener, OnBannerItemClickListener,
    OnSinglePicturClickListener {

    @BindView(R.id.recyclerview_home)
    RecyclerView recyclerviewHome;

    Unbinder unbinder;

    private WidgetViewAdapter viewAdapter;

    public static HomePageFragment getInstance() {
        return new HomePageFragment();
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
        return R.layout.fragment_home_page;
    }

    @Override
    public void initView() {
        initPresenter();
        initRecyclerview();
    }

    @Override
    public void setup() {
        //TODO(helen) wait for api
        mPresenter.homePageRequest(null);

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
        recyclerviewHome.setLayoutManager(manager);
        viewAdapter = new WidgetViewAdapter(new ArrayList<>());
        recyclerviewHome.setAdapter(viewAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void homePageResult(List<WidgetViewModel> widgetViewModels) {
        viewAdapter.setOnBannerItemClickListener(this);
        viewAdapter.setOnProductItemClickListener(this);
        viewAdapter.setUpdateDatas(widgetViewModels);
    }

    @Override
    public void onProductItemClick(ProductItemVM productItemVM) {
        startActivity(new Intent(getActivity(), ProductDetailActivity.class));
    }

    @Override
    public void onBannerItemClick(CarouselItemsVM carouselItemsVM) {
        Intent intent = new Intent(getActivity(), PromotionBannerActivity.class);
        intent.putExtra(PROMOTION_BANNER_URL, carouselItemsVM.getImage());
        startActivity(intent);
    }

    @Override
    public void onSinglePictureClick(WidgetSinglePictureVM singlePictureVM) {
        Intent intent = new Intent(getActivity(), PromotionLandingListActivity.class);
        intent.putExtra(PROMOTION_BANNER_URL, singlePictureVM.getImageUrl());
        startActivity(intent);
    }
}
