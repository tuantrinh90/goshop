//package com.goshop.app.presentation.shopping;
//
//import com.goshop.app.R;
//import com.goshop.app.common.view.CustomPagerIndicator;
//import com.goshop.app.presentation.model.widget.CarouselItemsVM;
//import com.goshop.app.widget.adapter.WidgetBannerAdapter;
//import com.goshop.app.widget.listener.OnBannerItemClickListener;
//
//import android.support.v4.view.ViewPager;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//
//import java.util.List;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//public class ShoppingCartBannerViewHolder extends RecyclerView.ViewHolder {
//
//    @BindView(R.id.indicator_widget)
//    CustomPagerIndicator indicatorWidget;
//
//    @BindView(R.id.viewpager_widget_banner)
//    ViewPager viewpagerWidgetBanner;
//
//    public ShoppingCartBannerViewHolder(View itemView) {
//        super(itemView);
//        ButterKnife.bind(this, itemView);
//    }
//
//    public void bindingData(ProductCartBannerVM productCartBannerVM,
//        OnBannerItemClickListener onBannerItemClickListener) {
//        List<CarouselItemsVM> itemsVMS = productCartBannerVM.getCarouselItemsVMS();
//        viewpagerWidgetBanner
//            .setAdapter(new WidgetBannerAdapter(itemsVMS, onBannerItemClickListener));
//        indicatorWidget.setViewPager(viewpagerWidgetBanner);
//    }
//}
