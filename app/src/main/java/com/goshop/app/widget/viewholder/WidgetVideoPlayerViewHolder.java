package com.goshop.app.widget.viewholder;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomRadioButton;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.presentation.model.widget.WidgetVideoPlayerVM;
import com.goshop.app.widget.adapter.VideoProductItemAdapter;
import com.goshop.app.widget.listener.OnProductBuyClickListener;
import com.goshop.app.widget.listener.OnProductItemClickListener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WidgetVideoPlayerViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_on_air_video)
    ImageView ivOnAirVideo;

    @BindView(R.id.ll_image_view_more)
    LinearLayout llImageViewMore;

    @BindView(R.id.recyclerview_video_buy)
    RecyclerView recyclerViewVideoBuy;

    @BindView(R.id.rg_channels)
    RadioGroup rgChannels;

    @BindView(R.id.rb_ch118)
    CustomRadioButton tvBtnCh118;

    @BindView(R.id.rb_ch120)
    CustomRadioButton tvBtnCh120;

    @BindView(R.id.rb_ch303)
    CustomRadioButton tvBtnCh303;

    @BindView(R.id.rb_fb_live)
    CustomRadioButton tvBtnFbLive;

    @BindView(R.id.tv_btn_videoplayer_detail_title)
    CustomTextView tvBtnVideoPlayerDetailTitle;

    @BindView(R.id.tv_videoplayer_title)
    CustomBoldTextView tvVideoPlayerTitle;

    public WidgetVideoPlayerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindingData(WidgetVideoPlayerVM videoPlayerVM,
        OnProductItemClickListener onProductItemClickListener,
        OnProductBuyClickListener buyClickListener) {
        tvVideoPlayerTitle.setText(videoPlayerVM.getTitle());
        tvBtnVideoPlayerDetailTitle.setText(videoPlayerVM.getDetailTitle());
        tvBtnVideoPlayerDetailTitle.setOnClickListener(v -> {
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
        recyclerViewVideoBuy.setLayoutManager(layoutManager);
        //Todo this need decide
        List<ProductsVM> productsVMS = videoPlayerVM.getVideoPlayerItemsVMS().get(0)
            .getProductsVMS();
        VideoProductItemAdapter listAdapter = new VideoProductItemAdapter(productsVMS,
            onProductItemClickListener, buyClickListener);
        recyclerViewVideoBuy.setAdapter(listAdapter);

        rgChannels.setOnCheckedChangeListener((RadioGroup group, int checkedId) -> {
        });

        llImageViewMore.setSelected(false);
        listAdapter.updateProductList(false);

        llImageViewMore.setOnClickListener(v -> {
            llImageViewMore.setSelected(!llImageViewMore.isSelected());
            listAdapter.updateProductList(llImageViewMore.isSelected());
        });
    }
}
