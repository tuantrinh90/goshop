package com.goshop.app.presentation.account;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.utils.NumberFormater;
import com.goshop.app.widget.listener.OnItemMenuClickListener;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyWishlistAdapter extends RecyclerView.Adapter {

    private OnItemMenuClickListener menuClickListener;

    private List<ProductsVM> productsVMS;

    public MyWishlistAdapter(
        List<ProductsVM> productsVMS) {
        this.productsVMS = productsVMS;
    }

    public void setUpdateDatas(List<ProductsVM> productsVMS) {
        this.productsVMS.clear();
        this.productsVMS = productsVMS;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_wishlist, parent, false);
        return new MyWishlistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyWishlistViewHolder) holder).bindingData(productsVMS.get(position), position);
    }

    @Override
    public int getItemCount() {
        return productsVMS.size();
    }

    public void setOnItemMenuClickListener(OnItemMenuClickListener menuClickListener) {
        this.menuClickListener = menuClickListener;
    }

    class MyWishlistViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_wishlist_menu)
        ImageView ivWishlistMenu;

        @BindView(R.id.iv_wishlist_thumb)
        ImageView ivWishlistThumb;

        @BindView(R.id.tv_wishlist_now)
        RobotoMediumTextView tvWishlistNow;

        @BindView(R.id.tv_wishlist_old)
        RobotoLightTextView tvWishlistOld;

        @BindView(R.id.tv_wishlist_title)
        RobotoLightTextView tvWishlistTitle;

        @BindView(R.id.view_wishlist_divider)
        View viewWishlistDivider;

        public MyWishlistViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(ProductsVM productsVM, int position) {
            viewWishlistDivider.setVisibility(position == 0 ? View.GONE : View.VISIBLE);
            ivWishlistMenu
                .setOnClickListener(v -> menuClickListener.onItemMenuClick(ivWishlistMenu));

            Glide.with(itemView.getContext()).load(productsVM.getImage()).asBitmap()
                .error(R.drawable.ic_bought)
                .into(ivWishlistThumb);
            tvWishlistNow
                .setText(
                    NumberFormater.formaterMoney(productsVM.getPriceVM().getRm().getDiscounted()));
            tvWishlistOld
                .setText(
                    NumberFormater.formaterMoney(productsVM.getPriceVM().getRm().getOriginal()));
            tvWishlistOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            tvWishlistTitle.setText(productsVM.getTitle());
        }
    }
}
