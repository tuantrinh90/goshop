package com.goshop.app.presentation.myorder;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.RobotoItaticTextView;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.model.MyOrdersProductVM;
import com.goshop.app.utils.NumberFormater;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyOrderProductAdapter extends RecyclerView.Adapter {

    private List<MyOrdersProductVM> myOrdersProductVMS;

    private OnOrderDetailItemClickListener onOrderDetailItemClickListener;

    public MyOrderProductAdapter(
        List<MyOrdersProductVM> myOrdersProductVMS) {
        this.myOrdersProductVMS = myOrdersProductVMS;
    }

    public void setUpdateDatas(List<MyOrdersProductVM> myOrdersProductVMS) {
        this.myOrdersProductVMS.clear();
        this.myOrdersProductVMS = myOrdersProductVMS;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_order_product, parent, false);
        return new MyOrdersProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyOrdersProductViewHolder) holder).bindingDatas(myOrdersProductVMS.get(position));
    }

    @Override
    public int getItemCount() {
        return myOrdersProductVMS.size();
    }

    public void setOnOrderDetailItemClickListener(
        OnOrderDetailItemClickListener onOrderDetailItemClickListener) {
        this.onOrderDetailItemClickListener = onOrderDetailItemClickListener;
    }

    public interface OnOrderDetailItemClickListener {

        void onWriteReviewClick();

        void onTrackClick();

        void onReturnClick();
    }

    class MyOrdersProductViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_order_product_thumb)
        ImageView ivOrderProductThumb;

        @BindView(R.id.tv_order_product_attr)
        RobotoLightTextView tvOrderProductAttr;

        @BindView(R.id.tv_order_product_count)
        RobotoLightTextView tvOrderProductCount;

        @BindView(R.id.tv_order_product_now)
        RobotoMediumTextView tvOrderProductNow;

        @BindView(R.id.tv_order_product_number)
        RobotoLightTextView tvOrderProductNumber;

        @BindView(R.id.tv_order_product_old)
        RobotoLightTextView tvOrderProductOld;

        @BindView(R.id.tv_order_product_statu)
        RobotoItaticTextView tvOrderProductStatu;

        @BindView(R.id.tv_order_product_title)
        RobotoLightTextView tvOrderProductTitle;

        @BindView(R.id.tv_order_product_track)
        RobotoLightTextView tvOrderProductTrack;

        @BindView(R.id.tv_order_product_write)
        RobotoLightTextView tvOrderProductWrite;

        public MyOrdersProductViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingDatas(MyOrdersProductVM productVM) {
            tvOrderProductNumber.setText(productVM.getStatuNo());
            tvOrderProductStatu.setText(productVM.getStatuContent());
            //todo this hard code is wait for api
            tvOrderProductTrack
                .setText(productVM.getStatuContent().equals("Delivered") ? "Return" : "Track");

            Glide.with(itemView.getContext()).load(productVM.getThumb()).asBitmap()
                .error(productVM.getThumbDefault())
                .into(ivOrderProductThumb);
            tvOrderProductTitle.setText(productVM.getTitle());
            tvOrderProductOld.setText(NumberFormater.formaterMoney(productVM.getPriceOld()));
            tvOrderProductOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            tvOrderProductNow.setText(NumberFormater.formaterMoney(productVM.getPriceNow()));
            //todo hard code wait for decide
            tvOrderProductCount.setText("x" + productVM.getCount());
            List<String> attrs = productVM.getAttr();
            String attr = "Color:" + attrs.get(0) + ", Size:" + attrs.get(1);
            tvOrderProductAttr.setText(attr);
            tvOrderProductTrack.setOnClickListener(v -> {
                if (productVM.getStatuContent().equals("Delivered")) {
                    onOrderDetailItemClickListener.onReturnClick();
                } else {
                    onOrderDetailItemClickListener.onTrackClick();
                }

            });
            tvOrderProductWrite.setOnClickListener(v -> onOrderDetailItemClickListener.onWriteReviewClick());
        }
    }
}