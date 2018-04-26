package com.goshop.app.widget.listener;

import com.goshop.app.presentation.model.widget.CarouselItemsVM;
import com.goshop.app.presentation.model.widget.ProductsVM;

public interface OnTrendingNowClickListener {

    void onTVScheduleClick();

    void onProductItemClick(ProductsVM productsVM);

    void onBuyNowClick();

    void onSingleBannerClick();
}
