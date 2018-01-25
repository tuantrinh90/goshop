package com.goshop.app.adapter;

import com.bumptech.glide.Glide;
import com.goshop.app.Const;
import com.goshop.app.R;
import com.goshop.app.common.listener.IRecyclerItemClick;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.data.model.response.PromotionListResponse;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by img on 2018/1/18.
 */

public class PromotionListAdapter extends RecyclerView.Adapter {

    private static final int BANNER_AND_FILTER_BAR_SIZE = 2;

    static IRecyclerItemClick iRecyclerItemClick;

    private List<PromotionListResponse.PromotionItem> datas = new ArrayList<>();

    private String bannerUrl;

    public PromotionListAdapter(String banneUrl,
        List<PromotionListResponse.PromotionItem> datas) {
        this.bannerUrl = banneUrl;
        this.datas = datas;
    }

    public static int setViewIsVisible(boolean isShow) {
        return isShow ? View.VISIBLE : View.GONE;
    }

    public void setiRecyclerItemClick(IRecyclerItemClick iRecyclerItemClick) {
        this.iRecyclerItemClick = iRecyclerItemClick;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case Const.PROMOTION_TOP_BANNER:
                View topBannerView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_promotion_header_banner, parent, false);
                viewHolder = new TopBannerHolder(topBannerView);
                break;
            case Const.PROMOTION_TOP_BAR:
                View topBarView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_promotion_sort_and_filter_bar, parent, false);
                viewHolder = new TopBarHolder(topBarView);
                break;
            case Const.PROMOTION_CONTENT_ITEM:
                View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_promotion_landing_content, parent, false);
                viewHolder = new PromotionHolder(itemView);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof TopBannerHolder) {
            TopBannerHolder holder = (TopBannerHolder) viewHolder;
            Glide.with(holder.itemView.getContext()).load(bannerUrl).into(holder.ivPromotionHeader);
        } else if (viewHolder instanceof TopBarHolder) {
            TopBarHolder topBarHolder = (TopBarHolder) viewHolder;

        } else if (viewHolder instanceof PromotionHolder) {
            PromotionHolder holder = (PromotionHolder) viewHolder;
            holder.bindingData(datas, position - BANNER_AND_FILTER_BAR_SIZE);
        }


    }

    @Override
    public int getItemCount() {
        //topBanner + topFilterBar + datas
        return BANNER_AND_FILTER_BAR_SIZE + datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == Const.PROMOTION_TOP_BANNER) {
            return Const.PROMOTION_TOP_BANNER;
        } else if (position == Const.PROMOTION_TOP_BAR) {
            return Const.PROMOTION_TOP_BAR;
        } else {
            return Const.PROMOTION_CONTENT_ITEM;
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

    static class TopBarHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ll_promotion_filter)
        LinearLayout llPromotionFilter;

        @BindView(R.id.ll_promotion_new_arrivals)
        LinearLayout llPromotionNewArrivals;

        public TopBarHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick({R.id.ll_promotion_filter,
            R.id.ll_promotion_new_arrivals})
        public void onViewClicked(View view) {
            switch (view.getId()) {
                case R.id.ll_promotion_filter:
                    if (iRecyclerItemClick != null) {
                        iRecyclerItemClick.onItemClick(view, 0);
                    }
                    break;
                case R.id.ll_promotion_new_arrivals:

                    if (iRecyclerItemClick != null) {
                        iRecyclerItemClick.onItemClick(view, 0);
                    }
                    break;
            }
        }

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

        public PromotionHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.rl_promotion_root)
        public void onViewClicked() {
        }

        private void bindingData(List<PromotionListResponse.PromotionItem> datas, int position) {
            PromotionListResponse.PromotionItem response = datas.get(position);
            Glide.with(ivPromotionIcon.getContext()).load(response.getImageUrl())
                .into(ivPromotionIcon);
            rlPromotionItemGiftSymbol.setVisibility(setViewIsVisible(response.isGiftShow()));
            rlItemLeftTopTv.setVisibility(setViewIsVisible(response.isTvShow()));
            tvPromotionItemNewSymbol.setVisibility(setViewIsVisible(response.isNew()));
            tvPromotionItemSaleSymbol.setText(response.getProductOff());
            tvSearchItemProductName.setText(response.getProductName());
            tvPromotionItemProductOldPrice.setText(response.getProductOldPrice());
            tvPromotionItemProductPrice.setText(response.getProductCurrentPrice());
            //even number show,odd number not show
            if (position % 2 == 0) {
                viewCenterLine.setVisibility(setViewIsVisible(true));
            } else {
                viewCenterLine.setVisibility(setViewIsVisible(false));
            }
        }

    }
}
