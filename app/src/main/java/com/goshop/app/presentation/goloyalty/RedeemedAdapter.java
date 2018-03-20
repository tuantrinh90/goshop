package com.goshop.app.presentation.goloyalty;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.model.GoLoyaltyDealsVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RedeemedAdapter extends RecyclerView.Adapter {

    private List<GoLoyaltyDealsVM> dealsVMS;

    public RedeemedAdapter(List<GoLoyaltyDealsVM> dealsVMS) {
        this.dealsVMS = dealsVMS;
    }

    public void setUpdateDatas(List<GoLoyaltyDealsVM> dealsVMS) {
        this.dealsVMS.clear();
        this.dealsVMS = dealsVMS;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_redeemed, parent, false);
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

    class DealViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_redeemed_thumb)
        ImageView ivRedeemedThumb;

        @BindView(R.id.tv_redeemed_detail)
        RobotoMediumTextView tvRedeemedDetail;

        @BindView(R.id.tv_redeemed_end)
        RobotoLightTextView tvRedeemedEnd;

        @BindView(R.id.tv_redeemed_name)
        RobotoLightTextView tvRedeemedName;

        @BindView(R.id.tv_redeemed_time)
        RobotoLightTextView tvRedeemedTime;

        public DealViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(GoLoyaltyDealsVM dealsVM) {
            Glide.with(itemView.getContext()).load(dealsVM.getImageUrl()).asBitmap()
                .error(dealsVM.getIconDefault())
                .into(ivRedeemedThumb);
            tvRedeemedName.setText(dealsVM.getName());
            tvRedeemedDetail.setText(dealsVM.getDetail());
            tvRedeemedTime.setText(dealsVM.getTime());
            tvRedeemedEnd.setText(dealsVM.getEnd());
        }
    }
}
