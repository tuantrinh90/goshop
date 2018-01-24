package com.goshop.app.presentation.home;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.adapter.PromotionBannerAdapter;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.data.model.response.PromotionBannerResponse;
import com.goshop.app.data.model.response.PromotionListResponse;
import com.goshop.app.utils.PageIntentUtils;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

/**
 * Created by img on 2018/1/22.
 */

public class PromotionBannerActivity extends BaseActivity<PromotionContract.Presenter> implements
    PromotionContract.View {

    @BindView(R.id.recycler_promotion_banner)
    RecyclerView recyclerPromotionBanner;

    @BindView(R.id.imageview_left_menu)
    ImageView imageviewLeftMenu;

    private String topBannerUrl;

    @Override
    public int getContentView() {
        return R.layout.acitivity_promotion_banner;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageviewLeftMenu.setBackgroundResource(R.mipmap.back);
        initIntent();
        mPresenter.getPromotionBanner(new HashMap<>());
    }

    private void initRecyclerView(List<String> urls) {
        recyclerPromotionBanner.setLayoutManager(new LinearLayoutManager(this));
        recyclerPromotionBanner.setAdapter(
            new PromotionBannerAdapter(topBannerUrl, urls));
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
        initRecyclerView(response.getImageUrl());
    }

    @Override
    public void showNetwordErrorMessage() {

    }

    @Override
    public void showFaildMessage(String errorMessage) {

    }
}
