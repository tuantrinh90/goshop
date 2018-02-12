package com.goshop.app.presentation.home;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.TVVideoLeftVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by helen on 2018/2/11.
 */

public class TVVideoLeftAdapter extends RecyclerView.Adapter {

    List<TVVideoLeftVM> videoLeftVMS;

    public TVVideoLeftAdapter(
        List<TVVideoLeftVM> videoLeftVMS) {
        this.videoLeftVMS = videoLeftVMS;
    }

    public void setUpdateDatas(List<TVVideoLeftVM> videoLeftVMS) {
        this.videoLeftVMS.clear();
        this.videoLeftVMS = videoLeftVMS;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View leftView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_tv_video_left, parent, false);
        return new VideoLeftViewHolder(leftView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((VideoLeftViewHolder) holder).bindingData(videoLeftVMS.get(position));
    }

    @Override
    public int getItemCount() {
        return videoLeftVMS.size();
    }

    class VideoLeftViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_video_left)
        ImageView ivVideoLeft;

        @BindView(R.id.tv_btn_left_buy_now)
        CustomTextView tvBtnLeftBuyNow;

        @BindView(R.id.tv_video_left_now_price)
        CustomTextView tvVideoLeftNowPrice;

        @BindView(R.id.tv_video_left_old_price)
        CustomTextView tvVideoLeftOldPrice;

        @BindView(R.id.tv_video_left_percent)
        CustomTextView tvVideoLeftPercent;

        @BindView(R.id.tv_video_left_time)
        CustomBoldTextView tvVideoLeftTime;

        @BindView(R.id.tv_video_left_title)
        CustomTextView tvVideoLeftTitle;

        public VideoLeftViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(TVVideoLeftVM leftVM) {
            tvVideoLeftTime.setText(leftVM.getTime());
            Glide.with(itemView.getContext()).load(leftVM.getVideoUrl()).asBitmap()
                .error(leftVM.getVideoDefault())
                .into(ivVideoLeft);

            tvVideoLeftPercent.setText(leftVM.getPercent());
            tvVideoLeftTitle.setText(leftVM.getTitle());
            tvVideoLeftOldPrice.setText(leftVM.getOldPrice());
            tvVideoLeftNowPrice.setText(leftVM.getNowPrice());
        }
    }
}
