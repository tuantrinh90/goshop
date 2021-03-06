package com.goshop.app.presentation.goloyalty;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.model.GoLoyaltyDealsVM;
import com.goshop.app.utils.GlideUtils;
import com.goshop.app.widget.listener.OnDealsItemClickListener;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DealsAdapter extends RecyclerView.Adapter {

    private List<GoLoyaltyDealsVM> dealsVMS;

    private OnDealsItemClickListener onDealItemClickListener;

    public DealsAdapter(List<GoLoyaltyDealsVM> dealsVMS) {
        this.dealsVMS = dealsVMS;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_deals, parent, false);
        return new DealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((DealViewHolder) holder).bindingData(dealsVMS.get(position));
    }

    @Override
    public int getItemCount() {
        return dealsVMS.size();
    }

    public void setOnDealItemClickListener(OnDealsItemClickListener onDealItemClickListener) {
        this.onDealItemClickListener = onDealItemClickListener;
    }

    class DealViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_deal_thumb)
        ImageView ivDealThumb;

        @BindView(R.id.tv_deal_detail)
        RobotoMediumTextView tvDealDetail;

        @BindView(R.id.tv_deal_end)
        RobotoLightTextView tvDealEnd;

        @BindView(R.id.tv_deal_name)
        RobotoLightTextView tvDealName;

        @BindView(R.id.tv_deal_time)
        RobotoLightTextView tvDealTime;

        public DealViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(GoLoyaltyDealsVM dealsVM) {
            GlideUtils.loadImageError(
                itemView.getContext(),
                dealsVM.getImageUrl(),
                ivDealThumb,
                R.drawable.ic_image_404_big);
            tvDealName.setText(dealsVM.getName());
            tvDealDetail.setText(dealsVM.getDetail());
            tvDealTime.setText(dealsVM.getTime());
            tvDealEnd.setText(dealsVM.getEnd());
            itemView.setOnClickListener(v -> onDealItemClickListener.onDealItemClick(dealsVM));
        }
    }
}
