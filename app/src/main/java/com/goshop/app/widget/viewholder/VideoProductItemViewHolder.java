package com.goshop.app.widget.viewholder;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.utils.GlideUtils;
import com.goshop.app.utils.NumberFormater;
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
    RobotoLightTextView tvBtnVideoProductBuy;

    @BindView(R.id.tv_video_product_now)
    RobotoMediumTextView tvVideoProductNow;

    @BindView(R.id.tv_video_product_old)
    RobotoLightTextView tvVideoProductOld;

    @BindView(R.id.tv_video_product_percent)
    RobotoRegularTextView tvVideoProductPercent;

    @BindView(R.id.tv_video_product_title)
    RobotoLightTextView tvVideoProductTitle;

    public VideoProductItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindingData(ProductsVM productsVM,
        OnProductItemClickListener onProductItemClickListener,
        OnProductBuyClickListener buyClickListener) {
        tvVideoProductTitle.setText(productsVM.getName());
        tvVideoProductOld
            .setText(NumberFormater.formaterPrice(productsVM.getPriceVM().getRm().getOriginal()));
        tvVideoProductOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tvVideoProductNow
            .setText(NumberFormater.formaterPrice(productsVM.getPriceVM().getRm().getDiscounted()));
        tvVideoProductPercent.setText(productsVM.getPriceVM().getRm().getDiscountTitle());
        GlideUtils.loadImageError(
            itemView.getContext(),
            productsVM.getImage(),
            ivVideoProductThumb,
            R.drawable.ic_image_404_small);

        tvBtnVideoProductBuy.setOnClickListener(v -> buyClickListener.onBuyNowClick(productsVM));

        itemView.setOnClickListener(v -> onProductItemClickListener.onProductItemClick(productsVM));
    }

    public View getItemView() {
        return itemView;
    }

}
