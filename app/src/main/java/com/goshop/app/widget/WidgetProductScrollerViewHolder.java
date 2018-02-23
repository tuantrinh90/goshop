package com.goshop.app.widget;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.presentation.model.widget.WidgetProductScrollerVM;
import com.goshop.app.widget.WidgetListener.OnProductItemClickListener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by helen on 2018/2/11.
 */

public class WidgetProductScrollerViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.recyclerview_horizontal)
    RecyclerView recyclerViewHorizontal;

    public WidgetProductScrollerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bindingData(WidgetProductScrollerVM detailHorizontalVM,
        OnProductItemClickListener onProductItemClickListener) {
        LinearLayoutManager manager = new LinearLayoutManager(itemView.getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewHorizontal.setLayoutManager(manager);
        WidgetProductItemlAdapter detailAdapter = new WidgetProductItemlAdapter(
            onProductItemClickListener,
            detailHorizontalVM.getData().getItems());
        recyclerViewHorizontal.setAdapter(detailAdapter);
    }
}
