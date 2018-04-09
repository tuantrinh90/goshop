package com.goshop.app.adapter;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.listener.IRecyclerItemClick;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.data.model.response.CheckoutResponse;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckoutListAdapter extends RecyclerView.Adapter {

    IRecyclerItemClick iRecyclerItemClick;

    List<CheckoutResponse.CheckoutItem> results = new ArrayList<>();

    public CheckoutListAdapter(List<CheckoutResponse.CheckoutItem> results) {
        this.results = results;
    }

    public void setiRecyclerItemClick(IRecyclerItemClick iRecyclerItemClick) {
        this.iRecyclerItemClick = iRecyclerItemClick;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_checkout_item, parent, false);
        return new CheckoutHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        CheckoutResponse.CheckoutItem checkoutItem = results.get(position);
        CheckoutHolder holder = (CheckoutHolder) viewHolder;
        holder.tvCheckoutAmount.setText(checkoutItem.getAmount());
        Glide.with(holder.itemView.getContext()).load(checkoutItem.getImage()).asBitmap()
            .error(R.drawable.ic_right_video_demo)
            .into(holder.ivCheckoutItemIcon);
        holder.tvCheckoutProductName.setText(checkoutItem.getProductName());
        holder.tvCheckoutColorAndSize
            .setText(checkoutItem.getColor() + "," + checkoutItem.getSize());
        holder.tvCheckoutOldPrice.setText(checkoutItem.getOldPrice());
        holder.tvCheckoutPrice.setText(checkoutItem.getCurrentPrice());
        holder.tvCheckoutAmount.setText(checkoutItem.getAmount());

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    private SpannableString setBoldText(String frontText, String behindText) {
        String allText = frontText + behindText;
        SpannableString spannableString = new SpannableString(allText);
        StyleSpan styleSpan = new StyleSpan(Typeface.BOLD);
        spannableString.setSpan(styleSpan, frontText.length(), allText.length(),
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    static class CheckoutHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_checkout_item_icon)
        ImageView ivCheckoutItemIcon;

        @BindView(R.id.tv_checkout_amount)
        RobotoLightTextView tvCheckoutAmount;

        @BindView(R.id.tv_checkout_color_and_size)
        RobotoLightTextView tvCheckoutColorAndSize;

        @BindView(R.id.tv_checkout_old_price)
        RobotoLightTextView tvCheckoutOldPrice;

        @BindView(R.id.tv_checkout_price)
        RobotoMediumTextView tvCheckoutPrice;

        @BindView(R.id.tv_checkout_product_name)
        RobotoLightTextView tvCheckoutProductName;

        public CheckoutHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }


}