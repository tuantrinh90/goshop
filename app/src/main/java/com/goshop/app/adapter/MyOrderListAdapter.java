package com.goshop.app.adapter;

import com.bumptech.glide.Glide;
import com.goshop.app.Const;
import com.goshop.app.R;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.data.model.response.MyOrderDetailReponse;
import com.goshop.app.data.model.response.MyOrderListResponse;
import com.goshop.app.presentation.myorder.MyOrderDetailActivity;
import com.goshop.app.utils.ScreenHelper;
import com.orhanobut.logger.Logger;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by img on 2018/1/30.
 */

public class MyOrderListAdapter extends RecyclerView.Adapter {

    List<MyOrderListResponse.ResultsBean> results = new ArrayList<>();

    public MyOrderListAdapter(List<MyOrderListResponse.ResultsBean> results) {
        this.results = results;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case Const.MYORDER_LIST_TITLE:
                View topTitle = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_order_list_top_title, parent, false);
                viewHolder = new TitleHolder(topTitle);
                break;
            case Const.MYORDER_LIST_CONTENT:
                View bodyView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_order_list_content, parent, false);
                viewHolder = new BodyHolder(bodyView);
                break;
            case Const.MYORDER_LIST_PRICE:
                View bottomView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_order_list_bottom_price, parent, false);
                viewHolder = new BottomPriceHolder(bottomView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        MyOrderListResponse.ResultsBean resultsBean = results.get(position);

        if (viewHolder instanceof TitleHolder) {
            TitleHolder holder = (TitleHolder) viewHolder;
            SpannableString orderString = setBoldText(holder.orderNumber, resultsBean.getOrderSn());
            holder.tvOrderNum.setText(orderString);

            SpannableString statusString = setBoldText(holder.orderStatus, resultsBean.getStatus());
            holder.tvOrderStatus.setText(statusString);

        } else if (viewHolder instanceof BodyHolder) {
            BodyHolder holder = (BodyHolder) viewHolder;
            holder.bindingData(holder, resultsBean);

        } else if (viewHolder instanceof BottomPriceHolder) {
            BottomPriceHolder holder = (BottomPriceHolder) viewHolder;
            SpannableString priceString = setBoldText(holder.orderTotalPrice,
                resultsBean.getTotal());
            holder.tvOrderListTotalPrice.setText(priceString);
        }
    }

    private SpannableString setBoldText(String frontText, String behindText) {
        String allText = frontText + behindText;
        SpannableString spannableString = new SpannableString(allText);
        StyleSpan styleSpan = new StyleSpan(Typeface.BOLD);
        spannableString.setSpan(styleSpan, frontText.length(), allText.length(),
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    @Override
    public int getItemViewType(int position) {
        return results.get(position).getType();
    }

    static class ViewHolder {

    }

    static class TitleHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_order_num)
        CustomTextView tvOrderNum;

        @BindView(R.id.tv_order_status)
        CustomTextView tvOrderStatus;

        @BindString(R.string.my_orders_title_number)
        String orderNumber;

        @BindString(R.string.my_orders_title_status)
        String orderStatus;

        public TitleHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class BodyHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_order_product_id)
        CustomTextView tvOrderProductId;

        @BindView(R.id.tv_order_product_track)
        CustomTextView tvOrderProductTrack;

        @BindView(R.id.iv_order_product_product_icon)
        ImageView ivProductIcon;

        @BindView(R.id.tv_order_product_price)
        CustomTextView tvOrderProductPrice;

        @BindView(R.id.tv_order_product_title)
        CustomTextView tvOrderProductTitle;

        @BindView(R.id.tv_order_product_color)
        CustomTextView tvOrderItemColor;

        @BindView(R.id.tv_order_product_size)
        CustomTextView tvOrderItemSize;

        @BindView(R.id.tv_order_product_amount)
        CustomTextView tvOrderProductAmount;

        @BindView(R.id.rl_order_list_product_body)
        RelativeLayout rlOrderListBody;

        public BodyHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick({R.id.tv_order_product_track, R.id.rl_order_list_product_body})
        public void onViewClicked(View view) {
            switch (view.getId()) {
                case R.id.tv_order_product_track:
                    //TODO joyson temp code
                    Logger.e("click track");
                    break;
                case R.id.rl_order_list_product_body:
                    itemView.getContext().startActivity(new Intent(itemView.getContext(),
                        MyOrderDetailActivity.class));
                    break;
            }
        }

        void bindingDetail(BodyHolder holder, MyOrderDetailReponse.SubordersBean subordersBean) {
            Glide.with(holder.itemView.getContext()).load(subordersBean.getImage())
                .into(ivProductIcon);
            SpannableString italicString = setItalicText(subordersBean.getProductId() + " ",
                subordersBean.getStatus());
            tvOrderProductId.setText(italicString);
            Glide.with(holder.itemView.getContext()).load(subordersBean.getImage())
                .into(ivProductIcon);
            tvOrderProductPrice.setText(subordersBean.getPrice());
            tvOrderProductTitle.setText(subordersBean.getName());
            tvOrderProductAmount.setText(subordersBean.getQty() + "");
        }

        void bindingData(BodyHolder holder, MyOrderListResponse.ResultsBean resultsBean) {
            SpannableString italicString = setItalicText(resultsBean.getProductId() + " ",
                resultsBean.getStatus());
            tvOrderProductId.setText(italicString);
            Glide.with(holder.itemView.getContext()).load(resultsBean.getImage())
                .into(ivProductIcon);
            tvOrderProductPrice.setText(resultsBean.getPrice());
            tvOrderProductTitle.setText(resultsBean.getName());
            tvOrderProductAmount.setText(resultsBean.getQty() + "");
        }

        private SpannableString setItalicText(String frontText, String behindText) {
            String allText = frontText + behindText;
            SpannableString spannableString = new SpannableString(allText);
            StyleSpan styleItalic = new StyleSpan(Typeface.ITALIC);
            ForegroundColorSpan colorSpan = new ForegroundColorSpan(
                ScreenHelper.getColor(R.color.colorAccent));
            spannableString.setSpan(colorSpan, frontText.length(), allText.length(),
                Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            spannableString.setSpan(styleItalic, frontText.length(), allText.length(),
                Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            return spannableString;
        }
    }

    static class BottomPriceHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_order_list_total_price)
        CustomTextView tvOrderListTotalPrice;

        @BindString(R.string.my_orders_total_price)
        String orderTotalPrice;

        public BottomPriceHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }

}
