package com.goshop.app.adapter;

import com.bumptech.glide.Glide;
import com.goshop.app.Const;
import com.goshop.app.R;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by img on 2018/1/22.
 */

public class PromotionBannerAdapter extends RecyclerView.Adapter {

    List<String> imgUrls=new ArrayList<>();
    String headBannerUrl;
    public PromotionBannerAdapter(String headBannerUrl,List<String> imgUrls) {
        this.headBannerUrl=headBannerUrl;
        this.imgUrls=imgUrls;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType){
            case Const.PROMOTION_TOP_BANNER:
                View topBannerView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_promotion_header_banner, parent, false);
                viewHolder=new TopBannerHolder(topBannerView);
                break;
            case Const.PROMOTION_LIST_BANNER:
                View bannerListView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_promotion_banner_list, parent, false);
                viewHolder=new BannerListHolder(bannerListView);
                break;
        }
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof TopBannerHolder){
            TopBannerHolder holder= (TopBannerHolder) viewHolder;
            Glide.with(holder.ivPromotionHeader.getContext()).load(headBannerUrl).into(holder.ivPromotionHeader);

        }else if (viewHolder instanceof BannerListHolder){
            BannerListHolder holder= (BannerListHolder) viewHolder;
            Glide.with(holder.ivPromotionBannerItem.getContext()).load(imgUrls.get(position-1)).into(holder.ivPromotionBannerItem);
        }
    }

    @Override
    public int getItemCount() {
        return imgUrls.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return Const.PROMOTION_TOP_BANNER;
        }else {
            return Const.PROMOTION_LIST_BANNER;
        }
    }

    static class TopBannerHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_promotion_header)
        ImageView ivPromotionHeader;
        public TopBannerHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class BannerListHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_promotion_banner_item)
        ImageView ivPromotionBannerItem;
        public BannerListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }
}
