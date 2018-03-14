package com.goshop.app.presentation.home;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.data.model.PromotionSkuModel;
import com.goshop.app.data.model.SkuBannerVM;
import com.goshop.app.data.model.SkuFilterWithDataVM;
import com.goshop.app.presentation.model.SortVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.widget.adapter.WidgetProductGridVerticalAdapter;
import com.goshop.app.widget.listener.OnProductItemClickListener;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PromotionSkuAdapter extends RecyclerView.Adapter {

    private OnPromotionSkuItemClickListener onPromotionSkuItemClickListener;

    private List<PromotionSkuModel> skuModels;

    public PromotionSkuAdapter(List<PromotionSkuModel> skuModels) {
        this.skuModels = skuModels;
    }

    public void setUpdateDatas(List<PromotionSkuModel> skuModels) {
        this.skuModels.clear();
        this.skuModels = skuModels;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case PromotionSkuModel.TYPE_BANNER:
                View bannerView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_sku_banner, parent, false);
                viewHolder = new SkuBannerViewHolder(bannerView);
                break;
            case PromotionSkuModel.TYPE_FILTER_WITH_DATA:
                View filterDataView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_sort_filter, parent, false);
                viewHolder = new SkuFilterWithDataViewHolder(filterDataView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SkuBannerViewHolder) {
            ((SkuBannerViewHolder) holder).bindingData((SkuBannerVM) skuModels.get(position));
        } else if (holder instanceof SkuFilterWithDataViewHolder) {
            ((SkuFilterWithDataViewHolder) holder).bindingData(
                (SkuFilterWithDataVM) skuModels.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        return skuModels.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return skuModels.size();
    }

    public void setOnPromotionSkuItemClickListener(
        OnPromotionSkuItemClickListener onPromotionSkuItemClickListener) {
        this.onPromotionSkuItemClickListener = onPromotionSkuItemClickListener;
    }

    interface OnPromotionSkuItemClickListener {

        void onFilterDrawerClick();
    }

    class SkuBannerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_sku_banner)
        ImageView ivSkuBanner;

        public SkuBannerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(SkuBannerVM bannerVM) {
            Glide.with(itemView.getContext()).load(bannerVM.getBannerUrl()).asBitmap()
                .error(bannerVM.getBannerDefault())
                .into(ivSkuBanner);
        }
    }

    class SkuFilterWithDataViewHolder extends RecyclerView.ViewHolder implements
        OnProductItemClickListener, PopWindowUtil.OnPopWindowDismissListener {

        @BindView(R.id.iv_btn_data_filter)
        ImageView ivBtnDataFilter;

        @BindView(R.id.iv_sort_data_arrow)
        ImageView ivSortDataArrow;

        @BindView(R.id.recyclerview_filter)
        RecyclerView recyclerViewFilter;

        @BindView(R.id.tv_btn_data_sort)
        CustomTextView tvBtnDataSort;

        private List<SortVM> sortVMS;

        public SkuFilterWithDataViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(SkuFilterWithDataVM filterWithDataVM) {

            ivSortDataArrow.setSelected(false);
            tvBtnDataSort.setSelected(false);
            sortVMS = filterWithDataVM.getSortVMS();
            //todo wait for api
            tvBtnDataSort.setText(sortVMS.get(0).getTitle());
            sortVMS.get(0).setSelect(true);
            ivBtnDataFilter.setOnClickListener(v -> {
                onPromotionSkuItemClickListener.onFilterDrawerClick();
            });
            ivSortDataArrow.setOnClickListener(v -> {
                ivSortDataArrow.setSelected(!ivSortDataArrow.isSelected());
                tvBtnDataSort.setSelected(!tvBtnDataSort.isSelected());
                if (tvBtnDataSort.isSelected()) {
                    PopWindowUtil.showsSortListPop(tvBtnDataSort, sortVMS, this);
                }
            });
            tvBtnDataSort.setOnClickListener(v -> {
                ivSortDataArrow.setSelected(!ivSortDataArrow.isSelected());
                tvBtnDataSort.setSelected(!tvBtnDataSort.isSelected());
                if (tvBtnDataSort.isSelected()) {
                    PopWindowUtil.showsSortListPop(tvBtnDataSort, sortVMS, this);
                }
            });
            GridLayoutManager gridLayoutManager = new GridLayoutManager(itemView.getContext(), 2);
            recyclerViewFilter.setLayoutManager(gridLayoutManager);
            WidgetProductGridVerticalAdapter gridVerticalAdapter = new
                WidgetProductGridVerticalAdapter(
                filterWithDataVM.getProductsVMS());
            recyclerViewFilter.setAdapter(gridVerticalAdapter);
            gridVerticalAdapter.setOnProductItemClickListener(this::onProductItemClick);
        }

        @Override
        public void onProductItemClick(ProductsVM productItemVM) {

        }

        @Override
        public void onPopItemClick(int position) {
            sortVMS.get(position).setSelect(true);
            tvBtnDataSort.setText(sortVMS.get(position).getTitle());
        }

        @Override
        public void onDismiss() {
            ivSortDataArrow.setSelected(false);
            tvBtnDataSort.setSelected(false);
        }
    }
}
