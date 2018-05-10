package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.data.model.response.PromotionBannerResponse;
import com.goshop.app.data.model.response.PromotionListResponse;
import com.goshop.app.presentation.model.PromotionBannerModel;
import com.goshop.app.presentation.model.PromotionBannerTopVM;
import com.goshop.app.utils.PageIntentUtils;
import com.goshop.app.utils.PopWindowUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class PromotionBannerActivity extends BaseActivity<PromotionContract.Presenter> implements
    PromotionContract.View {

    @BindView(R.id.imageview_left_menu)
    ImageView imageviewLeftMenu;

    @BindView(R.id.recycler_promotion_banner)
    RecyclerView recyclerPromotionBanner;

    private PromotionBannerScrollerAdapter bannerScrollerAdapter;

    private String topBannerUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initIntent();
        mPresenter.getPromotionBanner(new HashMap<>());
        // TODO: 2018/4/26 this need delete later
        new Handler().postDelayed(() -> PopWindowUtil.showNoApiPop(recyclerPromotionBanner), 200);
    }

    @Override
    public int getContentView() {
        return R.layout.acitivity_promotion_banner;
    }

    @Override
    public void inject() {
        hideRightMenu();
        initPresenter();
        initRecyclerView();
    }

    private void initPresenter() {
        initPresenterComponent().inject(this);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerPromotionBanner.setLayoutManager(layoutManager);
        bannerScrollerAdapter = new PromotionBannerScrollerAdapter(new ArrayList<>());
        recyclerPromotionBanner.setAdapter(bannerScrollerAdapter);
    }

    @Override
    public String getScreenTitle() {
        return getString(R.string.payday_treat);
    }

    private void initIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            topBannerUrl = intent.getStringExtra(PageIntentUtils.PROMOTION_BANNER_URL);
        }
    }

    @OnClick({R.id.imageview_left_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }

    @Override
    public void showPromotionList(PromotionListResponse response) {

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

    @Override
    public void showPromotionBannerResult(List<PromotionBannerModel> bannerModels) {
        for (PromotionBannerModel model : bannerModels) {
            if (model instanceof PromotionBannerTopVM) {
                ((PromotionBannerTopVM) model).setBannerUrl(topBannerUrl);
            }
        }
        bannerScrollerAdapter.setUpdateDatas(bannerModels);
    }
}
