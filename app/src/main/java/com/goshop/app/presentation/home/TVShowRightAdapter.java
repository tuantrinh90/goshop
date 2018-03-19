package com.goshop.app.presentation.home;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.model.TVShowVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TVShowRightAdapter extends RecyclerView.Adapter {

    private OnTVShowRightItemClickListener onTVShowRightItemClickListener;

    private List<TVShowVM> tvShowVMS;

    public TVShowRightAdapter(List<TVShowVM> tvShowVMS) {
        this.tvShowVMS = tvShowVMS;
    }

    public void setUpdateDatas(List<TVShowVM> tvShowVMS) {
        this.tvShowVMS.clear();
        this.tvShowVMS = tvShowVMS;
        notifyDataSetChanged();
    }

    public void updateCurrentVMS(int position) {
        for (int i = 0; i < tvShowVMS.size(); i++) {
            tvShowVMS.get(i).setCurrent(position == i);
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.item_tv_show_right, viewGroup, false);

        return new TVShowRightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((TVShowRightViewHolder) viewHolder).bindingData(tvShowVMS.get(i), i);
    }

    @Override
    public int getItemCount() {
        return tvShowVMS.size();
    }

    public void setOnTVShowRightItemClickListener(
        OnTVShowRightItemClickListener onTVShowRightItemClickListener) {
        this.onTVShowRightItemClickListener = onTVShowRightItemClickListener;
    }

    interface OnTVShowRightItemClickListener {

        void onTVShowRightItemClick(int position);
    }

    class TVShowRightViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_tv_show_right)
        ImageView ivTVShowRight;

        @BindView(R.id.iv_tvshow_right_cover)
        ImageView ivTvshowRightCover;

        @BindView(R.id.tv_tv_show_right_time)
        RobotoMediumTextView tvTvShowRightTime;

        public TVShowRightViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(TVShowVM tvShowVM, int position) {
            Glide.with(itemView.getContext()).load(tvShowVM.getImageUrl()).asBitmap()
                .error(tvShowVM.getImageDefault())
                .into(ivTVShowRight);
            tvTvShowRightTime.setText(tvShowVM.getDuration());
            ivTvshowRightCover.setSelected(tvShowVM.isCurrent());
            ivTvshowRightCover.setOnClickListener(v -> {
                updateCurrentVMS(position);
                onTVShowRightItemClickListener.onTVShowRightItemClick(position);
            });
        }
    }
}
