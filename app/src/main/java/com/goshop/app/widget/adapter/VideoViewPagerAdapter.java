package com.goshop.app.widget.adapter;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.presentation.model.widget.VideoPlayerItemsVM;
import com.goshop.app.widget.listener.OnProductBuyClickListener;
import com.goshop.app.widget.listener.OnProductItemClickListener;

import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

public class VideoViewPagerAdapter extends PagerAdapter {

    private OnProductBuyClickListener buyClickListener;

    private OnPagerHeightChangeListener onPagerHeightChangeListener;

    private OnProductItemClickListener onProductItemClickListener;

    private List<VideoPlayerItemsVM> videoPlayerItemsVMS;

    public VideoViewPagerAdapter(
        List<VideoPlayerItemsVM> videoPlayerItemsVMS) {
        this.videoPlayerItemsVMS = videoPlayerItemsVMS;
    }

    public void setUpdateDatas(List<VideoPlayerItemsVM> videoPlayerItemsVMS) {
        this.videoPlayerItemsVMS.clear();
        this.videoPlayerItemsVMS = videoPlayerItemsVMS;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return videoPlayerItemsVMS.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View pagerLayout = LayoutInflater.from(container.getContext())
            .inflate(R.layout.item_video_viewpager, container, false);
        ImageView ivOnAirVideo = pagerLayout.findViewById(R.id.iv_on_air_video);
        LinearLayout llImageViewMore = pagerLayout.findViewById(R.id.ll_image_view_more);
        RecyclerView recyclerViewVideoBuy = pagerLayout.findViewById(R.id.recyclerview_video_buy);
        Glide.with(container.getContext()).load("").asBitmap()
            .error(R.drawable.ic_video)
            .into(ivOnAirVideo);
        List<ProductsVM> productsVMS = videoPlayerItemsVMS.get(position).getProductsVMS();
        VideoProductItemAdapter listAdapter = new VideoProductItemAdapter(productsVMS,
            onProductItemClickListener, buyClickListener);
        LinearLayoutManager productLayoutManager = new LinearLayoutManager(container.getContext());
        recyclerViewVideoBuy.setLayoutManager(productLayoutManager);
        recyclerViewVideoBuy.setAdapter(listAdapter);
        llImageViewMore.setSelected(false);
        listAdapter.updateProductList(false);

        llImageViewMore.setOnClickListener(v -> {
            int itemHeight = listAdapter.getItemMeasuredHeight();
            Log.d("VideoPagerAdapter", "itemHeight-->" + itemHeight);
            //todo please done delete
            llImageViewMore.setSelected(!llImageViewMore.isSelected());
            onPagerHeightChangeListener.onHeightChange(position, (productsVMS.size() - 1) * itemHeight,
                llImageViewMore.isSelected());
            listAdapter.updateProductList(llImageViewMore.isSelected());
        });
        container.addView(pagerLayout);
        return pagerLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    public void setOnProductItemClickListener(
        OnProductItemClickListener onProductItemClickListener) {
        this.onProductItemClickListener = onProductItemClickListener;
    }

    public void setOnProductBuyClickListener(OnProductBuyClickListener onProductBuyClickListener) {
        this.buyClickListener = onProductBuyClickListener;
    }

    public void setOnPagerHeightChangeListener(
        OnPagerHeightChangeListener onPagerHeightChangeListener) {
        this.onPagerHeightChangeListener = onPagerHeightChangeListener;
    }

    public interface OnPagerHeightChangeListener {

        void onHeightChange(int position, int height, boolean isExpand);
    }
}
