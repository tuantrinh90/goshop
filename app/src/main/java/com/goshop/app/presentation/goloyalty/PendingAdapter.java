package com.goshop.app.presentation.goloyalty;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.GoLoyaltyDealsVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PendingAdapter extends RecyclerView.Adapter {

    private List<GoLoyaltyDealsVM> dealsVMS;

    private OnRewardsItemClickListener onRewardsItemClickListener;

    public PendingAdapter(List<GoLoyaltyDealsVM> dealsVMS) {
        this.dealsVMS = dealsVMS;
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

    class DealViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_pending_cards)
        ImageView ivPendingCards;

        @BindView(R.id.iv_pending_thumb)
        ImageView ivPendingThumb;

        @BindView(R.id.tv_pending_detail)
        CustomBoldTextView tvPendingDetail;

        @BindView(R.id.tv_pending_end)
        CustomTextView tvPendingEnd;

        @BindView(R.id.tv_pending_name)
        CustomTextView tvPendingName;

        @BindView(R.id.tv_pending_time)
        CustomTextView tvPendingTime;

        public DealViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(GoLoyaltyDealsVM dealsVM) {
            Glide.with(itemView.getContext()).load(dealsVM.getImageUrl()).asBitmap()
                .error(dealsVM.getIconDefault())
                .into(ivPendingThumb);
            tvPendingName.setText(dealsVM.getName());
            tvPendingDetail.setText(dealsVM.getDetail());
            tvPendingTime.setText(dealsVM.getTime());
            tvPendingEnd.setText(dealsVM.getEnd());
            ivPendingCards.setOnClickListener(v -> {
            });
            itemView.setOnClickListener(v -> onRewardsItemClickListener.onRewardItemClick());
        }
    }
}
