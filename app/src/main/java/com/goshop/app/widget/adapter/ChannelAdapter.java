package com.goshop.app.widget.adapter;

import com.goshop.app.R;
import com.goshop.app.common.Typefaces;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.ChannelVM;
import com.goshop.app.widget.listener.OnChannelItemClickListener;

import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChannelAdapter extends RecyclerView.Adapter {

    private List<ChannelVM> channels;

    private OnChannelItemClickListener onChannelItemClickListener;

    public ChannelAdapter(List<ChannelVM> channels) {
        this.channels = channels;
    }

    public void setOnChannelItemClickListener(
        OnChannelItemClickListener onChannelItemClickListener) {
        this.onChannelItemClickListener = onChannelItemClickListener;
    }

    public void setUpdateData(List<ChannelVM> channels) {
        this.channels.clear();
        this.channels = channels;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_video_channel, parent, false);
        return new ChannelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ChannelViewHolder) holder).bindingData(channels.get(position), position);
    }

    @Override
    public int getItemCount() {
        return channels.size();
    }

    public void updateChannels(int position) {

        for (int i = 0; i < channels.size(); i++) {
            channels.get(i).setSelect(position == i);
        }
        notifyDataSetChanged();
    }

    class ChannelViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_channel)
        ImageView ivChannel;

        @BindView(R.id.tv_channel)
        RobotoRegularTextView tvChannel;

        public ChannelViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(ChannelVM channelVM, int position) {
            tvChannel.setText(channelVM.getName());
            Typeface typeface = Typefaces.get(itemView.getContext(), channelVM
                .isSelect() ? Typefaces.PATH_FONT_ROBOTO_MEDIUM : Typefaces
                .PATH_FONT_ROBOTO_REGULAR);
            tvChannel.setTypeface(typeface);
            tvChannel.setSelected(channelVM.isSelect());
            tvChannel.setTextColor(ContextCompat.getColor(itemView.getContext(),
                channelVM
                    .isSelect() ? R.color.color_grayscale_text : R.color
                    .color_grayscale_secondary));
            ivChannel.setVisibility(position == 0 ? View.GONE : View.VISIBLE);
            itemView
                .setOnClickListener(v -> {
                    onChannelItemClickListener.onChannelItemClick(position);
                    updateChannels(position);
                });
        }
    }
}
