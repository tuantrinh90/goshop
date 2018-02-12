package com.goshop.app.presentation.home;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.TVVideoRightVM;

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

public class TVVideoRightAdapter extends RecyclerView.Adapter {

    List<TVVideoRightVM> rightVMS;

    public TVVideoRightAdapter(
        List<TVVideoRightVM> rightVMS) {
        this.rightVMS = rightVMS;
    }

    public void setUpdateDatas(List<TVVideoRightVM> rightVMS) {
        this.rightVMS.clear();
        this.rightVMS = rightVMS;
        notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rightView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_tv_video_right, parent, false);
        return new VideoRightViewHolder(rightView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((VideoRightViewHolder) holder).bindingData(rightVMS.get(position));
    }

    @Override
    public int getItemCount() {
        return rightVMS.size();
    }

    class VideoRightViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_video_right)
        ImageView ivVideoRight;

        @BindView(R.id.tv_video_right_status)
        CustomTextView tvVideoRightStatus;

        @BindView(R.id.tv_video_right_time)
        CustomBoldTextView tvVideoRightTime;

        public VideoRightViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(TVVideoRightVM rightVM) {
            Glide.with(itemView.getContext()).load(rightVM.getVideoUrl()).asBitmap()
                .error(rightVM.getVideoDefault())
                .into(ivVideoRight);
            tvVideoRightStatus.setVisibility(rightVM.isOnAir() ? View.VISIBLE : View.GONE);
            tvVideoRightTime.setText(rightVM.getTime());
        }
    }
}
