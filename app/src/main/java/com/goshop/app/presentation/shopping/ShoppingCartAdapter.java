package com.goshop.app.presentation.shopping;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.CustomMPCartEditText;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.model.common.ProductVM;
import com.goshop.app.widget.listener.OnItemMenuClickListener;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShoppingCartAdapter extends RecyclerView.Adapter {

    private List<ProductVM> productVMS;

    private OnItemMenuClickListener menuClickListener;

    public ShoppingCartAdapter(
        List<ProductVM> productsVMS) {
        this.productVMS = productsVMS;
    }

    public void setProductVMS(List<ProductVM> productsVMS) {
        this.productVMS.clear();
        this.productVMS = productsVMS;
        notifyDataSetChanged();
    }

    public void setOnItemMenuClickListener(OnItemMenuClickListener menuClickListener) {
        this.menuClickListener = menuClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View cartView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.layout_widget_shopping_cart, parent, false);
        viewHolder = new CartViewHolder(cartView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ProductVM productVM = productVMS.get(position);
        ((CartViewHolder) holder)
            .bindingData((ProductVM) productVM, menuClickListener);
    }

    @Override
    public int getItemCount() {
        return productVMS.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.et_product_cart)
        CustomMPCartEditText etProductCart;

        @BindView(R.id.iv_cart_product_thumb)
        ImageView ivCartProductThumb;

        @BindView(R.id.ll_cart_menu)
        LinearLayout llCartMenu;

        @BindView(R.id.tv_cart_product_title)
        RobotoLightTextView tvCartProductTitle;

        @BindView(R.id.tv_product_cart_attr)
        RobotoLightTextView tvProductCartAttr;

        @BindView(R.id.tv_product_cart_now)
        RobotoMediumTextView tvProductCartNow;

        @BindView(R.id.tv_product_cart_old)
        RobotoLightTextView tvProductCartOld;

        @BindView(R.id.tv_cart_product_percent)
        RobotoMediumTextView tvCartProductPercent;

        public CartViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindingData(ProductVM productVM,
            OnItemMenuClickListener menuClickListener) {
            Glide.with(itemView.getContext()).load(productVM.getImage()).asBitmap()
                .error(productVM.getImageDefault())
                .into(ivCartProductThumb);
            tvCartProductTitle.setText(productVM.getTitle());
            tvProductCartAttr.setText(productVM.getAttribute());
            tvProductCartNow.setText(productVM.getNowPrice());
            tvProductCartOld.setText(productVM.getNowPrice());
            tvProductCartOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            etProductCart.setText(productVM.getAmount());
            etProductCart.setEditBackGround(android.R.color.transparent);
            etProductCart.setMinusBackGround(R.drawable.bg_rectangle_corner_black);
            etProductCart.setPlusBackGround(R.drawable.bg_rectangle_corner_black);
            llCartMenu
                .setOnClickListener(v -> menuClickListener.onItemMenuClick(llCartMenu, productVM));
            if (productVM.getPercent() != null && !TextUtils.isEmpty(productVM.getPercent())) {
                tvCartProductPercent.setVisibility(View.VISIBLE);
                tvCartProductPercent.setText(productVM.getPercent());
            } else {
                tvCartProductPercent.setVisibility(View.GONE);
            }
        }
    }


}
