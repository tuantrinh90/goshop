package com.goshop.app.widget.listener;

import com.goshop.app.presentation.model.widget.CarouselItemsVM;
import com.goshop.app.presentation.model.widget.VideoProductsVM;

public interface OnTrendingNowClickListener {

    void onTopBannerClick(CarouselItemsVM carouselItemsVM);

    void onTVScheduleClick();

    void onProductItemClick(VideoProductsVM productsVM);

    void onBuyNowClick();

    void onSingleBannerClick();
}
