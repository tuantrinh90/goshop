package com.goshop.app.widget.adapter;

import com.goshop.app.R;
import com.goshop.app.presentation.model.widget.VideoProductsVM;
import com.goshop.app.widget.listener.OnProductBuyClickListener;
import com.goshop.app.widget.listener.OnProductItemClickListener;
import com.goshop.app.widget.viewholder.VideoProductItemViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class VideoProductItemAdapter extends RecyclerView.Adapter {

    private List<VideoProductsVM> allProductsVMS;

    private OnProductBuyClickListener buyClickListener;

    private List<VideoProductsVM> displayProductsVMS;

    private OnProductItemClickListener onProductItemClickListener;

    public VideoProductItemAdapter(
        List<VideoProductsVM> productsVMS, OnProductItemClickListener onProductItemClickListener,
        OnProductBuyClickListener buyClickListener) {
        this.allProductsVMS = productsVMS;
        displayProductsVMS = new ArrayList<>();
        this.onProductItemClickListener = onProductItemClickListener;
        this.buyClickListener = buyClickListener;
    }

    private View itemView;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_videoplayer_product, parent, false);
        return new VideoProductItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((VideoProductItemViewHolder) holder)
            .bindingData(displayProductsVMS.get(position), onProductItemClickListener,
                buyClickListener);
        itemView =  ((VideoProductItemViewHolder) holder).getItemView();
    }

    @Override
    public int getItemCount() {
        return displayProductsVMS.size();
    }

    public void updateProductList(boolean isExpand) {
        displayProductsVMS.clear();
        if (isExpand) {
            displayProductsVMS.addAll(allProductsVMS);
        } else {
            displayProductsVMS.add(allProductsVMS.get(0));
        }
        notifyDataSetChanged();
    }

    public int getItemMeasuredHeight(){
        return itemView.getMeasuredHeight();
    }


}
