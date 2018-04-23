package com.goshop.app.widget.adapter;

import com.goshop.app.R;
import com.goshop.app.presentation.model.widget.VideoProductsVM;
import com.goshop.app.widget.listener.OnProductItemClickListener;
import com.goshop.app.widget.viewholder.ProductGridViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ProductGridHorizontalAdapter extends RecyclerView.Adapter {

    private OnProductItemClickListener onProductItemClickListener;

    private List<VideoProductsVM> productsVMS;

    public ProductGridHorizontalAdapter(OnProductItemClickListener onProductItemClickListener,
        List<VideoProductsVM> detailVMS) {
        this.onProductItemClickListener = onProductItemClickListener;
        this.productsVMS = detailVMS;
    }

    public ProductGridHorizontalAdapter(List<VideoProductsVM> detailVMS) {
        this.productsVMS = detailVMS;
    }

    public void setOnProductItemClickListener(
        OnProductItemClickListener onProductItemClickListener) {
        this.onProductItemClickListener = onProductItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_grid_horizontal_detail, parent, false);
        return new ProductGridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ProductGridViewHolder) holder)
            .bindingData(productsVMS.get(position), onProductItemClickListener);
    }

    @Override
    public int getItemCount() {
        return productsVMS.size();
    }

}
