package com.goshop.app.presentation.home;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.common.view.CustomPagerIndicator;
import com.goshop.app.common.view.irecyclerview.IRecyclerView;
import com.goshop.app.presentation.model.BannerVm;
import com.goshop.app.presentation.model.TrendingNowModel;
import com.goshop.app.presentation.model.widget.CarouselItemsVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.presentation.shopping.ProductDetailActivity;
import com.goshop.app.presentation.shopping.ShoppingCartActivity;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.utils.ScreenHelper;
import com.goshop.app.widget.BannerAutoPlayHelper;
import com.goshop.app.widget.adapter.HomeBannerAdapter;
import com.goshop.app.widget.listener.OnHomeBannerItemClickListener;
import com.goshop.app.widget.listener.OnScheduleClickListener;
import com.goshop.app.widget.listener.OnTrendingNowClickListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

import static com.goshop.app.utils.PageIntentUtils.PROMOTION_BANNER_URL;

public class TrendingNowFragment extends BaseFragment<TrendingNowContract.Presenter> implements
    TrendingNowContract.View, OnTrendingNowClickListener, OnHomeBannerItemClickListener,
    SwipeRefreshLayout.OnRefreshListener {

    private final String BANNER = "promotionlandBanner";

    private final String PRD = "prd";

    private final String SKU = "promotionlandSKU";

    @BindView(R.id.recyclerview_trending)
    IRecyclerView recyclerviewTrending;

    Unbinder unbinder;

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    private OnScheduleClickListener onScheduleClickListener;

    private TrendingNowAdapter trendingNowAdapter;

    private CustomPagerIndicator customPagerIndicator;

    private ViewPager bannerViewPager;

    boolean isHeaderAdded = false;

    private ArrayList<BannerVm> bannerVmList;

    private List<TrendingNowModel> trendingNowModels;

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        mPresenter.getHomeBanner();
        swipeRefresh.setRefreshing(true);
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_trending_now;
    }

    public void initView() {
        initRecyclerView();
    }

    @Override
    public void inject() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);

    }

    private void initRecyclerView() {
        trendingNowModels = new ArrayList<>();
        bannerVmList = new ArrayList<>();
        swipeRefresh.setColorSchemeResources(R.color.color_main_pink);
        swipeRefresh.setOnRefreshListener(this);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerviewTrending.setLayoutManager(manager);
        trendingNowAdapter = new TrendingNowAdapter(this, trendingNowModels);
        recyclerviewTrending.setIAdapter(trendingNowAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void onBannerRequestSuccess(List<BannerVm> bannerVms) {
        mPresenter.getOnAirSchedule(getContext());
        if (!isHeaderAdded) {
            bannerVmList.addAll(bannerVms);
            isHeaderAdded = true;
            addHeaderView();
            bannerViewPager
                .setAdapter(new HomeBannerAdapter(bannerVmList, this));
            customPagerIndicator.setViewPager(bannerViewPager);
            BannerAutoPlayHelper bannerAutoPlayHelper = new BannerAutoPlayHelper(
                bannerViewPager, 2000);
            bannerAutoPlayHelper.autoPlay();
            trendingNowAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onBannerItemClick(BannerVm bannerVm) {
        startBannerLinkScreen(SKU, "");
    }

    private void addHeaderView() {
        View header = LayoutInflater.from(getContext())
            .inflate(R.layout.item_trending_top_banner, null);
        RelativeLayout rlBannerContainer = header.findViewById(R.id.rl_banner_layout);
        customPagerIndicator = header.findViewById(R.id.indicator_widget);
        bannerViewPager = header.findViewById(R.id.viewpager_widget_banner);
        int height = ScreenHelper.dip2px(getContext(),238);
        rlBannerContainer.setLayoutParams(
            new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height));
        recyclerviewTrending.addHeaderView(header);
    }

    @Override
    public void onBannerRequestFailure(String message) {
        swipeRefresh.setRefreshing(false);
        PopWindowUtil.showRequestMessagePop(recyclerviewTrending, message);
    }

    @Override
    public void onAirScheduleRequestFailure(String message) {
        if (recyclerviewTrending != null) {
            PopWindowUtil.showRequestMessagePop(recyclerviewTrending, message);
        }
    }

    @Override
    public void onAirScheduleRequestSuccess(List<TrendingNowModel> trendingNowModels) {
        swipeRefresh.setRefreshing(false);
        this.trendingNowModels.clear();
        this.trendingNowModels.addAll(trendingNowModels);
        trendingNowAdapter.notifyDataSetChanged();
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

    @Override
    public void onRefresh() {
        // TODO: 2018/4/25 refresh need decide
        swipeRefresh.setRefreshing(false);
//        mPresenter.getOnAirSchedule(getContext());
    }
}
