package com.goshop.app.widget.viewholder;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoBoldTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.ChannelVM;
import com.goshop.app.presentation.model.widget.VideoPlayerItemsVM;
import com.goshop.app.presentation.model.widget.WidgetVideoPlayerVM;
import com.goshop.app.widget.adapter.ChannelAdapter;
import com.goshop.app.widget.adapter.VideoViewPagerAdapter;
import com.goshop.app.widget.listener.OnChannelItemClickListener;
import com.goshop.app.widget.listener.OnProductBuyClickListener;
import com.goshop.app.widget.listener.OnProductItemClickListener;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WidgetVideoPlayerViewHolder extends RecyclerView.ViewHolder implements
    OnChannelItemClickListener, VideoViewPagerAdapter.OnPagerHeightChangeListener {

    @BindView(R.id.recyclerview_video_player)
    RecyclerView recyclerViewVideoPlayer;

    @BindView(R.id.tv_btn_videoplayer_detail_title)
    RobotoRegularTextView tvBtnVideoPlayerDetailTitle;

    @BindView(R.id.tv_videoplayer_title)
    RobotoBoldTextView tvVideoPlayerTitle;

    @BindView(R.id.viewpager_video_product)
    ViewPager viewPager;

    private List<Integer> heights;

    public WidgetVideoPlayerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        heights = new ArrayList<>();
    }

    public void bindingData(WidgetVideoPlayerVM videoPlayerVM,
        OnProductItemClickListener onProductItemClickListener,
        OnProductBuyClickListener buyClickListener) {

        LinearLayoutManager channelManager = new LinearLayoutManager(itemView.getContext());
        channelManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewVideoPlayer.setLayoutManager(channelManager);
        List<ChannelVM> channelVMS = new ArrayList<>();
        ChannelAdapter channelAdapter;
        for (int i = 0; i < videoPlayerVM.getVideoPlayerItemsVMS().size(); i++) {
            ChannelVM channelVM = new ChannelVM(i == 0,
                videoPlayerVM.getVideoPlayerItemsVMS().get(i).getName());
            channelVMS.add(channelVM);
        }
        channelAdapter = new ChannelAdapter(channelVMS);
        recyclerViewVideoPlayer.setAdapter(channelAdapter);
        channelAdapter.setOnChannelItemClickListener(this::onChannelItemClick);
        tvVideoPlayerTitle.setText(videoPlayerVM.getTitle());
        tvBtnVideoPlayerDetailTitle.setText(videoPlayerVM.getDetailTitle());
        tvBtnVideoPlayerDetailTitle.setOnClickListener(v -> {
        });

        List<VideoPlayerItemsVM> videoPlayerItemsVMS = videoPlayerVM.getVideoPlayerItemsVMS();
        VideoViewPagerAdapter pagerAdapter = new VideoViewPagerAdapter(videoPlayerItemsVMS);
        pagerAdapter.setOnProductItemClickListener(onProductItemClickListener);
        pagerAdapter.setOnProductBuyClickListener(buyClickListener);
        pagerAdapter.setOnPagerHeightChangeListener(this::onHeightChange);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(3);
        for (int i = 0; i < videoPlayerItemsVMS.size(); i++) {
            heights.add(viewPager.getLayoutParams().height);
        }

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                int positionOffsetPixels) {
                if (position == heights.size() - 1) {
                    return;
                }
                int height = (int) (heights.get(position) * (1 - positionOffset) + heights
                    .get(position + 1) * positionOffset);
                ViewGroup.LayoutParams params = viewPager.getLayoutParams();
                params.height = height;
                viewPager.setLayoutParams(params);
            }

            @Override
            public void onPageSelected(int position) {
                channelAdapter.updateChannels(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

    @Override
    public void onChannelItemClick(int position) {
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onHeightChange(int position, int height, boolean isExpand) {
        ViewGroup.LayoutParams layoutParams = viewPager.getLayoutParams();
        layoutParams.height = isExpand ? (viewPager.getMeasuredHeight() + height) : (viewPager
            .getMeasuredHeight() - height);
        heights.set(position, layoutParams.height);
        viewPager.setLayoutParams(layoutParams);
    }
}
