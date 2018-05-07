package com.goshop.app.widget;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.presentation.model.widget.WidgetSinglePictureVM;
import com.goshop.app.utils.GlideUtils;
import com.goshop.app.widget.listener.OnSinglePicturClickListener;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WidgetSinglePictureViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_single_picture)
    ImageView ivSinglePicture;

    public WidgetSinglePictureViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bindingData(WidgetSinglePictureVM singlePictureVM,
        OnSinglePicturClickListener onSinglePicturClickListener) {
        //todo wait for api
        GlideUtils.loadImageError(
            itemView.getContext(),
            ""/*singlePictureVM.getOfferListItemsVMS().get(0).getImage()*/,
            ivSinglePicture,
            R.drawable.ic_detail_top_demo);
        itemView.setOnClickListener(v -> onSinglePicturClickListener.onSinglePictureClick(singlePictureVM));
    }
}
