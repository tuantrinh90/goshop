package com.goshop.app.presentation.account;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.PointsDetailVM;
import com.goshop.app.presentation.model.PointsModel;
import com.goshop.app.presentation.model.PointsTotalVM;

import android.annotation.SuppressLint;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyPointsAdapter extends RecyclerView.Adapter {

    private List<PointsModel> pointsModels;

    public MyPointsAdapter(List<PointsModel> pointsModels) {
        this.pointsModels = pointsModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case PointsModel.VIEW_TYPE_TOTAL:
                View totalView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_points_total_points, parent, false);
                viewHolder = new PointTotalViewHolder(totalView);
                break;
            case PointsModel.VIEW_TYPE_TRANSACTIONS_DETAIL:
                View detailView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_points_transactions_detail, parent, false);
                viewHolder = new PointDetailViewHolder(detailView);
                break;
            case PointsModel.VIEW_TYPE_TRANSACTIONS_TITLE:
                View titleView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_points_transactions_title, parent, false);
                viewHolder = new PointTitleViewHolder(titleView);
                break;
            case PointsModel.VIEW_TYPE_TRANSACTIONS_NODATA:
                View nodataView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_points_transactions_nodata, parent, false);
                viewHolder = new PointNoDataViewHolder(nodataView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PointsModel pointsModel = pointsModels.get(position);
        if (holder instanceof PointTotalViewHolder) {
            ((PointTotalViewHolder) holder).bindingData((PointsTotalVM) pointsModel);
        } else if (holder instanceof PointDetailViewHolder) {
            ((PointDetailViewHolder) holder).bindingData((PointsDetailVM) pointsModel);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return pointsModels.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return pointsModels.size();
    }

    class PointTitleViewHolder extends RecyclerView.ViewHolder {

        public PointTitleViewHolder(View itemView) {
            super(itemView);
        }
    }

    class PointNoDataViewHolder extends RecyclerView.ViewHolder {

        public PointNoDataViewHolder(View itemView) {
            super(itemView);
        }
    }

    class PointTotalViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_points_totals)
        RobotoMediumTextView tvPointsTotals;

        public PointTotalViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(PointsTotalVM totalVM) {
            tvPointsTotals.setText(totalVM.getTotal());
        }
    }

    class PointDetailViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_points_counts)
        RobotoRegularTextView tvPointsCounts;

        @BindView(R.id.tv_points_date)
        RobotoLightTextView tvPointsDate;

        @BindView(R.id.tv_points_description)
        RobotoLightTextView tvPointsDescription;

        @BindView(R.id.tv_points_order_no)
        RobotoLightTextView tvPointsOrderNo;

        @BindView(R.id.tv_points_time)
        RobotoLightTextView tvPointsTime;

        public PointDetailViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @SuppressLint("SetTextI18n")
        void bindingData(PointsDetailVM detailVM) {
            tvPointsCounts.setText(detailVM.getPoints());
            tvPointsCounts.setTextColor(
                ContextCompat.getColor(itemView.getContext(), detailVM
                    .getType() == 1 ? R.color.color_main_pink : R.color.color_grayscale_text));
            tvPointsDate.setText(detailVM.getDate());
            tvPointsDescription.setText(detailVM.getDescription());
            tvPointsOrderNo.setText(detailVM.getOrderNo());
            tvPointsTime.setText(detailVM.getTime());
        }
    }
}
