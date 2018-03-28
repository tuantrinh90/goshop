package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.PdpFrequentlyDataVM;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PdpFrequentlyBoughtAdapter extends RecyclerView.Adapter {

    private List<PdpFrequentlyDataVM> dataVMS;

    public PdpFrequentlyBoughtAdapter(
        List<PdpFrequentlyDataVM> dataVMS) {
        this.dataVMS = dataVMS;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_item_frequently_bought, parent, false);
        return new FrequentlyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((FrequentlyViewHolder) holder).bindingData(dataVMS.get(position));
    }

    @Override
    public int getItemCount() {
        return dataVMS.size();
    }

    class FrequentlyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_item_item_frequently)
        ImageView ivItemItemFrequently;

        @BindView(R.id.tv_item_item_now_price)
        RobotoMediumTextView tvItemItemNowPrice;

        @BindView(R.id.tv_item_item_old_price)
        RobotoRegularTextView tvItemItemOldPrice;

        @BindView(R.id.tv_item_item_percent)
        RobotoRegularTextView tvItemItemPercent;

        @BindView(R.id.tv_item_item_title)
        RobotoRegularTextView tvItemItemTitle;

        public FrequentlyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(PdpFrequentlyDataVM dataVM) {
            tvItemItemTitle.setText(dataVM.getTitle());
            ivItemItemFrequently.setBackgroundResource(dataVM.getIcon());
            tvItemItemNowPrice.setText(dataVM.getNowPrice());
            if (TextUtils.isEmpty(dataVM.getOldPrice())) {
                tvItemItemOldPrice.setVisibility(View.GONE);
            } else {
                tvItemItemOldPrice.setVisibility(View.VISIBLE);
                tvItemItemOldPrice.setText(dataVM.getOldPrice());
                tvItemItemOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            }
            if (TextUtils.isEmpty(dataVM.getPercent())) {
                tvItemItemPercent.setVisibility(View.GONE);
            } else {
                tvItemItemPercent.setVisibility(View.VISIBLE);
                tvItemItemPercent.setText(dataVM.getPercent());
            }
            itemView.setOnClickListener(v -> {
            });
        }
    }
}
