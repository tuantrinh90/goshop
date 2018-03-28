package com.goshop.app.presentation.shopping;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.presentation.model.ImagesVM;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class PdpImagesPagerAdapter extends PagerAdapter {

    private List<ImagesVM> imageUrls;

    public PdpImagesPagerAdapter(List<ImagesVM> imageUrls) {
        this.imageUrls = imageUrls;
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View imageLayout = LayoutInflater.from(container.getContext())
            .inflate(R.layout.item_images_page, container, false);
        ImageView imageView = imageLayout.findViewById(R.id.iv_item_pdp_image);
        Glide.with(container.getContext()).load(imageUrls.get(position).getImageUrl())
            .error(imageUrls.get(position).getImageDefault()).into(imageView);
        container.addView(imageLayout);
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
