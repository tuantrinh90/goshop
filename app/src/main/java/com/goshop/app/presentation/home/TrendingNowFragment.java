package com.goshop.app.presentation.home;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.presentation.model.widget.CarouselItemsVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.presentation.model.widget.WidgetSinglePictureVM;
import com.goshop.app.presentation.model.widget.WidgetViewModel;
import com.goshop.app.presentation.shopping.PDPDetailActivity;
import com.goshop.app.presentation.shopping.ShoppingCartActivity;
import com.goshop.app.widget.WidgetViewAdapter;
import com.goshop.app.widget.listener.OnBannerItemClickListener;
import com.goshop.app.widget.listener.OnProductBuyClickListener;
import com.goshop.app.widget.listener.OnProductItemClickListener;
import com.goshop.app.widget.listener.OnSinglePicturClickListener;

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
    TrendingNowContract.View, OnProductItemClickListener, OnBannerItemClickListener,
    OnSinglePicturClickListener, OnProductBuyClickListener {

    private final String BANNER = "promotionlandBanner";

    private final String PRD = "prd";

    private final String SKU = "promotionlandSKU";

    @BindView(R.id.recyclerview_trending)
    RecyclerView recyclerviewTrending;

    Unbinder unbinder;

    private WidgetViewAdapter viewAdapter;

    public static TrendingNowFragment getInstance() {
        return new TrendingNowFragment();
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
        viewAdapter = new WidgetViewAdapter(new ArrayList<>());
        recyclerviewTrending.setAdapter(viewAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void trendingNowResult(List<WidgetViewModel> widgetViewModels) {
        viewAdapter.setOnBannerItemClickListener(this);
        viewAdapter.setOnProductItemClickListener(this);
        viewAdapter.setOnSinglePicturClickListener(this);
        viewAdapter.setOnProductBuyClickListener(this);
        viewAdapter.setUpdateDatas(widgetViewModels);
    }

    @Override
    public void onProductItemClick(ProductsVM productItemVM) {
        startActivity(new Intent(getActivity(), PDPDetailActivity.class));
    }

    @Override
    public void onBannerItemClick(CarouselItemsVM carouselItemsVM) {
        String image = carouselItemsVM.getImage();
        String link = carouselItemsVM.getLink();
        String[] linkKinds = link.split("/");
        startBannerLinkScreen(linkKinds[1], image);
    }

    private void startBannerLinkScreen(String link, String image) {
        Intent intent = null;
        switch (link) {
            case PRD:
                intent = new Intent(getActivity(), PDPDetailActivity.class);
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
    public void onSinglePictureClick(WidgetSinglePictureVM singlePictureVM) {
        Intent intent = new Intent(getActivity(), PromotionSkuActivity.class);
        intent.putExtra(PROMOTION_BANNER_URL,
            singlePictureVM.getOfferListItemsVMS().get(0).getImage());
        startActivity(intent);
    }

    @Override
    public void onBuyNowClick(ProductsVM productItemVM) {
        Intent intent = new Intent(getActivity(), ShoppingCartActivity.class);
        startActivity(intent);
    }
}
