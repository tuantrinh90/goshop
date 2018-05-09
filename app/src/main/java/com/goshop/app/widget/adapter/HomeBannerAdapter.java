package com.goshop.app.widget.adapter;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.presentation.model.BannerVm;
import com.goshop.app.utils.GlideUtils;
import com.goshop.app.widget.listener.OnHomeBannerItemClickListener;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class HomeBannerAdapter extends PagerAdapter {

    private List<BannerVm> itemsVMS;

    private OnHomeBannerItemClickListener onBannerItemClickListener;

    public HomeBannerAdapter(List<BannerVm> itemsVMS,
        OnHomeBannerItemClickListener onBannerItemClickListener) {
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
        BannerVm itemsVM = itemsVMS.get(position);
        final ImageView imageView = imageLayout
            .findViewById(R.id.iv_widget_banner);
        GlideUtils.loadImageError(
            container.getContext(),
            itemsVM.getImage(),
            imageView,
            R.drawable.ic_image_404_big);
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
