package com.goshop.app.widget;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.WidgetOnAirVM;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by helen on 2018/2/11.
 */

public class WidgetOnAirViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_on_air_display)
    ImageView ivOnAirDisplay;

    @BindView(R.id.tv_btn_buy_now)
    CustomTextView tvBtnBuyNow;

    @BindView(R.id.tv_btn_on_air_tv_schedule)
    CustomTextView tvBtnOnAirTvSchedule;

    @BindView(R.id.tv_btn_ch118)
    CustomTextView tvBtnCh118;

    @BindView(R.id.tv_btn_ch120)
    CustomTextView tvBtnCh120;

    @BindView(R.id.tv_btn_ch303)
    CustomTextView tvBtnCh303;

    @BindView(R.id.tv_on_air_display_percent)
    CustomBoldTextView tvOnAirDisplayPercent;

    @BindView(R.id.tv_btn_fb_live)
    CustomTextView tvBtnFbLive;

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
    }
}
