package com.goshop.app.adapter;

import com.bumptech.glide.Glide;
import com.goshop.app.Const;
import com.goshop.app.R;
import com.goshop.app.data.model.response.HomeResponse;
import com.goshop.app.utils.PageIntentUtils;
import com.jakewharton.rxbinding2.view.RxView;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeBottomSlideAdapter extends RecyclerView.Adapter {

    List<HomeResponse.BottomSlide> bottomSlides = new ArrayList<>();

    public HomeBottomSlideAdapter(
        List<HomeResponse.BottomSlide> bottomSlides) {
        this.bottomSlides = bottomSlides;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case Const.HOME_BOTTOM_SLIDE_HEADER_IMG:
                View headerView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_home_bottom_sideslip_header_t4, parent, false);
                viewHolder = new BottomHeaderHolder(headerView);
                break;
            case Const.HOME_BOTTOM_SLIDE_TITLE:
                View titleView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_home_bottom_sideslip_title_t4, parent, false);
                viewHolder = new BottomTitleHolder(titleView);
                break;
            case Const.HOME_BOTTOM_SLIDE_BODY:
                View bodyView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_home_bottom_sideslip_t4, parent, false);
                viewHolder = new BottomBodyHolder(bodyView);
                break;
        }

        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        return bottomSlides.get(position).getViewType();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BottomHeaderHolder) {
            ((BottomHeaderHolder) holder).bindingData(bottomSlides.get(position),position);
        } else if (holder instanceof BottomTitleHolder) {
            ((BottomTitleHolder) holder).bindingData(bottomSlides.get(position));
        } else if (holder instanceof BottomBodyHolder) {
            ((BottomBodyHolder) holder).bindingData(bottomSlides.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return bottomSlides.size();
    }

    static class BottomHeaderHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_bottom_slide_header)
        ImageView ivBottomHeader;

        public BottomHeaderHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(HomeResponse.BottomSlide bottomSlide,int position) {
            RxView.clicks(ivBottomHeader).subscribe(v -> PageIntentUtils.skipBannerPromotion(ivBottomHeader.getContext(), bottomSlide));
        }
    }

    static class BottomTitleHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_home_bottom_slide_title)
        TextView tvTitle;

        public BottomTitleHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(HomeResponse.BottomSlide bottomSlide) {
            tvTitle.setText(bottomSlide.getSlideTitle());
        }
    }

    static class BottomBodyHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.rv_home_bottom_slide)
        RecyclerView recyclerView;

        public BottomBodyHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(HomeResponse.BottomSlide bottomSlide) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(),
                LinearLayoutManager.HORIZONTAL, false));
            recyclerView
                .setAdapter(new HomeBottomChildAdapter(bottomSlide.getBottomSlideChildren()));
        }

    }
}
