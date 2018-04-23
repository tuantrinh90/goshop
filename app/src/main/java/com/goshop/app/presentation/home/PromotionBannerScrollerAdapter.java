package com.goshop.app.presentation.home;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.presentation.model.PromotionBannerModel;
import com.goshop.app.presentation.model.PromotionBannerScrollerVM;
import com.goshop.app.presentation.model.PromotionBannerTopVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.widget.adapter.ProductGridHorizontalAdapter;
import com.goshop.app.widget.listener.OnProductItemClickListener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PromotionBannerScrollerAdapter extends RecyclerView.Adapter {

    private List<PromotionBannerModel> models;

    public PromotionBannerScrollerAdapter(
        List<PromotionBannerModel> models) {
        this.models = models;
    }

    public void setUpdateDatas(List<PromotionBannerModel> models) {
        this.models.clear();
        this.models = models;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case PromotionBannerModel.VIEW_TOP_BANNER:
                View topView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_sku_banner, parent, false);
                viewHolder = new TopViewHolder(topView);
                break;
            case PromotionBannerModel.VIEW_CENTER_BANNER:
                View centerView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_widget_single_picture_top_space, parent, false);
                viewHolder = new CenterViewHolder(centerView);
                break;
            case PromotionBannerModel.VIEW_SCROLLER:
                View scrollerView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_widget_horizontal, parent, false);
                viewHolder = new ScrollerViewHolder(scrollerView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TopViewHolder) {
            ((TopViewHolder) holder).bindingData((PromotionBannerTopVM) models.get(position));
        } else if (holder instanceof ScrollerViewHolder) {
            ((ScrollerViewHolder) holder).bindingData(
                (PromotionBannerScrollerVM) models.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        return models.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class TopViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_sku_banner)
        ImageView ivSkuBanner;

        public TopViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(PromotionBannerTopVM bannerTopVM) {
            Glide.with(itemView.getContext()).load(bannerTopVM.getBannerUrl()).asBitmap()
                .error(bannerTopVM.getBannerDefault())
                .into(ivSkuBanner);
        }
    }

    class CenterViewHolder extends RecyclerView.ViewHolder {

        public CenterViewHolder(View itemView) {
            super(itemView);
        }
    }

    class ScrollerViewHolder extends RecyclerView.ViewHolder implements OnProductItemClickListener {

        @BindView(R.id.recyclerview_horizontal)
        RecyclerView recyclerView;

        public ScrollerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(PromotionBannerScrollerVM scrollerVM) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(layoutManager);
            ProductGridHorizontalAdapter horizontalAdapter = new
                ProductGridHorizontalAdapter(
                scrollerVM.getProductsVMS());
            recyclerView.setAdapter(horizontalAdapter);
            horizontalAdapter.setOnProductItemClickListener(this::onProductItemClick);
        }

        @Override
        public void onProductItemClick(ProductsVM productItemVM) {

        }
    }

}
