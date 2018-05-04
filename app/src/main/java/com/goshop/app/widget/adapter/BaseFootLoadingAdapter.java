package com.goshop.app.widget.adapter;

import com.goshop.app.R;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseFootLoadingAdapter<T> extends RecyclerView.Adapter {

    private boolean isShowFoot = false;

    private boolean isLoadMore = false;

    private int FOOT_LOADING_TYPE = 0X59;

    public List<T> listDatas;

    public BaseFootLoadingAdapter(List<T> listDatas) {
        this.listDatas = listDatas;
    }


    public abstract RecyclerView.ViewHolder onCreateContentItemViewHolder(ViewGroup parent,
        int viewType);

    public abstract void onBindContentItemView(RecyclerView.ViewHolder holder, int position);

    public abstract int getContentItemCount();

    public abstract int getContentItemType(int position);

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == FOOT_LOADING_TYPE) {
            return onCreateFooterViewHolder(parent, viewType);
        }
        return onCreateContentItemViewHolder(parent, viewType);
    }

    public List<T> getListDatas() {
        return listDatas;
    }

    public void setListDatas(List<T> listDatas) {
        this.listDatas.clear();
        this.listDatas = listDatas;
        notifyDataSetChanged();
    }

    public void addLoadingDatas(List<T> listDatas) {
        this.listDatas.addAll(listDatas);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (isShowFoot) {
            return getContentItemCount() + 1;
        }
        return getContentItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= getContentItemCount() && isShowFoot()) {
            return FOOT_LOADING_TYPE;
        }
        return super.getItemViewType(position);
    }


    public boolean isShowFoot() {
        return isShowFoot;
    }

    public void setShowFoot(boolean showFoot) {
        isShowFoot = showFoot;
    }

    public boolean isLoadMore() {
        return isLoadMore;
    }

    public void setLoadMore(boolean loadMore) {
        isLoadMore = loadMore;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position == getContentItemCount() && holder.getItemViewType() == FOOT_LOADING_TYPE) {
            onBindFooterView(holder, position);
        } else {
            onBindContentItemView(holder, position);
        }
    }

    public void onBindFooterView(RecyclerView.ViewHolder holder, int position) {
        if (isShowFoot) {
            if (isLoadMore) {
                ((FootLoadingViewHolder) holder).tvLoadingMessage.setVisibility(View.GONE);
                ((FootLoadingViewHolder) holder).progressBarLoading.setVisibility(View.VISIBLE);
            } else {
                ((FootLoadingViewHolder) holder).tvLoadingMessage.setVisibility(View.VISIBLE);
                ((FootLoadingViewHolder) holder).progressBarLoading.setVisibility(View.GONE);
            }

        } else {
            ((FootLoadingViewHolder) holder).tvLoadingMessage.setVisibility(View.GONE);
            ((FootLoadingViewHolder) holder).progressBarLoading.setVisibility(View.GONE);
        }
    }

    public RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup parent, int viewType) {
        View footView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.foot_loading_more, parent, false);
        return new FootLoadingViewHolder(footView);
    }

    class FootLoadingViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_loading_message)
        TextView tvLoadingMessage;

        @BindView(R.id.progressbar_loading)
        ProgressBar progressBarLoading;

        public FootLoadingViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(String loadingMessage) {
            tvLoadingMessage.setText(loadingMessage);
        }
    }
}
