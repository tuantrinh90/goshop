
package com.goshop.app.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.goshop.app.Const;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.data.model.MultipleItem;
import com.goshop.app.utils.GlideImageLoader;
import com.goshop.app.utils.PagingScrollHelper;
import com.goshop.app.utils.RecyclerUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

/**
 * Created by img on 2018/1/5.
 */

public class HomeBaseAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder>
    implements PagingScrollHelper.onPageChangeListener {

    PagingScrollHelper scrollHelper = new PagingScrollHelper();

    public HomeBaseAdapter(@Nullable List data) {
        super(data);

        addItemType(Const.HOME_TOP_BANNER, R.layout.layout_home_top_banner_t1);
        addItemType(Const.HOME_TOP_CATEGORY, R.layout.layout_home_top_category_t2);
        addItemType(Const.HOME_CENTER_VIDEO, R.layout.layout_home_center_video_t3);
        addItemType(Const.HOME_BOTTOM_SLIDE, R.layout.layout_home_bottom_sideslip_list_t4);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
//        JToolUtils.printObject(item);
        switch (item.getItemType()) {
            case Const.HOME_TOP_BANNER:
                Banner banner = helper.getView(R.id.banner_home_top);
                banner.setImages(item.getTopBanner().getImgs())
                    .setImageLoader(new GlideImageLoader())
                    .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                    .setIndicatorGravity(BannerConfig.CENTER)
                    .setOnBannerListener(new OnBannerListener() {
                        @Override
                        public void OnBannerClick(int i) {
                            Toast.makeText(GoShopApplication.getAppContext(), "点击了第：" + i, Toast.LENGTH_SHORT)
                                .show();
                        }
                    }).start();
                break;
            case Const.HOME_TOP_CATEGORY:
                break;
            case Const.HOME_CENTER_VIDEO:
                final RecyclerView recyclerView = helper.getView(R.id.rv_center_on_air_content);
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(),
                    LinearLayoutManager.HORIZONTAL, false));
                recyclerView.setAdapter(new HomeCenterBaseRecyclerAdapter(item.getCenterVideo()));
                scrollHelper.setUpRecycleView(recyclerView);
                scrollHelper.setOnPageChangeListener(this);
                helper.getView(R.id.tv_center_bottom_title1)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            RecyclerUtils.smoothMoveToPosition(recyclerView, 0);
                        }
                    });
                helper.getView(R.id.tv_center_bottom_title3)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            RecyclerUtils.smoothMoveToPosition(recyclerView, 2);
                        }
                    });

                break;
            case Const.HOME_BOTTOM_SLIDE:
                break;
        }
    }

    @Override
    public void onPageChange(int index) {
        Toast.makeText(GoShopApplication.getAppContext(), "第" + (index + 1) + "页", Toast.LENGTH_SHORT).show();
    }
}
