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

public class ExpiredAdapter extends RecyclerView.Adapter {

    private List<GoLoyaltyDealsVM> dealsVMS;

    public ExpiredAdapter(List<GoLoyaltyDealsVM> dealsVMS) {
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
            .inflate(R.layout.item_expired, parent, false);
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

        @BindView(R.id.iv_expired_thumb)
        ImageView ivExpiredThumb;

        @BindView(R.id.tv_expired_detail)
        RobotoMediumTextView tvExpiredDetail;

        @BindView(R.id.tv_expired_end)
        RobotoLightTextView tvExpiredEnd;

        @BindView(R.id.tv_expired_name)
        RobotoLightTextView tvExpiredName;

        @BindView(R.id.tv_expired_time)
        RobotoLightTextView tvExpiredTime;

        public DealViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(GoLoyaltyDealsVM dealsVM) {
            Glide.with(itemView.getContext()).load(dealsVM.getImageUrl()).asBitmap()
                .error(dealsVM.getIconDefault())
                .into(ivExpiredThumb);
            tvExpiredName.setText(dealsVM.getName());
            tvExpiredDetail.setText(dealsVM.getDetail());
            tvExpiredTime.setText(dealsVM.getTime());
            tvExpiredEnd.setText(dealsVM.getEnd());
        }
    }
}
