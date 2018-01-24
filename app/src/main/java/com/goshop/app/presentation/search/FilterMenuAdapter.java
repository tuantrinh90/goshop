package com.goshop.app.presentation.search;

import com.goshop.app.R;
import com.goshop.app.common.CustomDynamicRelativeLayout;
import com.goshop.app.common.view.CustomEditText;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.FilterMenuCategoryVM;
import com.goshop.app.presentation.model.FilterMenuExpandVM;
import com.goshop.app.presentation.model.FilterMenuModel;
import com.goshop.app.presentation.model.FilterMenuPriceVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by helen on 2018/1/22.
 */

public class FilterMenuAdapter extends RecyclerView.Adapter {

    private List<FilterMenuModel> menuModels;

    public FilterMenuAdapter(
        List<FilterMenuModel> menuModels) {
        this.menuModels = menuModels;
    }

    public void updateDatas(List<FilterMenuModel> menuModels) {
        this.menuModels.clear();
        this.menuModels = menuModels;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case FilterMenuModel.FILTER_EXPAND:
                View expandView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_filter_menu_expand_title, parent, false);
                viewHolder = new ExpandViewHolder(expandView);
                break;
            case FilterMenuModel.FILTER_CATEGORY:
                View categoryView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_filter_menu_category, parent, false);
                viewHolder = new CategoryViewHolder(categoryView);
                break;

            case FilterMenuModel.FILTER_BRANDS:
                //TODO(helen) need decide
                break;
            case FilterMenuModel.FILTER_PRICE:
                View priceView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_filter_menu_price, parent, false);
                viewHolder = new PriceViewHolder(priceView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FilterMenuModel filterMenuModel = menuModels.get(position);
        if (holder instanceof ExpandViewHolder) {
            ((ExpandViewHolder) holder).bindingData((FilterMenuExpandVM) filterMenuModel);
        } else if (holder instanceof CategoryViewHolder) {
            ((CategoryViewHolder) holder).bindingData((FilterMenuCategoryVM) filterMenuModel);
        } else if (holder instanceof PriceViewHolder) {
            ((PriceViewHolder) holder).bindingData((FilterMenuPriceVM) filterMenuModel);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return menuModels.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return menuModels.size();
    }

    class ExpandViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_item_search_filter_expand)
        ImageView ivItemSearchFilterExpand;

        @BindView(R.id.tv_item_search_filter_expand)
        CustomTextView tvItemSearchFilterExpand;

        public ExpandViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(FilterMenuExpandVM expandVM) {
            tvItemSearchFilterExpand.setText(expandVM.getTitle());
            ivItemSearchFilterExpand.setOnClickListener(
                v -> ivItemSearchFilterExpand.setSelected(!ivItemSearchFilterExpand.isSelected()));
        }
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.crl_search_category_filter)
        CustomDynamicRelativeLayout crlSearchCategoryFilter;

        private CategorySelectorHelper selectorHelper;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            selectorHelper = new CategorySelectorHelper();
        }

        void bindingData(FilterMenuCategoryVM categoryVM) {
            selectorHelper.createCheckBox(crlSearchCategoryFilter, categoryVM.getCategorys());
        }
    }

    class BrandsViewHolder extends RecyclerView.ViewHolder {

        public BrandsViewHolder(View itemView) {
            super(itemView);
            //TODO(helen) need decide
//            ButterKnife.bind(this, itemView);
        }
    }

    class PriceViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.et_search_filter_max)
        CustomEditText etSearchFilterMax;

        @BindView(R.id.et_search_filter_min)
        CustomEditText etSearchFilterMin;

        public PriceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(FilterMenuPriceVM priceVM) {
        }
    }
}
