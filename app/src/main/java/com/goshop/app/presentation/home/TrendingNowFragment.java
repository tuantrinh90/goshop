package com.goshop.app.presentation.home;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.presentation.model.TrendingNowModel;
import com.goshop.app.presentation.model.widget.CarouselItemsVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.presentation.shopping.ProductDetailActivity;
import com.goshop.app.presentation.shopping.ShoppingCartActivity;
import com.goshop.app.widget.listener.OnScheduleClickListener;
import com.goshop.app.widget.listener.OnTrendingNowClickListener;

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

public class TrendingNowFragment extends BaseFragment<TrendingNowContract.Presenter> implements
    TrendingNowContract.View, OnTrendingNowClickListener {

    private final String BANNER = "promotionlandBanner";

    private final String PRD = "prd";

    private final String SKU = "promotionlandSKU";

    @BindView(R.id.recyclerview_trending)
    RecyclerView recyclerviewTrending;

    Unbinder unbinder;

    private OnScheduleClickListener onScheduleClickListener;

    private TrendingNowAdapter trendingNowAdapter;

    public static TrendingNowFragment getInstance() {
        return new TrendingNowFragment();
    }

    public void setOnScheduleClickListener(OnScheduleClickListener onScheduleClickListener) {
        this.onScheduleClickListener = onScheduleClickListener;
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
        return R.layout.fragment_trending_now;
    }

    @Override
    public void initView() {
        initPresenter();
        initRecyclerview();
    }

    @Override
    public void setup() {
        //TODO  wait for api
        mPresenter.trendingNowRequest(null);

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
        recyclerviewTrending.setLayoutManager(manager);
        trendingNowAdapter = new TrendingNowAdapter(this, new ArrayList<>());
        recyclerviewTrending.setAdapter(trendingNowAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void trendingNowResult(List<TrendingNowModel> models) {
        trendingNowAdapter.setDatasUpdate(models);
    }

    @Override
    public void onTopBannerClick(CarouselItemsVM carouselItemsVM) {
        //todo wait for api
        /*String image = carouselItemsVM.getImage();
        String link = carouselItemsVM.getLink();
        String[] linkKinds = link.split("/");*/
        startBannerLinkScreen(SKU, "");
    }

    @Override
    public void onTVScheduleClick() {
        onScheduleClickListener.onScheduleClick();
    }

    @Override
    public void onProductItemClick(ProductsVM productItemVM) {
        startActivity(new Intent(getActivity(), ProductDetailActivity.class));
    }

    @Override
    public void onBuyNowClick() {
        Intent intent = new Intent(getActivity(), ShoppingCartActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSingleBannerClick() {
        Intent intent = new Intent(getActivity(), PromotionSkuActivity.class);
        startActivity(intent);
    }

    private void startBannerLinkScreen(String link, String image) {
        Intent intent = null;
        switch (link) {
            case PRD:
                intent = new Intent(getActivity(), ProductDetailActivity.class);
                intent.putExtra(PROMOTION_BANNER_URL, image);
                break;
            case SKU:
                intent = new Intent(getActivity(), PromotionSkuActivity.class);
                intent.putExtra(PROMOTION_BANNER_URL, image);
                break;
            case BANNER:
                intent = new Intent(getActivity(), PromotionBannerActivity.class);
                intent.putExtra(PROMOTION_BANNER_URL, image);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
