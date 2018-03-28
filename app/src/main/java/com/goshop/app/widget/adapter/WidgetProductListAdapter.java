package com.goshop.app.widget.adapter;

import com.goshop.app.R;
import com.goshop.app.presentation.model.widget.ProductCartListVM;
import com.goshop.app.presentation.model.widget.ProductListModel;
import com.goshop.app.widget.listener.OnItemMenuClickListener;
import com.goshop.app.widget.viewholder.ProductListCartViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class WidgetProductListAdapter extends RecyclerView.Adapter {

    private List<ProductListModel> listModels;

    private OnItemMenuClickListener menuClickListener;

    public WidgetProductListAdapter(
        List<ProductListModel> productsVMS) {
        this.listModels = productsVMS;
    }

    public void setOnItemMenuClickListener(OnItemMenuClickListener menuClickListener) {
        this.menuClickListener = menuClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case ProductListModel.TYPE_SHOPPING_CART:
                View cartView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_widget_shopping_cart, parent, false);
                viewHolder = new ProductListCartViewHolder(cartView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ProductListModel listModel = listModels.get(position);
        if (holder instanceof ProductListCartViewHolder) {
            ((ProductListCartViewHolder) holder)
                .bindingData((ProductCartListVM) listModel, menuClickListener);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return listModels.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return listModels.size();
    }
}
