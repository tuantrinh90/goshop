package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.common.CustomMinusPlusEditText;
import com.goshop.app.common.listener.IRecyclerItemClick;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.ShoppingCartApplyVM;
import com.goshop.app.presentation.model.ShoppingCartModel;
import com.goshop.app.presentation.model.ShoppingCartProductVM;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by helen on 2018/1/24.
 */

public class ShoppingCartAdapter extends RecyclerView.Adapter {

    private List<ShoppingCartModel> cartModels;

    IRecyclerItemClick iRecyclerItemClick;

    public void setiRecyclerItemClick(IRecyclerItemClick iRecyclerItemClick) {
        this.iRecyclerItemClick = iRecyclerItemClick;
    }

    public ShoppingCartAdapter(
        List<ShoppingCartModel> cartModels) {
        this.cartModels = cartModels;
    }

    public void setDatas(List<ShoppingCartModel> cartModels) {
        this.cartModels.clear();
        this.cartModels = cartModels;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;

        switch (viewType) {
            case ShoppingCartModel.CART_PRODUCT:
                View productView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_cart_product, parent, false);
                viewHolder = new ProductViewHolder(productView);
                break;
            case ShoppingCartModel.CART_CHECKOUT:
                View checkoutView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_cart_checkout, parent, false);
                viewHolder = new CheckoutViewHolder(checkoutView);
                break;
            case ShoppingCartModel.CART_APPLY:
                View applyView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_cart_apply, parent, false);
                viewHolder = new CheckoutViewHolder(applyView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ShoppingCartModel shoppingCartModel = cartModels.get(position);
        if (holder instanceof ProductViewHolder) {
            ((ProductViewHolder) holder).bindingData((ShoppingCartProductVM) shoppingCartModel);
        } else if (holder instanceof CheckoutViewHolder) {
            //TODO(helen) need decide
            if (iRecyclerItemClick!=null){
                iRecyclerItemClick.onItemClick(holder.itemView,0);
            }
        } else if (holder instanceof ApplyViewHolder) {
            ((ApplyViewHolder) holder).bindingData((ShoppingCartApplyVM) shoppingCartModel);
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

    class ProductViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cmp_et_count)
        CustomMinusPlusEditText cmpEtCount;

        @BindView(R.id.iv_item_cart_menu)
        ImageView ivItemCartMenu;

        @BindView(R.id.iv_item_cart_product)
        ImageView ivItemCartProduct;

        @BindView(R.id.tv_item_cart_color)
        CustomTextView tvItemCartColor;

        @BindView(R.id.tv_item_cart_now_price)
        CustomBoldTextView tvItemCartNowPrice;

        @BindView(R.id.tv_item_cart_old_price)
        CustomTextView tvItemCartOldPrice;

        @BindView(R.id.tv_item_cart_title)
        CustomTextView tvItemCartTitle;

        public ProductViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(ShoppingCartProductVM productVM) {
            tvItemCartTitle.setText(productVM.getTitle());
            tvItemCartColor.setText(productVM.getColor());
            tvItemCartOldPrice.setText(productVM.getOldPrice());
            tvItemCartOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            tvItemCartNowPrice.setText(productVM.getNowPrice());
            //TODO(helen) need decide
            cmpEtCount.setText(productVM.getCount() + "");
            cmpEtCount.setEditBackGround(android.R.color.transparent);
            cmpEtCount.setMinusBackGround(R.mipmap.minus_round);
            cmpEtCount.setPlusBackGround(R.mipmap.plus_round);
        }
    }

    class ApplyViewHolder extends RecyclerView.ViewHolder {

        public ApplyViewHolder(View itemView) {
            super(itemView);
        }

        void bindingData(ShoppingCartApplyVM applyVM) {

        }
    }

    class CheckoutViewHolder extends RecyclerView.ViewHolder {

        public CheckoutViewHolder(View itemView) {
            super(itemView);
        }
    }
}
