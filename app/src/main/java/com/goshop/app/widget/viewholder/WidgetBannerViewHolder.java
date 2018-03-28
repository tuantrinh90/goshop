package com.goshop.app.widget.viewholder;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomPagerIndicator;
import com.goshop.app.presentation.model.widget.CarouselItemsVM;
import com.goshop.app.presentation.model.widget.WidgetCarouselVM;
import com.goshop.app.widget.BannerAutoPlayHelper;
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

    public void bindingData(WidgetCarouselVM bannerVM,
        OnBannerItemClickListener onBannerItemClickListener) {
        List<CarouselItemsVM> itemsVMS = bannerVM.getCarouselItemsVMS();
        viewpagerWidgetBanner
            .setAdapter(new WidgetBannerAdapter(itemsVMS, onBannerItemClickListener));
        indicatorWidget.setViewPager(viewpagerWidgetBanner);

        if (bannerVM.isAutoEnabled()) {
            BannerAutoPlayHelper bannerAutoPlayHelper = new BannerAutoPlayHelper(
                viewpagerWidgetBanner, bannerVM.getAutoDuration());
            bannerAutoPlayHelper.autoPlay();
        }
    }
}
