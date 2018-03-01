package com.goshop.app.widget.viewholder;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.SortVM;
import com.goshop.app.presentation.model.widget.ProductSortFilterListVM;
import com.goshop.app.widget.adapter.WidgetProductGridVerticalAdapter;
import com.goshop.app.widget.listener.OnProductItemClickListener;
import com.goshop.app.widget.listener.OnSortFilterClickListener;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SortFilterViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_btn_filter)
    ImageView ivBtnFilter;

    @BindView(R.id.iv_sort_arrow)
    ImageView ivSortArrow;

    @BindView(R.id.recyclerview_filter)
    RecyclerView recyclerView;

    /*@BindView(R.id.spinner_sort)
    Spinner spinnerSort;*/

    @BindView(R.id.tv_btn_sort)
    CustomTextView tvBtnSort;

    private List<SortVM> sortVMS;

    public SortFilterViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindingData(ProductSortFilterListVM sortFilterListVM,
        OnProductItemClickListener onProductItemClickListener,
        OnSortFilterClickListener onSortFilterClickListener) {
        List<SortVM> sortVMS = sortFilterListVM.getSortVMS();
        Log.d("SortFilter", "size:-" + sortVMS.size());
        ivBtnFilter.setOnClickListener(v -> {
            onSortFilterClickListener.onFilterClick(itemView);
        });
        ivSortArrow.setOnClickListener(v -> {
            ivSortArrow.setSelected(!ivSortArrow.isSelected());
            onSortFilterClickListener.onSortClick(itemView, sortVMS);
        });
        tvBtnSort.setOnClickListener(v -> {
            ivSortArrow.setSelected(!ivSortArrow.isSelected());
            onSortFilterClickListener.onSortClick(tvBtnSort, sortVMS);
        });
        GridLayoutManager layoutManager = new GridLayoutManager(itemView.getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        WidgetProductGridVerticalAdapter gridVerticalAdapter = new WidgetProductGridVerticalAdapter(
            onProductItemClickListener, sortFilterListVM.getProductsVMS());
        recyclerView.setAdapter(gridVerticalAdapter);
    }
}
