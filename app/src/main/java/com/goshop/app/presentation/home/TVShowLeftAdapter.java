package com.goshop.app.presentation.home;

import com.google.android.exoplayer2.drm.ExoMediaDrm;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.model.TVShowVM;
import com.longtailvideo.jwplayer.JWPlayerView;
import com.longtailvideo.jwplayer.events.listeners.VideoPlayerEvents;
import com.longtailvideo.jwplayer.media.drm.MediaDrmCallback;
import com.longtailvideo.jwplayer.media.playlists.PlaylistItem;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TVShowLeftAdapter extends RecyclerView.Adapter {

    private List<TVShowVM> tvShowVMS;

    private JWPlayerListener jwPlayerListener;

    public void setJWPlayerListener(JWPlayerListener jwPlayerListener) {
        this.jwPlayerListener = jwPlayerListener;
    }

    public TVShowLeftAdapter(List<TVShowVM> tvShowVMS) {
        this.tvShowVMS = tvShowVMS;
    }

    public void setUpdateDatas(List<TVShowVM> tvShowVMS) {
        this.tvShowVMS.clear();
        this.tvShowVMS = tvShowVMS;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.item_tv_show_left, viewGroup, false);
        return new TVShowLeftViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((TVShowLeftViewHolder) viewHolder).bindingData(tvShowVMS.get(i), i);
    }

    @Override
    public int getItemCount() {
        return tvShowVMS.size();
    }

    class TVShowLeftViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_tv_show_left)
        JWPlayerView jwPlayerView;

        @BindView(R.id.tv_btn_tvshow_buy)
        RobotoLightTextView tvBtnTvShowBuy;

        @BindView(R.id.tv_tvshow_left_percent)
        RobotoMediumTextView tvTvShowLeftPercent;

        @BindView(R.id.tv_tvshow_lefttime)
        RobotoMediumTextView tvTvShowLeftTime;

        @BindView(R.id.tv_tvshow_price_now)
        RobotoMediumTextView tvTvShowPriceNow;

        @BindView(R.id.tv_tvshow_price_old)
        RobotoLightTextView tvTvShowPriceOld;

        @BindView(R.id.tv_tvshow_title)
        RobotoLightTextView tvTvShowTitle;

        public TVShowLeftViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(TVShowVM tvShowVM, int position) {

            initJwPlayerView(jwPlayerView, tvShowVM, position);

            tvTvShowLeftTime.setText(tvShowVM.getDuration());
            tvTvShowTitle.setText(tvShowVM.getTitle());
            tvBtnTvShowBuy.setOnClickListener(v -> {
            });
            tvTvShowPriceOld.setText(tvShowVM.getPriceOld());
            tvTvShowPriceOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            tvTvShowPriceNow.setText(tvShowVM.getPriceNow());
            tvTvShowLeftPercent.setText(tvShowVM.getPercent());
        }
    }

    private void initJwPlayerView(JWPlayerView jwPlayerView, TVShowVM tvShowVM, int position) {
        jwPlayerView.setTag(tvShowVM.getImageUrl());
        PlaylistItem pi = new PlaylistItem.Builder()
            .title(tvShowVM.getTitle())
            .file(tvShowVM.getImageUrl())
            .build();
        jwPlayerView.addOnFullscreenListener(b -> {
            if (jwPlayerListener != null) {
                jwPlayerListener.onFullscreen(b,jwPlayerView);
            }
        });
        if (jwPlayerView.getTag().equals(tvShowVM.getImageUrl())) {
            jwPlayerView.load(pi);
        }
    }

    public interface JWPlayerListener {

        void onFullscreen(boolean isFullScreen, JWPlayerView jwPlayerView);
    }
}
