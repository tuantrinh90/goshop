package com.goshop.app.widget.viewholder;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.widget.ProductFilterListVM;
import com.goshop.app.widget.adapter.WidgetProductGridVerticalAdapter;
import com.goshop.app.widget.listener.OnFilterMenuClickListener;
import com.goshop.app.widget.listener.OnProductItemClickListener;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilterListViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_btn_filter)
    ImageView ivBtnFilter;

    @BindView(R.id.iv_sort_arrow)
    ImageView ivSortArrow;

    @BindView(R.id.recyclerview_filter)
    RecyclerView recyclerView;

    @BindView(R.id.tv_btn_sort)
    CustomTextView tvBtnSort;

    public FilterListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindingData(ProductFilterListVM filterListVM,
        OnProductItemClickListener onProductItemClickListener,
        OnFilterMenuClickListener onFilterMenuClickListener) {
        ivBtnFilter.setOnClickListener(v -> {
            onFilterMenuClickListener.onFilterClick();
        });
        ivSortArrow.setOnClickListener(v -> {
            onFilterMenuClickListener.onSortClick();
        });
        tvBtnSort.setOnClickListener(v -> {
            onFilterMenuClickListener.onSortClick();
        });
        GridLayoutManager layoutManager = new GridLayoutManager(itemView.getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        WidgetProductGridVerticalAdapter gridVerticalAdapter = new WidgetProductGridVerticalAdapter(
            onProductItemClickListener, filterListVM.getProductsVMS());
        recyclerView.setAdapter(gridVerticalAdapter);
    }
}
