package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.presentation.model.ShoppingCartApplyVM;
import com.goshop.app.presentation.model.ShoppingCartModel;
import com.goshop.app.presentation.model.ShoppingCartProductVM;
import com.goshop.app.presentation.model.widget.ProductCartBannerVM;
import com.goshop.app.widget.adapter.WidgetProductListAdapter;
import com.goshop.app.widget.listener.OnBannerItemClickListener;
import com.goshop.app.widget.listener.OnItemMenuClickListener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShoppingCartAdapter extends RecyclerView.Adapter {

    private List<ShoppingCartModel> cartModels;

    private OnItemMenuClickListener menuClickListener;

    private OnBannerItemClickListener onBannerItemClickListener;

    private OnCheckoutClickListener onCheckoutClickListener;

    public ShoppingCartAdapter(
        List<ShoppingCartModel> cartModels, OnCheckoutClickListener onCheckoutClickListener) {
        this.cartModels = cartModels;
        this.onCheckoutClickListener = onCheckoutClickListener;
    }

    public void setOnItemMenuClickListener(OnItemMenuClickListener menuClickListener) {
        this.menuClickListener = menuClickListener;
    }

    public void setDatas(List<ShoppingCartModel> cartModels) {
        this.cartModels.clear();
        this.cartModels = cartModels;
        notifyDataSetChanged();
    }

    public void setOnBannerItemClickListener(OnBannerItemClickListener onBannerItemClickListener) {
        this.onBannerItemClickListener = onBannerItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;

        switch (viewType) {
            case ShoppingCartModel.CART_BANNER:
                View bannerView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_widget_banner, parent, false);
                viewHolder = new ShoppingCartBannerViewHolder(bannerView);
                break;
            case ShoppingCartModel.CART_PRODUCT:
                View productView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_recyclerview, parent, false);
                viewHolder = new ProductViewHolder(productView);
                break;
            case ShoppingCartModel.CART_APPLY:
                View applyView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_cart_apply, parent, false);
                viewHolder = new ApplyViewHolder(applyView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ShoppingCartModel shoppingCartModel = cartModels.get(position);
        if (holder instanceof ProductViewHolder) {
            ((ProductViewHolder) holder)
                .bindingData((ShoppingCartProductVM) shoppingCartModel, menuClickListener);
        } else if (holder instanceof ApplyViewHolder) {
            ((ApplyViewHolder) holder).bindingData((ShoppingCartApplyVM) shoppingCartModel);
        } else if (holder instanceof ShoppingCartBannerViewHolder) {
            ((ShoppingCartBannerViewHolder) holder).bindingData(
                (ProductCartBannerVM) shoppingCartModel, onBannerItemClickListener);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return cartModels.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return cartModels.size();
    }

    interface OnCheckoutClickListener {

        void onCheckoutClick();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.recyclerview)
        RecyclerView recyclerView;

        public ProductViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(ShoppingCartProductVM cartProductVM,
            OnItemMenuClickListener menuClickListener) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
            recyclerView.setLayoutManager(layoutManager);
            WidgetProductListAdapter productListAdapter = new WidgetProductListAdapter(
                cartProductVM.getProductListModels());
            recyclerView.setAdapter(productListAdapter);
            productListAdapter.setOnItemMenuClickListener(menuClickListener);
        }
    }

    class ApplyViewHolder extends RecyclerView.ViewHolder {

        public ApplyViewHolder(View itemView) {
            super(itemView);
        }

        void bindingData(ShoppingCartApplyVM applyVM) {

        }
    }
}
