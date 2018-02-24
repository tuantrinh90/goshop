package com.goshop.app.widget;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomPagerIndicator;
import com.goshop.app.presentation.model.widget.CarouselAutoPlayVM;
import com.goshop.app.presentation.model.widget.CarouselItemsVM;
import com.goshop.app.presentation.model.widget.WidgetCarouselVM;
import com.goshop.app.widget.adapter.WidgetBannerAdapter;
import com.goshop.app.widget.listener.OnBannerItemClickListener;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WidgetBannerViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.indicator_widget)
    CustomPagerIndicator indicatorWidget;

    @BindView(R.id.viewpager_widget_banner)
    ViewPager viewpagerWidgetBanner;

    public WidgetBannerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bindingData(WidgetCarouselVM bannerVM,
        OnBannerItemClickListener onBannerItemClickListener) {
        List<CarouselItemsVM> itemsVMS = bannerVM.getData().getItems();
        viewpagerWidgetBanner
            .setAdapter(new WidgetBannerAdapter(itemsVMS, onBannerItemClickListener));
        indicatorWidget.setViewPager(viewpagerWidgetBanner);
        CarouselAutoPlayVM autoPlayVM = bannerVM.getAutoPlay();
        if (autoPlayVM.isEnabled()) {
            BannerAutoPlayHelper bannerAutoPlayHelper = new BannerAutoPlayHelper(
                viewpagerWidgetBanner, autoPlayVM.getDuration());
            bannerAutoPlayHelper.autoPlay();
        }
    }
}
