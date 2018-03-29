package com.goshop.app.widget;

import com.goshop.app.R;
import com.goshop.app.presentation.model.widget.WidgetProductScrollerVM;
import com.goshop.app.widget.adapter.ProductGridHorizontalAdapter;
import com.goshop.app.widget.listener.OnProductItemClickListener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WidgetProductScrollerViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.recyclerview_horizontal)
    RecyclerView recyclerViewHorizontal;

    public WidgetProductScrollerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bindingData(WidgetProductScrollerVM productScrollerVM,
        OnProductItemClickListener onProductItemClickListener) {
        LinearLayoutManager manager = new LinearLayoutManager(itemView.getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewHorizontal.setLayoutManager(manager);
        ProductGridHorizontalAdapter detailAdapter = new ProductGridHorizontalAdapter(
            onProductItemClickListener,
            productScrollerVM.getProductsVMS());
        recyclerViewHorizontal.setAdapter(detailAdapter);
    }
}
