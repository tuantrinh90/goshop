package com.goshop.app.widget;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomRadioButton;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.widget.WidgetOnAirVM;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WidgetOnAirViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_on_air_display)
    ImageView ivOnAirDisplay;

    @BindView(R.id.iv_on_air_video)
    ImageView ivOnAirVideo;

    @BindView(R.id.ll_on_air_more)
    LinearLayout llOnAirMore;

    @BindView(R.id.rl_on_air_product)
    RelativeLayout relativeLayout;

    @BindView(R.id.rg_channels)
    RadioGroup rgChannels;

    @BindView(R.id.tv_btn_buy_now)
    CustomTextView tvBtnBuyNow;

    @BindView(R.id.rb_ch118)
    CustomRadioButton tvBtnCh118;

    @BindView(R.id.rb_ch120)
    CustomRadioButton tvBtnCh120;

    @BindView(R.id.rb_ch303)
    CustomRadioButton tvBtnCh303;

    @BindView(R.id.rb_fb_live)
    CustomRadioButton tvBtnFbLive;

    @BindView(R.id.tv_btn_on_air_tv_schedule)
    CustomTextView tvBtnOnAirTvSchedule;

    @BindView(R.id.tv_on_air_display_percent)
    CustomBoldTextView tvOnAirDisplayPercent;

    @BindView(R.id.tv_on_air_now_price)
    CustomBoldTextView tvOnAirNowPrice;

    @BindView(R.id.tv_on_air_old_price)
    CustomTextView tvOnAirOldPrice;

    @BindView(R.id.tv_on_air_title)
    CustomTextView tvOnAirTitle;

    public WidgetOnAirViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bindingData(WidgetOnAirVM onAirVM) {
        tvOnAirTitle.setText(onAirVM.getDetailTitle());
        tvOnAirOldPrice.setText(onAirVM.getDetailOld());
        tvOnAirNowPrice.setText(onAirVM.getDetailNow());
        tvOnAirOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        rgChannels.setOnCheckedChangeListener((RadioGroup group, int checkedId) -> {
        });
        tvBtnOnAirTvSchedule.setOnClickListener(v -> {
        });
        tvBtnBuyNow.setOnClickListener(v -> {
        });

        relativeLayout.setOnClickListener(v -> {
        });
        llOnAirMore.setOnClickListener(v -> {
        });
    }
}
