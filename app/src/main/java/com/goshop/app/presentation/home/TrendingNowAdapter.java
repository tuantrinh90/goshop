package com.goshop.app.presentation.home;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.ChannelVM;
import com.goshop.app.presentation.model.TrendingHorizontalProductsVM;
import com.goshop.app.presentation.model.TrendingNowModel;
import com.goshop.app.presentation.model.TrendingSingleBannerVM;
import com.goshop.app.presentation.model.TrendingVideoVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.presentation.model.widget.VideoPlayerItemsVM;
import com.goshop.app.widget.adapter.ChannelAdapter;
import com.goshop.app.widget.adapter.ProductGridHorizontalAdapter;
import com.goshop.app.widget.adapter.VideoViewPagerAdapter;
import com.goshop.app.widget.listener.OnChannelItemClickListener;
import com.goshop.app.widget.listener.OnProductBuyClickListener;
import com.goshop.app.widget.listener.OnProductItemClickListener;
import com.goshop.app.widget.listener.OnTrendingNowClickListener;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrendingNowAdapter extends RecyclerView.Adapter {

    private List<TrendingNowModel> models;

    private OnTrendingNowClickListener onTrendingNowClickListener;

    private VideoViewPagerAdapter.JWPlayerListener jwPlayerListener;

    private VideoViewPagerAdapter videoViewPagerAdapter;

    public TrendingNowAdapter(
        OnTrendingNowClickListener onTrendingNowClickListener,
        List<TrendingNowModel> models) {
        this.onTrendingNowClickListener = onTrendingNowClickListener;
        this.models = models;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case TrendingNowModel.VIEW_TYPE_VIDEOPLAYER:
                View videoView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_trending_videoplayer, parent, false);
                viewHolder = new TrendingVideoViewHolder(videoView);
                break;
            case TrendingNowModel.VIEW_TYPE_SINGLE_BANNER:
                View singleBannerView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_trending_single_banner, parent, false);
                viewHolder = new TrendingSingleBannerViewHolder(singleBannerView);
                break;
            case TrendingNowModel.VIEW_TYPE_HORIZONTAL_PRODUCTS:
                View productsView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_trending_horizontal_products, parent, false);
                viewHolder = new TrendingHorizontalProductsViewHolder(productsView);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TrendingNowModel model = models.get(position);
        if (holder instanceof TrendingVideoViewHolder) {
            ((TrendingVideoViewHolder) holder).bindingData((TrendingVideoVM) model);
        } else if (holder instanceof TrendingSingleBannerViewHolder) {
            ((TrendingSingleBannerViewHolder) holder).bindingData((TrendingSingleBannerVM) model);
        } else if (holder instanceof TrendingHorizontalProductsViewHolder) {
            ((TrendingHorizontalProductsViewHolder) holder).bindingData(
                (TrendingHorizontalProductsVM) model);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return models.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void onPause() {
        if(videoViewPagerAdapter!=null){
            videoViewPagerAdapter.onPause();
        }
    }

    public void onDestroyView() {
        if(videoViewPagerAdapter!=null){
            videoViewPagerAdapter.onDestroyView();
        }
    }

    class TrendingVideoViewHolder extends RecyclerView.ViewHolder implements
        OnChannelItemClickListener, VideoViewPagerAdapter.OnPagerHeightChangeListener,
        OnProductItemClickListener, OnProductBuyClickListener {

        @BindView(R.id.recyclerview_video_player)
        RecyclerView recyclerViewVideoPlayer;

        @BindView(R.id.tv_btn_videoplayer_detail_title)
        RobotoRegularTextView tvBtnVideoPlayerDetailTitle;

        @BindView(R.id.tv_videoplayer_title)
        RobotoMediumTextView tvVideoPlayerTitle;

        @BindView(R.id.viewpager_video_product)
        ViewPager viewPager;

        private List<Integer> heights;

        public TrendingVideoViewHolder(View itemView) {
            super(itemView);
            setIsRecyclable(false);
            ButterKnife.bind(this, itemView);
            heights = new ArrayList<>();
        }

        void bindingData(TrendingVideoVM videoVM) {

            LinearLayoutManager channelManager = new LinearLayoutManager(itemView.getContext());
            channelManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerViewVideoPlayer.setLayoutManager(channelManager);
            List<ChannelVM> channelVMS = new ArrayList<>();
            ChannelAdapter channelAdapter;
            for (int i = 0; i < videoVM.getVideoPlayerItemsVMS().size(); i++) {
                ChannelVM channelVM = new ChannelVM(i == 0,
                    videoVM.getVideoPlayerItemsVMS().get(i).getName());
                channelVMS.add(channelVM);
            }
            channelAdapter = new ChannelAdapter(channelVMS);
            recyclerViewVideoPlayer.setAdapter(channelAdapter);
            channelAdapter.setOnChannelItemClickListener(this::onChannelItemClick);
            tvVideoPlayerTitle.setText(videoVM.getTitle());
            tvBtnVideoPlayerDetailTitle.setText(videoVM.getDetailTitle());
            tvBtnVideoPlayerDetailTitle.setOnClickListener(v ->
                onTrendingNowClickListener.onTVScheduleClick());

            List<VideoPlayerItemsVM> videoPlayerItemsVMS = videoVM.getVideoPlayerItemsVMS();
            videoViewPagerAdapter = new VideoViewPagerAdapter(videoPlayerItemsVMS);
            videoViewPagerAdapter.setJWPlayerListener(jwPlayerListener);
            videoViewPagerAdapter.setOnProductItemClickListener(this::onProductItemClick);
            videoViewPagerAdapter.setOnProductBuyClickListener(this::onBuyNowClick);
            videoViewPagerAdapter.setOnPagerHeightChangeListener(this::onHeightChange);
            viewPager.setAdapter(videoViewPagerAdapter);
            viewPager.setOffscreenPageLimit(videoPlayerItemsVMS.size());
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
                    videoViewPagerAdapter.updateVideo(position);
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

        @Override
        public void onProductItemClick(ProductsVM productItemVM) {
            onTrendingNowClickListener.onProductItemClick(productItemVM);
        }

        @Override
        public void onBuyNowClick(ProductsVM productItemVM) {
            onTrendingNowClickListener.onBuyNowClick();
        }
    }

    class TrendingSingleBannerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_single_picture)
        ImageView ivSinglePicture;

        public TrendingSingleBannerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(TrendingSingleBannerVM singleBannerVM) {
            //todo wait for api
            Glide.with(itemView.getContext())
                .load(""/*singlePictureVM.getOfferListItemsVMS().get(0).getImage()*/).asBitmap()
                .error(R.drawable.ic_detail_top_demo)
                .into(ivSinglePicture);
            itemView.setOnClickListener(v -> onTrendingNowClickListener.onSingleBannerClick());
        }

    }

    class TrendingHorizontalProductsViewHolder extends RecyclerView.ViewHolder implements
        OnProductItemClickListener {

        @BindView(R.id.recyclerview_horizontal)
        RecyclerView recyclerViewHorizontal;

        @BindView(R.id.tv_trending_product_title)
        RobotoMediumTextView tvTrendingProductTitle;

        public TrendingHorizontalProductsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(TrendingHorizontalProductsVM productsVM) {
            tvTrendingProductTitle.setText(productsVM.getDetailTitle());
            LinearLayoutManager manager = new LinearLayoutManager(itemView.getContext());
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerViewHorizontal.setLayoutManager(manager);
            ProductGridHorizontalAdapter detailAdapter = new
                ProductGridHorizontalAdapter(
                this::onProductItemClick,
                productsVM.getProductsVMS());
            recyclerViewHorizontal.setAdapter(detailAdapter);
        }

        @Override
        public void onProductItemClick(ProductsVM productItemVM) {
            onTrendingNowClickListener.onProductItemClick(productItemVM);
        }
    }

    public void setJWPlayerListener(VideoViewPagerAdapter.JWPlayerListener jwPlayerListener) {
        this.jwPlayerListener = jwPlayerListener;
    }
}
