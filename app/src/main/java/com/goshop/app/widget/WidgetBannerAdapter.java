package com.goshop.app.widget;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.presentation.model.widget.CarouselItemsVM;
import com.goshop.app.widget.WidgetListener.OnBannerItemClickListener;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class WidgetBannerAdapter extends PagerAdapter {

    private List<CarouselItemsVM> itemsVMS;

    private OnBannerItemClickListener onBannerItemClickListener;

    public WidgetBannerAdapter(List<CarouselItemsVM> itemsVMS,
        OnBannerItemClickListener onBannerItemClickListener) {
        this.itemsVMS = itemsVMS;
        this.onBannerItemClickListener = onBannerItemClickListener;
    }

    @Override
    public int getCount() {
        return itemsVMS.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View imageLayout = LayoutInflater.from(container.getContext())
            .inflate(R.layout.item_widget_banner, container, false);
        CarouselItemsVM itemsVM = itemsVMS.get(position);
        final ImageView imageView = imageLayout
            .findViewById(R.id.iv_widget_banner);
        Glide.with(container.getContext()).load(itemsVM.getImage()).into(imageView);
        container.addView(imageLayout, 0);
        imageView.setOnClickListener(v -> onBannerItemClickListener.onBannerItemClick(itemsVM));
        return imageLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

}
