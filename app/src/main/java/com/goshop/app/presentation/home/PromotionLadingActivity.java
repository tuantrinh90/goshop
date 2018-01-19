package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.adapter.BannnerPromotionLandingAdapter;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.utils.ServiceData;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by img on 2018/1/18.
 */

public class PromotionLadingActivity extends BaseActivity {

    @BindView(R.id.ll_promotion_filter)
    LinearLayout llPromotionFilter;

    @BindView(R.id.ll_promotion_new_arrivals)
    LinearLayout llPromotionNewArrivals;

    @BindView(R.id.recycler_search_content_list)
    RecyclerView recyclerSearchContentList;

    @BindView(R.id.imageview_left_menu)
    ImageView imageviewLeftMenu;

    @Override
    public int getContentView() {
        return R.layout.acitivity_promotion_landing;
    }

    @Override
    public String getScreenTitle() {
        return getString(R.string.promotion_item_new_symbol);
    }

    @Override
    public void inject() {
//        DaggerPresenterComponent.builder()
//            .applicationComponent(GoShopApplication.getApplicationComponent())
//            .presenterModule(new PresenterModule(this))
//            .build()
//            .inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRecycler();
        imageviewLeftMenu.setBackgroundResource(R.mipmap.back);

    }

    private void initRecycler() {
        recyclerSearchContentList.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerSearchContentList
            .setAdapter(new BannnerPromotionLandingAdapter(ServiceData.getPromotionLandingData()));
        recyclerSearchContentList.setNestedScrollingEnabled(false);
    }

    @OnClick({R.id.ll_promotion_filter, R.id.ll_promotion_new_arrivals,R.id.imageview_left_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_promotion_filter:
                break;
            case R.id.ll_promotion_new_arrivals:
                break;
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }

}
