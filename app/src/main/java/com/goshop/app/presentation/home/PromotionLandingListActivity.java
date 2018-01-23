package com.goshop.app.presentation.home;

import com.goshop.app.Const;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.adapter.PromotionListAdapter;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.data.model.response.PromotionBannerResponse;
import com.goshop.app.data.model.response.PromotionListResponse;
import com.goshop.app.utils.AnimUtils;
import com.goshop.app.utils.PageIntentUtils;
import com.orhanobut.logger.Logger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

/**
 * Created by img on 2018/1/18.
 */

public class PromotionLandingListActivity extends BaseActivity<PromotionContract.Presenter> implements PromotionContract.View {

    @BindView(R.id.rl_top_condition_bar)
    RelativeLayout rlTopConditionBar;

    @BindView(R.id.recycler_promotion_content_list)
    RecyclerView recyclerSearchContentList;

    @BindView(R.id.imageview_left_menu)
    ImageView imageviewLeftMenu;

    private static final int TOP_BANNER_POS = 0;

    private static final int TOP_FILTER_BAR_POS = 1;

    int firstVisibleItemPosition;
    private String topBannerUrl;

    @Override
    public int getContentView() {
        return R.layout.acitivity_promotion_list;
    }

    @Override
    public String getScreenTitle() {
        return getString(R.string.promotion_item_new_symbol);
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initIntent();
        mPresenter.getPromotionList(new HashMap<>());
        imageviewLeftMenu.setBackgroundResource(R.mipmap.back);
    }

    private void initIntent(){
        Intent intent = getIntent();
        if (intent!=null){
            topBannerUrl = intent.getStringExtra(PageIntentUtils.PROMOTION_BANNER_URL);
        }
    }

    private void initRecycler(List<PromotionListResponse.PromotionItem> datas) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == Const.PROMOTION_TOP_BANNER || position == Const.PROMOTION_TOP_BAR) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
        recyclerSearchContentList.setLayoutManager(gridLayoutManager);
        PromotionListAdapter promotionLandingHomeAdapter = new PromotionListAdapter(
            topBannerUrl,datas);
        promotionLandingHomeAdapter.setiRecyclerItemClick((view, position) -> {
            switch (view.getId()) {
                case R.id.ll_promotion_filter:
                    clickFilter();
                    break;
                case R.id.ll_promotion_new_arrivals:
                    clickNewArrivals();
                    break;
            }
        });
        recyclerSearchContentList
            .setAdapter(promotionLandingHomeAdapter);
        rlTopConditionBar.setVisibility(View.GONE);
        recyclerSearchContentList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE:
                        if (firstVisibleItemPosition == TOP_BANNER_POS) {
                            rlTopConditionBar.setVisibility(View.GONE);
                        } else if (firstVisibleItemPosition == TOP_FILTER_BAR_POS) {
                            rlTopConditionBar.setVisibility(View.VISIBLE);
                        } else {
                            AnimUtils.setFilterBarAnim(rlTopConditionBar, true);
                        }
                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        break;
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof GridLayoutManager) {
                    GridLayoutManager gridLayout = (GridLayoutManager) layoutManager;
                    firstVisibleItemPosition = gridLayout.findFirstVisibleItemPosition();
                    if (firstVisibleItemPosition > TOP_FILTER_BAR_POS && rlTopConditionBar
                        .getVisibility() == View.VISIBLE) {
                        AnimUtils.setFilterBarAnim(rlTopConditionBar, false);
                    }
                }
            }
        });
    }

    private void clickFilter() {
        //TODO joyson temp code
        Logger.e("filter");
    }

    private void clickNewArrivals() {
        //TODO joyson temp code
        Logger.e("new_arrivals");
    }

    @OnClick({R.id.ll_promotion_filter, R.id.ll_promotion_new_arrivals, R.id.imageview_left_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_promotion_filter:
                clickFilter();
                break;
            case R.id.ll_promotion_new_arrivals:
                clickNewArrivals();
                break;
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }

    @Override
    public void showPromotionList(PromotionListResponse response) {
        initRecycler(response.getPromotionItems());
    }

    @Override
    public void showPromotionBanner(PromotionBannerResponse response) {

    }

    @Override
    public void showNetwordErrorMessage() {

    }

    @Override
    public void showFaildMessage(String errorMessage) {

    }
}
