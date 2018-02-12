package com.goshop.app.widget;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.presentation.model.widget.WidgetSinglePictureVM;
import com.goshop.app.widget.WidgetListener.OnSinglePicturClickListener;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by helen on 2018/2/11.
 */

public class WidgetSinglePictureViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_single_picture)
    ImageView ivSinglePicture;

    public WidgetSinglePictureViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bindingData(WidgetSinglePictureVM singlePictureVM,
        OnSinglePicturClickListener onSinglePicturClickListener) {
        Glide.with(itemView.getContext()).load(singlePictureVM.getImageUrl()).asBitmap()
            .error(singlePictureVM.getIconDefault())
            .into(ivSinglePicture);
        itemView.setOnClickListener(v -> {
            onSinglePicturClickListener.onSinglePictureClick(singlePictureVM);
        });
    }
}
