package com.goshop.app.adapter;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.model.common.ProductVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckoutListAdapter extends RecyclerView.Adapter {

    private List<ProductVM> productVMS;

    public CheckoutListAdapter(
        List<ProductVM> productVMS) {
        this.productVMS = productVMS;
    }

    public void setProductVMS(List<ProductVM> productVMS) {
        this.productVMS.clear();
        this.productVMS = productVMS;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_checkout_item, parent, false);
        return new CheckoutHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ((CheckoutHolder)viewHolder).bindingData(productVMS.get(position));
    }

    @Override
    public int getItemCount() {
        return productVMS.size();
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

        void bindingData(ProductVM productVM) {
            Glide.with(itemView.getContext()).load(productVM.getImage()).asBitmap()
                .error(productVM.getImageDefault())
                .into(ivCheckoutItemIcon);
            tvCheckoutAmount.setText(productVM.getAmount());
            //todo hard code wait for api
            tvCheckoutColorAndSize.setText("Color:Blue;Size:L");
            tvCheckoutOldPrice.setText(productVM.getOldPrice());
            tvCheckoutPrice.setText(productVM.getNowPrice());
            tvCheckoutProductName.setText(productVM.getTitle());
        }
    }
}
