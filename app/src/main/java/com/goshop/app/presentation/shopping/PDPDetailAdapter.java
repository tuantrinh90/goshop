package com.goshop.app.presentation.shopping;

import com.goshop.app.presentation.model.ProductDetailModel;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public class PDPDetailAdapter extends RecyclerView.Adapter {

    private List<ProductDetailModel> productDetailModels;

    public PDPDetailAdapter(List<ProductDetailModel> productDetailModels) {
        this.productDetailModels = productDetailModels;
    }

    public void setUpdateDatas(List<ProductDetailModel> productDetailModels) {
        this.productDetailModels.clear();
        this.productDetailModels = productDetailModels;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return productDetailModels.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return productDetailModels.size();
    }


}
