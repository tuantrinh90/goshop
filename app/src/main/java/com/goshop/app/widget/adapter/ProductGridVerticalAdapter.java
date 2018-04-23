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

public class ProductGridVerticalAdapter extends RecyclerView.Adapter {

    private OnProductItemClickListener onProductItemClickListener;

    private List<VideoProductsVM> productsVMS;

    public ProductGridVerticalAdapter(List<VideoProductsVM> detailVMS) {
        this.productsVMS = detailVMS;
    }

    public void setOnProductItemClickListener(OnProductItemClickListener onProductItemClickListener) {
        this.onProductItemClickListener = onProductItemClickListener;
    }

    public void setUpdateDatas(List<VideoProductsVM> productsVMS) {
        this.productsVMS.clear();
        this.productsVMS = productsVMS;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_grid_vertical_detail, parent, false);
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
