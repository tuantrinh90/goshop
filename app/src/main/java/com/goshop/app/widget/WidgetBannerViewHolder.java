package com.goshop.app.widget;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomPagerCircleIndicator;
import com.goshop.app.common.view.CustomPagerIndicator;
import com.goshop.app.presentation.model.WidgetBannerVM;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by helen on 2018/2/10.
 */

public class WidgetBannerViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.viewpager_widget_banner)
    ViewPager viewpagerWidgetBanner;
    @BindView(R.id.indicator_widget)
    CustomPagerIndicator indicatorWidget;

    public WidgetBannerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bindingData(WidgetBannerVM bannerVM) {
        viewpagerWidgetBanner.setAdapter(new WidgetBannerAdapter(itemView.getContext(), bannerVM.getUrls()));
        indicatorWidget.setViewPager(viewpagerWidgetBanner);
        BannerAutoPlayHelper bannerAutoPlayHelper = new BannerAutoPlayHelper(viewpagerWidgetBanner);
        bannerAutoPlayHelper.autoPlay();
    }
}
