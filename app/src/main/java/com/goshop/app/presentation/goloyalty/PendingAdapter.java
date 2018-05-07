package com.goshop.app.presentation.goloyalty;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.model.GoLoyaltyDealsVM;
import com.goshop.app.utils.GlideUtils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PendingAdapter extends RecyclerView.Adapter {

    private List<GoLoyaltyDealsVM> dealsVMS;

    private OnCardRedeemClickListener onCardRedeemClickListener;

    private OnRewardsItemClickListener onRewardsItemClickListener;

    public PendingAdapter(List<GoLoyaltyDealsVM> dealsVMS) {
        this.dealsVMS = dealsVMS;
    }

    public void setOnCardRedeemClickListener(OnCardRedeemClickListener onCardRedeemClickListener) {
        this.onCardRedeemClickListener = onCardRedeemClickListener;
    }

    public void setUpdateDatas(List<GoLoyaltyDealsVM> dealsVMS) {
        this.dealsVMS.clear();
        this.dealsVMS = dealsVMS;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_pending, parent, false);
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

    public void setOnRewardsItemClickListener(
        OnRewardsItemClickListener onRewardsItemClickListener) {
        this.onRewardsItemClickListener = onRewardsItemClickListener;
    }

    public interface OnRewardsItemClickListener {

        void onRewardItemClick();
    }

    public interface OnCardRedeemClickListener {

        void onCardClick();
    }

    class DealViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_pending_thumb)
        ImageView ivPendingThumb;

        @BindView(R.id.ll_pending_cards)
        LinearLayout llPendingCards;

        @BindView(R.id.tv_pending_detail)
        RobotoMediumTextView tvPendingDetail;

        @BindView(R.id.tv_pending_end)
        RobotoLightTextView tvPendingEnd;

        @BindView(R.id.tv_pending_name)
        RobotoLightTextView tvPendingName;

        @BindView(R.id.tv_pending_time)
        RobotoLightTextView tvPendingTime;

        public DealViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(GoLoyaltyDealsVM dealsVM) {
            GlideUtils.loadImageError(
                itemView.getContext(),
                dealsVM.getImageUrl(),
                ivPendingThumb,
                dealsVM.getIconDefault());
            tvPendingName.setText(dealsVM.getName());
            tvPendingDetail.setText(dealsVM.getDetail());
            tvPendingTime.setText(dealsVM.getTime());
            tvPendingEnd.setText(dealsVM.getEnd());
            llPendingCards.setOnClickListener(v -> onCardRedeemClickListener.onCardClick());
            itemView.setOnClickListener(v -> onRewardsItemClickListener.onRewardItemClick());
        }
    }
}
