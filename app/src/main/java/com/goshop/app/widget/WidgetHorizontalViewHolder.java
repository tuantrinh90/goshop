package com.goshop.app.widget;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.presentation.model.WidgetHorizontalVM;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by helen on 2018/2/11.
 */

public class WidgetHorizontalViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.recyclerview_horizontal)
    RecyclerView recyclerViewHorizontal;

    @BindView(R.id.tv_horizontal_title)
    CustomBoldTextView tvHorizontalTitle;

    public WidgetHorizontalViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bindingData(WidgetHorizontalVM detailHorizontalVM) {
        tvHorizontalTitle.setText(detailHorizontalVM.getTitle());
        LinearLayoutManager manager = new LinearLayoutManager(itemView.getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewHorizontal.setLayoutManager(manager);
        WidgetGridDetailAdapter detailAdapter = new WidgetGridDetailAdapter(
            detailHorizontalVM.getDetailVMS());
        recyclerViewHorizontal.setAdapter(detailAdapter);
    }
}
