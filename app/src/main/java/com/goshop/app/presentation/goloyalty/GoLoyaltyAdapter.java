package com.goshop.app.presentation.goloyalty;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.GoLoyaltyDealsVM;
import com.goshop.app.presentation.model.GoLoyaltyDetailsVM;
import com.goshop.app.presentation.model.GoLoyaltyModel;
import com.goshop.app.presentation.model.GoLoyaltyTopVM;
import com.goshop.app.utils.GlideUtils;
import com.goshop.app.widget.listener.OnDealsItemClickListener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoLoyaltyAdapter extends RecyclerView.Adapter implements OnDealsItemClickListener{

    private List<GoLoyaltyModel> goLoyaltyModels;

    private OnGoLoyaltyItemsClickListener onGoLoyaltyItemsClickListener;

    public GoLoyaltyAdapter(
        List<GoLoyaltyModel> goLoyaltyModels) {
        this.goLoyaltyModels = goLoyaltyModels;
    }

    public void setUpdatas(List<GoLoyaltyModel> goLoyaltyModels) {
        this.goLoyaltyModels.clear();
        this.goLoyaltyModels = goLoyaltyModels;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case GoLoyaltyModel.VIEW_TYPE_TOP:
                View topView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_go_loyalty_top, parent, false);
                viewHolder = new TopViewHolder(topView);
                break;
            case GoLoyaltyModel.VIEW_TYPE_DETAIL:
                View detailsView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_go_loyalty_details, parent, false);
                viewHolder = new DetailViewHolder(detailsView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GoLoyaltyModel goLoyaltyModel = goLoyaltyModels.get(position);
        if (holder instanceof TopViewHolder) {
            ((TopViewHolder) holder).bindingData((GoLoyaltyTopVM) goLoyaltyModel);
        } else if (holder instanceof DetailViewHolder) {
            ((DetailViewHolder) holder).bindingData((GoLoyaltyDetailsVM) goLoyaltyModel, this);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return goLoyaltyModels.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return goLoyaltyModels.size();
    }

    public void setOnGoLoyaltyItemsClickListener(
        OnGoLoyaltyItemsClickListener onGoLoyaltyItemsClickListener) {
        this.onGoLoyaltyItemsClickListener = onGoLoyaltyItemsClickListener;
    }

    @Override
    public void onDealItemClick(GoLoyaltyDealsVM dealsVM) {
        onGoLoyaltyItemsClickListener.onDealItemClick();
    }

    public interface OnGoLoyaltyItemsClickListener {

        void onPointsItemClick();

        void onDealItemClick();

        void onViewAllClick();
    }

    class TopViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_go_loyalty_thumb)
        ImageView ivGoLoyaltyThumb;

        @BindView(R.id.ll_loyalty_id)
        LinearLayout llLoyaltyId;

        @BindView(R.id.ll_loyalty_points)
        LinearLayout llLoyaltyPoints;

        @BindView(R.id.tv_go_loyalty_name)
        RobotoLightTextView tvGoLoyaltyName;

        @BindView(R.id.tv_loyalty_id)
        RobotoMediumTextView tvLoyaltyId;

        @BindView(R.id.tv_loyalty_points)
        RobotoMediumTextView tvLoyaltyPoints;

        public TopViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(GoLoyaltyTopVM goLoyaltyTopVM) {
            GlideUtils.loadImageError(
                itemView.getContext(),
                goLoyaltyTopVM.getUserUrl(),
                ivGoLoyaltyThumb,
                R.drawable.ic_image_404_big);
            tvGoLoyaltyName.setText(goLoyaltyTopVM.getUserName());
            tvLoyaltyId.setText(goLoyaltyTopVM.getUserId());
            tvLoyaltyPoints.setText(goLoyaltyTopVM.getUserPoints());
            llLoyaltyId.setOnClickListener(v -> {
            });
            llLoyaltyPoints.setOnClickListener(v -> onGoLoyaltyItemsClickListener.onPointsItemClick());
        }
    }

    class DetailViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.recyclerview_deals)
        RecyclerView recyclerViewDeals;

        @BindView(R.id.tv_btn_go_loyalty_more)
        RobotoRegularTextView tvBtnGoLoyaltyMore;

        @BindView(R.id.tv_go_loyalty_title)
        RobotoMediumTextView tvGoLoyaltyTitle;

        public DetailViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(GoLoyaltyDetailsVM goLoyaltyDetailsVM, OnDealsItemClickListener onDealItemClickListener) {
            tvGoLoyaltyTitle.setText(goLoyaltyDetailsVM.getTitle());
            tvBtnGoLoyaltyMore.setOnClickListener(v -> onGoLoyaltyItemsClickListener.onViewAllClick());
            LinearLayoutManager manager = new LinearLayoutManager(itemView.getContext());
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerViewDeals.setLayoutManager(manager);
            DealsAdapter dealsAdapter = new DealsAdapter(goLoyaltyDetailsVM.getDealsVMS());
            recyclerViewDeals.setAdapter(dealsAdapter);
            dealsAdapter.setOnDealItemClickListener(onDealItemClickListener);
        }
    }
}
