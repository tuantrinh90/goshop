package com.goshop.app.presentation.search;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.SearchCategoryVM;
import com.goshop.app.presentation.model.SearchFilterModel;
import com.goshop.app.presentation.model.SearchKeywordsVM;
import com.goshop.app.presentation.model.SearchPopularDetailVM;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchFilterAdapter extends RecyclerView.Adapter {

    private List<SearchFilterModel> filterModels;

    private SearchFilterClickListener searchFilterClickListener;

    public SearchFilterAdapter(List<SearchFilterModel> filterModels,
        SearchFilterClickListener searchFilterClickListener) {
        this.filterModels = filterModels;
        this.searchFilterClickListener = searchFilterClickListener;
    }

    public void setDatas(List<SearchFilterModel> filterModels) {
        this.filterModels.clear();
        this.filterModels = filterModels;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case SearchFilterModel.SEARCH_CATEGORY:
                View categoryView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_search_filter_category, parent, false);
                viewHolder = new SearchFilterCategoryViewHolder(categoryView);
                break;
            case SearchFilterModel.SEARCH_KEYWORDS:
                View keywordView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_search_filter_keyword, parent, false);
                viewHolder = new SearchFilterKeywordsViewHolder(keywordView);
                break;
            case SearchFilterModel.SEARCH_POPULAR_TITLE:
                View titleView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_search_popular_title, parent, false);
                viewHolder = new SearchFixedViewHolder(titleView);
                break;
            case SearchFilterModel.SEARCH_POPULAR_DETAIL:
                View detailView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_search_popular_detail, parent, false);
                viewHolder = new SearchFilterPopularDetailViewHolder(detailView);
                break;
            case SearchFilterModel.SEARCH_POPULAR_DIVIDING:
                View dividingView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_dividing, parent, false);
                viewHolder = new SearchFixedViewHolder(dividingView);
                break;
            case SearchFilterModel.SEARCH_NO_DATA:
                View noDataView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_nodata, parent, false);
                viewHolder = new SearchFixedViewHolder(noDataView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SearchFilterModel searchFilterModel = filterModels.get(position);
        if (holder instanceof SearchFilterCategoryViewHolder) {
            ((SearchFilterCategoryViewHolder) holder).bindingData(
                (SearchCategoryVM) searchFilterModel);
        } else if (holder instanceof SearchFilterKeywordsViewHolder) {
            ((SearchFilterKeywordsViewHolder) holder).bindingData(
                (SearchKeywordsVM) searchFilterModel);
        } else if (holder instanceof SearchFixedViewHolder) {
            //TODO  this part need decide
        } else if (holder instanceof SearchFilterPopularDetailViewHolder) {
            ((SearchFilterPopularDetailViewHolder) holder).bindingData(
                (SearchPopularDetailVM) searchFilterModel);
        } else if (holder instanceof SearchFixedViewHolder) {
            //TODO  this part need decide
        } else {
            //TODO wait for design
        }
    }

    @Override
    public int getItemViewType(int position) {
        return filterModels.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return filterModels.size();
    }

    interface SearchFilterClickListener {

        void onFilterClick(String keywords);
    }

    class SearchFilterCategoryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_search_category)
        CustomTextView tvSearchCategory;

        @BindView(R.id.tv_search_category_keywords)
        CustomTextView tvSearchCategoryKeywords;

        public SearchFilterCategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(SearchCategoryVM categoryVM) {
            tvSearchCategory.setText(categoryVM.getCategory());
            tvSearchCategoryKeywords.setText(categoryVM.getKeywords());
            itemView.setOnClickListener(
                v -> searchFilterClickListener.onFilterClick(categoryVM.getKeywords()));
        }
    }

    class SearchFilterKeywordsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_search_keyword)
        CustomTextView tvSearchKeyword;

        public SearchFilterKeywordsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(SearchKeywordsVM keywordsVM) {
            tvSearchKeyword.setText(keywordsVM.getKeywords());
            itemView.setOnClickListener(
                v -> searchFilterClickListener.onFilterClick(keywordsVM.getKeywords()));
        }
    }

    class SearchFixedViewHolder extends RecyclerView.ViewHolder {

        public SearchFixedViewHolder(View itemView) {
            super(itemView);
            //todo (helen) this part need to decide
        }
    }

    class SearchFilterPopularDetailViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_search_detail)
        ImageView ivSearchDetail;

        @BindView(R.id.tv_search_detail_now)
        CustomBoldTextView tvSearchDetailNow;

        @BindView(R.id.tv_search_detail_old)
        CustomTextView tvSearchDetailOld;

        @BindView(R.id.tv_search_detail_title)
        CustomTextView tvSearchDetailTitle;

        public SearchFilterPopularDetailViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(SearchPopularDetailVM popularDetailVM) {
            ivSearchDetail.setBackgroundResource(popularDetailVM.getIcon());
            tvSearchDetailTitle.setText(popularDetailVM.getTitle());
            if (popularDetailVM.getOld() == null || TextUtils.isEmpty(popularDetailVM.getOld())) {
                tvSearchDetailOld.setVisibility(View.GONE);
            } else {
                tvSearchDetailOld.setVisibility(View.VISIBLE);
                tvSearchDetailOld.setText(popularDetailVM.getOld());
                tvSearchDetailOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            }
            tvSearchDetailNow.setText(popularDetailVM.getNow());
        }
    }
}
