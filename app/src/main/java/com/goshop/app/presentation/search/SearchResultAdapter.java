package com.goshop.app.presentation.search;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoBoldTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.SearchFilterModel;
import com.goshop.app.presentation.model.SearchResultVM;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchResultAdapter extends RecyclerView.Adapter {

    private List<SearchFilterModel> filterModels;

    private OnItemClickListener onItemClickListener;

    public SearchResultAdapter(List<SearchFilterModel> filterModels,
        OnItemClickListener onItemClickListener) {
        this.filterModels = filterModels;
        this.onItemClickListener = onItemClickListener;
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

            case SearchFilterModel.SEARCH_RESULT:
                View resultView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_search_result, parent, false);
                viewHolder = new SearchResultViewHolder(resultView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SearchFilterModel searchFilterModel = filterModels.get(position);
        if (holder instanceof SearchResultViewHolder) {
            ((SearchResultViewHolder) holder).bindingData((SearchResultVM) searchFilterModel);
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

    interface OnItemClickListener {

        void onClick();
    }

    class SearchResultViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_search_result_detail)
        ImageView ivSearchResultDetail;

        @BindView(R.id.iv_search_result_gift)
        ImageView ivSearchResultGift;

        @BindView(R.id.iv_search_result_tv)
        ImageView ivSearchResultTv;

        @BindView(R.id.tv_search_result_best)
        RobotoBoldTextView tvSearchResultBest;

        @BindView(R.id.tv_search_result_new)
        RobotoBoldTextView tvSearchResultNew;

        @BindView(R.id.tv_search_result_percent)
        RobotoRegularTextView tvSearchResultPercent;

        @BindView(R.id.tv_search_result_price_now)
        RobotoBoldTextView tvSearchResultPriceNow;

        @BindView(R.id.tv_search_result_price_old)
        RobotoRegularTextView tvSearchResultPriceOld;

        @BindView(R.id.tv_search_result_title)
        RobotoRegularTextView tvSearchResultTitle;

        public SearchResultViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(SearchResultVM searchResultVM) {
            ivSearchResultDetail.setBackgroundResource(searchResultVM.getIconDetail());
            if (searchResultVM.getIconTv() == 0) {
                ivSearchResultTv.setVisibility(View.GONE);
            } else {
                ivSearchResultTv.setVisibility(View.VISIBLE);
                ivSearchResultTv.setBackgroundResource(searchResultVM.getIconTv());
            }
            if (searchResultVM.getIconGift() == 0) {
                ivSearchResultGift.setVisibility(View.GONE);
            } else {
                ivSearchResultGift.setVisibility(View.VISIBLE);
                ivSearchResultGift.setBackgroundResource(searchResultVM.getIconGift());
            }
            if (searchResultVM.isBest()) {
                tvSearchResultBest.setVisibility(View.VISIBLE);
            } else {
                tvSearchResultBest.setVisibility(View.GONE);
            }

            if (searchResultVM.isNew()) {
                tvSearchResultNew.setVisibility(View.VISIBLE);
            } else {
                tvSearchResultNew.setVisibility(View.GONE);
            }

            tvSearchResultPercent.setText(searchResultVM.getPrecent());
            tvSearchResultTitle.setText(searchResultVM.getTitle());
            tvSearchResultPriceOld.setText(searchResultVM.getOldPrice());
            tvSearchResultPriceOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            tvSearchResultPriceNow.setText(searchResultVM.getNowPrice());
            itemView.setOnClickListener(v -> onItemClickListener.onClick());
        }
    }

}
