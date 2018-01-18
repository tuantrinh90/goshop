package com.goshop.app.adapter;

import com.bumptech.glide.Glide;
import com.goshop.app.R;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by img on 2018/1/10.
 */

public class SlidingImageAdapter extends PagerAdapter {

    private Context context;

    private List<String> imageUrls;

    public SlidingImageAdapter(Context context, List<String> imageUrls) {
        this.imageUrls = imageUrls;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = LayoutInflater.from(context)
            .inflate(R.layout.item_sliding_image, view, false);
        final ImageView imageView = imageLayout
            .findViewById(R.id.iv_sliding);
        Glide.with(context).load(imageUrls.get(position)).into(imageView);
        view.addView(imageLayout, 0);
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

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }
}