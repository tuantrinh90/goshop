package com.goshop.app.presentation.shopping;

import com.bumptech.glide.Glide;
import com.goshop.app.R;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class PdpBannerAdapter extends PagerAdapter {

    private OnPdpBannerClickListener bannerClickListener;

    private List<String> imageUrls;

    public PdpBannerAdapter(List<String> imageUrls, OnPdpBannerClickListener bannerClickListener) {
        this.bannerClickListener = bannerClickListener;
        this.imageUrls = imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View imageLayout = LayoutInflater.from(container.getContext())
            .inflate(R.layout.item_pdp_banner, container, false);
        final ImageView imageView = imageLayout
            .findViewById(R.id.iv_pdp_banner);
        imageView.setOnClickListener(v -> bannerClickListener.onBannerClick());
        Glide.with(container.getContext()).load(imageUrls.get(position))
            .error(R.drawable.ic_image_404_small).into(imageView);
        container.addView(imageLayout, 0);
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

    public interface OnPdpBannerClickListener {

        void onBannerClick();
    }
}
