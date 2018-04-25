package com.goshop.app.presentation.myorder;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.model.MyOrdersVM;
import com.goshop.app.utils.NumberFormater;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyOrdersAdapter extends RecyclerView.Adapter {

    private List<MyOrdersVM> myOrdersVMS;

    private OnOrdersItemClickListener onOrdersItemClickListener;

    public MyOrdersAdapter(List<MyOrdersVM> myOrdersVMS) {
        this.myOrdersVMS = myOrdersVMS;
    }

    public void setUpdateDatas(List<MyOrdersVM> myOrdersVMS) {
        this.myOrdersVMS.clear();
        this.myOrdersVMS = myOrdersVMS;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_my_orders, parent, false);
        return new MyOrdersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((MyOrdersViewHolder) holder).bindingData(myOrdersVMS.get(position), position);
    }

    @Override
    public int getItemCount() {
        return myOrdersVMS.size();
    }

    public void setOnOrdersItemClickListener(OnOrdersItemClickListener onOrdersItemClickListener) {
        this.onOrdersItemClickListener = onOrdersItemClickListener;
    }

    interface OnOrdersItemClickListener {

        void onOrdersItemClick();

        void onWriteReviewClick();

        void onTrackClick();

        void onReturnClick();
    }

    class MyOrdersViewHolder extends RecyclerView.ViewHolder implements MyOrderProductAdapter
        .OnOrderDetailItemClickListener {

        @BindView(R.id.ll_my_orders)
        LinearLayout llMyOrders;

        @BindView(R.id.recyclerview_orders)
        RecyclerView recyclerViewOrders;

        @BindView(R.id.tv_myorders_status)
        RobotoMediumTextView tvMyOrdersStatus;

        @BindView(R.id.tv_myorders_total)
        RobotoMediumTextView tvMyOrdersTotal;

        @BindView(R.id.tv_myorders_number)
        RobotoMediumTextView tvMyordersNumber;

        @BindView(R.id.view_my_orders_divider)
        View viewMyOrdersDivider;

        public MyOrdersViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(MyOrdersVM myOrdersVM, int position) {
            viewMyOrdersDivider.setVisibility(position == 0 ? View.GONE : View.VISIBLE);
            tvMyOrdersTotal.setText(myOrdersVM.getTotalPrice());
            tvMyordersNumber.setText(myOrdersVM.getOrderNumber());
            tvMyOrdersStatus.setText(myOrdersVM.getOrderStatus());
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
            recyclerViewOrders.setLayoutManager(layoutManager);
            MyOrderProductAdapter orderProductAdapter = new MyOrderProductAdapter(
                myOrdersVM.getMyOrdersProductVMS());
            recyclerViewOrders.setAdapter(orderProductAdapter);
            orderProductAdapter.setOnOrderDetailItemClickListener(this);
            llMyOrders.setOnClickListener(v -> onOrdersItemClickListener.onOrdersItemClick());
        }

        @Override
        public void onWriteReviewClick() {
            onOrdersItemClickListener.onWriteReviewClick();
        }

        @Override
        public void onTrackClick() {
            onOrdersItemClickListener.onTrackClick();
        }

        @Override
        public void onReturnClick() {
            onOrdersItemClickListener.onReturnClick();
        }
    }

}
