package com.goshop.app.widget;

import com.goshop.app.R;
import com.goshop.app.common.CustomMinusPlusEditText;
import com.goshop.app.common.view.RobotoBoldItaticTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.widget.ColorVM;
import com.goshop.app.presentation.model.widget.WidgetPDPTopDetailsVM;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WidgetPDPTopDetailViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_pdp_color)
    ImageView ivPdpColor;

    @BindView(R.id.mpet_pdp_quantily)
    CustomMinusPlusEditText mpetPdpQuantily;

    @BindView(R.id.ratingbar_pdp_details)
    RatingBar ratingBarPdpDetails;

    @BindView(R.id.rl_pdp_color)
    RelativeLayout rlPdpColor;

    @BindView(R.id.rl_pdp_size)
    RelativeLayout rlPdpSize;

    @BindView(R.id.tv_pdp_color)
    RobotoRegularTextView tvPdpColor;

    @BindView(R.id.tv_pdp_size)
    RobotoRegularTextView tvPdpSize;

    @BindView(R.id.tv_pdp_top_detail_now)
    RobotoMediumTextView tvPdpTopDetailNow;

    @BindView(R.id.tv_pdp_top_detail_old_price)
    RobotoRegularTextView tvPdpTopDetailOldPrice;

    @BindView(R.id.tv_pdp_top_detail_percent)
    RobotoRegularTextView tvPdpTopDetailPercent;

    @BindView(R.id.tv_pdp_top_detail_title)
    RobotoMediumTextView tvPdpTopDetailTitle;

    @BindView(R.id.tv_pdp_top_star_num)
    RobotoRegularTextView tvPdpTopStarNum;

    @BindView(R.id.tv_pdp_top_tips)
    RobotoBoldItaticTextView tvPdpTopTips;

    public WidgetPDPTopDetailViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bindingData(WidgetPDPTopDetailsVM topDetailsVM) {
        tvPdpTopDetailTitle.setText(topDetailsVM.getTitle());
        tvPdpTopDetailOldPrice.setText(topDetailsVM.getOldPrice());
        tvPdpTopDetailOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tvPdpTopDetailNow.setText(topDetailsVM.getNowPrice());
        tvPdpTopDetailPercent.setText(topDetailsVM.getPercent());
        ratingBarPdpDetails.setRating(topDetailsVM.getStarStep());
        tvPdpTopStarNum.setText(topDetailsVM.getStarNum());
        List<String> tips = topDetailsVM.getTips();
        StringBuilder tip = new StringBuilder();
        for (int i = 0; i < tips.size(); i++) {
            tip.append(tips.get(i));
            if (i != tips.size() - 1) {
                tip.append(" · ");
            }
        }
        tvPdpTopTips.setText(tip.toString());
        ColorVM colorVM = topDetailsVM.getPdpColors().get(0);
        tvPdpColor.setText(colorVM.getColorName());
        ivPdpColor.setBackgroundColor(Color.parseColor(colorVM.getColorValue()));
        tvPdpSize.setText(topDetailsVM.getPdpSizes().get(0));
        mpetPdpQuantily.setText(topDetailsVM.getAmount());
    }
}
