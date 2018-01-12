
package com.goshop.app.adapter;

import com.goshop.app.Const;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.common.view.CustomPagerIndicator;
import com.goshop.app.data.model.MultipleItem;
import com.goshop.app.utils.PagingScrollHelper;
import com.goshop.app.utils.RecyclerUtils;
import com.goshop.app.widget.BannerAutoPlayHelper;
import com.orhanobut.logger.Logger;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by img on 2018/1/5.
 */

public class HomeBaseAdapter extends RecyclerView.Adapter {

    List<MultipleItem> multipleItems = new ArrayList<>();
    private static final int SUM_PAGE=4;

    public HomeBaseAdapter(List<MultipleItem> data) {
        this.multipleItems = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case Const.HOME_TOP_BANNER:
                View bannerView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_home_top_banner_t1, parent, false);
                viewHolder = new TopBannerHolder(bannerView);
                break;
            case Const.HOME_TOP_CATEGORY:
                View topCategoryView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_home_top_category_t2, parent, false);
                viewHolder = new TopCategoryHolder(topCategoryView);
                break;
            case Const.HOME_CENTER_VIDEO:
                View centerVideoView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_home_center_video_t3, parent, false);
                viewHolder = new CenterVideoHolder(centerVideoView);
                break;
            case Const.HOME_BOTTOM_SLIDE:
                View bottomSlide = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_home_bottom_sideslip_list_t4, parent, false);
                viewHolder = new BottomSlideHolder(bottomSlide);
                break;

        }
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TopBannerHolder) {
            ((TopBannerHolder) holder).bindingData(multipleItems.get(0), position);
        } else if (holder instanceof TopCategoryHolder) {
            ((TopCategoryHolder) holder).bindingData();
        } else if (holder instanceof CenterVideoHolder) {
            ((CenterVideoHolder) holder).bindingData(multipleItems.get(2), position);
        } else if (holder instanceof BottomSlideHolder) {
            ((BottomSlideHolder) holder).bindingData(multipleItems.get(3).getBottomSlide());
        }
    }

    @Override
    public int getItemCount() {
        return SUM_PAGE;
    }

    static class TopBannerHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.vp_header)
        ViewPager vpHomeHeader;

        @BindView(R.id.cpi_indicator)
        CustomPagerIndicator customPagerIndicator;

        public TopBannerHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(MultipleItem multipleItem, int positon) {
            vpHomeHeader.setAdapter(new SlidingImageAdapter(vpHomeHeader.getContext(),
                multipleItem.getTopBanner().getImgs()));
            customPagerIndicator.setViewPager(vpHomeHeader);
            BannerAutoPlayHelper bannerAutoPlayHelper = new BannerAutoPlayHelper(vpHomeHeader);
            bannerAutoPlayHelper.autoPlay();
            multipleItem.getTopBanner();
        }

    }

    static class TopCategoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.ll_home_top_category_category)
        LinearLayout llCategoryCategory;

        @BindView(R.id.ll_home_top_category_brands)
        LinearLayout llCategoryBrands;

        @BindView(R.id.ll_home_top_category_tv_shows)
        LinearLayout llCategoryTvShows;

        @BindView(R.id.ll_home_top_category_gift_card)
        LinearLayout llCategoryGiftCard;

        public TopCategoryHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData() {
            llCategoryCategory.setOnClickListener(this);
            llCategoryBrands.setOnClickListener(this);
            llCategoryTvShows.setOnClickListener(this);
            llCategoryGiftCard.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ll_home_top_category_category:
                    Logger.e("llCategoryBrands");
                    break;
                case R.id.ll_home_top_category_brands:
                    Logger.e("ll_home_top_category_brands");
                    break;
                case R.id.ll_home_top_category_tv_shows:
                    Logger.e("ll_home_top_category_tv_shows");
                    break;
                case R.id.ll_home_top_category_gift_card:
                    Logger.e("ll_home_top_category_gift_card");
                    break;
            }
        }
    }

    static class CenterVideoHolder extends RecyclerView.ViewHolder implements PagingScrollHelper
        .onPageChangeListener, View.OnClickListener {

        @BindView(R.id.rv_center_on_air_content)
        RecyclerView recyclerView;

        @BindView(R.id.tv_center_bottom_title1)
        TextView tvCenterBottomTitle1;

        @BindView(R.id.tv_center_bottom_title2)
        TextView tvCenterBottomTitle2;

        @BindView(R.id.tv_center_bottom_title3)
        TextView tvCenterBottomTitle3;

        @BindView(R.id.tv_center_bottom_title4)
        TextView tvCenterBottomTitle4;

        public CenterVideoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(MultipleItem multipleItem, int position) {
            PagingScrollHelper scrollHelper = new PagingScrollHelper();
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(),
                LinearLayoutManager.HORIZONTAL, false));
            recyclerView
                .setAdapter(new HomeCenterBaseRecyclerAdapter(multipleItem.getCenterVideo()));
            scrollHelper.setUpRecycleView(recyclerView);
            scrollHelper.setOnPageChangeListener(this);
            tvCenterBottomTitle1.setOnClickListener(this);
            tvCenterBottomTitle2.setOnClickListener(this);
            tvCenterBottomTitle3.setOnClickListener(this);
            tvCenterBottomTitle4.setOnClickListener(this);
        }

        void resetTextState() {
            tvCenterBottomTitle1.setSelected(false);
            tvCenterBottomTitle2.setSelected(false);
            tvCenterBottomTitle3.setSelected(false);
            tvCenterBottomTitle4.setSelected(false);
        }

        @Override
        public void onPageChange(int index) {
            //TODO joyson will delete after require
            Toast.makeText(GoShopApplication.getAppContext(), (index + 1) + "  page",
                Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_center_bottom_title1:
                    RecyclerUtils.smoothMoveToPosition(recyclerView,0);
                    resetTextState();
                    tvCenterBottomTitle1.setSelected(true);
                    break;
                case R.id.tv_center_bottom_title2:
                    RecyclerUtils.smoothMoveToPosition(recyclerView,1);
                    resetTextState();
                    tvCenterBottomTitle2.setSelected(true);
                    break;
                case R.id.tv_center_bottom_title3:
                    RecyclerUtils.smoothMoveToPosition(recyclerView,2);
                    resetTextState();
                    tvCenterBottomTitle3.setSelected(true);
                    break;
                case R.id.tv_center_bottom_title4:
                    RecyclerUtils.smoothMoveToPosition(recyclerView,3);
                    resetTextState();
                    tvCenterBottomTitle4.setSelected(true);
                    break;
            }
        }
    }

    static class BottomSlideHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.rv_bottom)
        RecyclerView recyclerView;

        public BottomSlideHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(List<MultipleItem.BottomSlide> bottomSlides) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView
                .setAdapter(new HomeBottomSlideAdapter(bottomSlides));
        }
    }

}
