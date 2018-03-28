package com.goshop.app.widget.viewholder;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.widget.listener.OnProductItemClickListener;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductGridViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_grid_pic)
    ImageView ivGridPic;

    @BindView(R.id.tv_grid_now_price)
    RobotoMediumTextView tvGridNowPrice;

    @BindView(R.id.tv_grid_old)
    RobotoLightTextView tvGridOld;

    @BindView(R.id.tv_grid_percent)
    RobotoMediumTextView tvGridPercent;

    @BindView(R.id.tv_grid_title)
    RobotoLightTextView tvGridTitle;

    public ProductGridViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindingData(ProductsVM productsVM,
        OnProductItemClickListener onProductItemClickListener) {
        Glide.with(itemView.getContext()).load(productsVM.getImage()).asBitmap()
            .error(R.drawable.ic_bought)
            .into(ivGridPic);
        tvGridPercent.setText(productsVM.getPriceVM().getRm().getDiscountTitle());
        tvGridTitle.setText(productsVM.getTitle());
        String oldPrice = productsVM.getPriceVM().getRm().getOriginal();
        String nowPrice = productsVM.getPriceVM().getRm().getDiscounted();
        tvGridOld.setText(oldPrice);
        tvGridNowPrice.setText(nowPrice);
        tvGridOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        if (onProductItemClickListener != null) {
            itemView
                .setOnClickListener(v -> onProductItemClickListener.onProductItemClick(productsVM));
        }

    }
}
