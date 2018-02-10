package com.goshop.app.widget;

import com.bumptech.glide.Glide;
import com.goshop.app.R;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by helen on 2018/2/10.
 */

public class WidgetBannerAdapter extends PagerAdapter {

    private Context context;

    private List<String> imageUrls;

    public WidgetBannerAdapter(Context context, List<String> imageUrls) {
        this.context = context;
        this.imageUrls = imageUrls;
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View imageLayout = LayoutInflater.from(context)
            .inflate(R.layout.item_widget_banner, container, false);
        final ImageView imageView = imageLayout
            .findViewById(R.id.iv_widget_banner);
        Glide.with(context).load(imageUrls.get(position)).into(imageView);
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

}
