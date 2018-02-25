package com.goshop.app.widget.viewholder;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.widget.listener.OnProductBuyClickListener;
import com.goshop.app.widget.listener.OnProductItemClickListener;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoProductItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_video_product_thumb)
    ImageView ivVideoProductThumb;

    @BindView(R.id.tv_btn_video_product_buy)
    CustomTextView tvBtnVideoProductBuy;

    @BindView(R.id.tv_video_product_now)
    CustomBoldTextView tvVideoProductNow;

    @BindView(R.id.tv_video_product_old)
    CustomTextView tvVideoProductOld;

    @BindView(R.id.tv_video_product_percent)
    CustomBoldTextView tvVideoProductPercent;

    @BindView(R.id.tv_video_product_title)
    CustomTextView tvVideoProductTitle;

    public VideoProductItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindingData(ProductsVM productsVM,
        OnProductItemClickListener onProductItemClickListener,
        OnProductBuyClickListener buyClickListener) {
        tvVideoProductTitle.setText(productsVM.getTitle());
        tvVideoProductOld.setText(productsVM.getPriceVM().getRm().getOriginal());
        tvVideoProductOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tvVideoProductNow.setText(productsVM.getPriceVM().getRm().getDiscounted());
        tvVideoProductPercent.setText(productsVM.getPriceVM().getRm().getDiscountTitle());
        Glide.with(itemView.getContext()).load(productsVM.getImage()).asBitmap()
            .error(R.drawable.ic_bought)
            .into(ivVideoProductThumb);

        tvBtnVideoProductBuy.setOnClickListener(v -> buyClickListener.onBuyNowClick(productsVM));

        itemView.setOnClickListener(v -> onProductItemClickListener.onProductItemClick(productsVM));
    }
}
