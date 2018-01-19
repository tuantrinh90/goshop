package com.goshop.app.adapter;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.data.model.response.PromotionLandingResponse;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by img on 2018/1/18.
 */

public class BannnerPromotionLandingAdapter extends RecyclerView.Adapter {



    private List<PromotionLandingResponse> datas=new ArrayList<>();

    public BannnerPromotionLandingAdapter(
        List<PromotionLandingResponse> datas) {
        this.datas = datas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_promotion_landing_content, parent, false);
        return new PromotionHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        PromotionHolder holder = (PromotionHolder) viewHolder;
        PromotionLandingResponse response = datas.get(position);
        Glide.with(holder.ivPromotionIcon.getContext()).load(response.getImageUrl()).into(holder.ivPromotionIcon);
        holder.rlPromotionItemGiftSymbol.setVisibility(setViewIsVisible(response.isGiftShow()));
        holder.rlItemLeftTopTv.setVisibility(setViewIsVisible(response.isTvShow()));
        holder.tvPromotionItemNewSymbol.setVisibility(setViewIsVisible(response.isNew()));
        holder.tvPromotionItemSaleSymbol.setText(response.getProductOff());
        holder.tvSearchItemProductName.setText(response.getProductName());
        holder.tvPromotionItemProductOldPrice.setText(response.getProductOldPrice());
        holder.tvPromotionItemProductPrice.setText(response.getProductCurrentPrice());
        if (position%2==0){
            holder.viewCenterLine.setVisibility(setViewIsVisible(true));
        }else {
            holder.viewCenterLine.setVisibility(setViewIsVisible(false));
        }

    }

    private int setViewIsVisible(boolean isShow){
        return isShow?View.VISIBLE:View.GONE;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }



    static class PromotionHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_promotion_icon)
        ImageView ivPromotionIcon;

        @BindView(R.id.rl_item_left_top_tv)
        RelativeLayout rlItemLeftTopTv;

        @BindView(R.id.tv_promotion_item_new_symbol)
        CustomTextView tvPromotionItemNewSymbol;

        @BindView(R.id.tv_promotion_item_sale_symbol)
        CustomTextView tvPromotionItemSaleSymbol;

        @BindView(R.id.iv_promotion_item_gift_symbol)
        ImageView ivPromotionItemGiftSymbol;

        @BindView(R.id.rl_promotion_item_gift_symbol)
        RelativeLayout rlPromotionItemGiftSymbol;

        @BindView(R.id.rl_promotion_image_root)
        RelativeLayout rlPromotionImageRoot;

        @BindView(R.id.tv_promotion_item_product_name)
        CustomTextView tvSearchItemProductName;

        @BindView(R.id.tv_promotion_item_product_old_price)
        CustomTextView tvPromotionItemProductOldPrice;

        @BindView(R.id.tv_promotion_item_product_price)
        CustomTextView tvPromotionItemProductPrice;

        @BindView(R.id.view_center_line)
        View viewCenterLine;

        @BindView(R.id.view_bottom_line)
        View viewBottomLine;

        @BindView(R.id.rl_promotion_root)
        RelativeLayout rlPromotionRoot;

        @OnClick(R.id.rl_promotion_root)
        public void onViewClicked() {
        }

        public PromotionHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
