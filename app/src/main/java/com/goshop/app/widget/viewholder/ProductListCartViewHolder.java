package com.goshop.app.widget.viewholder;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.CustomMPCartEditText;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.model.widget.ProductCartListVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.utils.GlideUtils;
import com.goshop.app.utils.NumberFormater;
import com.goshop.app.widget.listener.OnItemMenuClickListener;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductListCartViewHolder extends RecyclerView.ViewHolder {

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

    public ProductListCartViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindingData(ProductCartListVM cartListVM,
        OnItemMenuClickListener menuClickListener) {
        ProductsVM productsVM = cartListVM.getProductsVM();
        GlideUtils.loadImageError(
            itemView.getContext(),
            productsVM.getImage(),
            ivCartProductThumb,
            R.drawable.ic_bought);
        tvCartProductTitle.setText(productsVM.getTitle());
        //todo hard code wait for api
        tvProductCartAttr.setText("Color:Blue;Size:L");
        tvProductCartNow
            .setText(NumberFormater.formaterMoney(productsVM.getPriceVM().getRm().getDiscounted()));
        tvProductCartOld
            .setText(NumberFormater.formaterMoney(productsVM.getPriceVM().getRm().getOriginal()));
        tvProductCartOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        etProductCart.setText("3");
        etProductCart.setEditBackGround(android.R.color.transparent);
        etProductCart.setMinusBackGround(R.drawable.bg_rectangle_corner_black);
        etProductCart.setPlusBackGround(R.drawable.bg_rectangle_corner_black);
        llCartMenu.setOnClickListener(v -> menuClickListener.onItemMenuClick(llCartMenu, cartListVM));
    }
}
