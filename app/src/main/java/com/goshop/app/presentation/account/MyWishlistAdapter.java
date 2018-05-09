package com.goshop.app.presentation.account;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.WishlistVM;
import com.goshop.app.utils.GlideUtils;
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

    private OnWishListItemClickListener onWishListItemClickListener;

    private List<WishlistVM> productsVMS;

    public MyWishlistAdapter(
        List<WishlistVM> productsVMS) {
        this.productsVMS = productsVMS;
    }

    public void setUpdateDatas(List<WishlistVM> productsVMS) {
        this.productsVMS.clear();
        this.productsVMS = productsVMS;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_wishlist, parent, false);
        return new MyWishlistViewHolder(view);
    }

    public void setOnWishListItemClickListener(
        OnWishListItemClickListener onWishListItemClickListener) {
        this.onWishListItemClickListener = onWishListItemClickListener;
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

        @BindView(R.id.tv_wishlist_percent)
        RobotoRegularTextView tvPersent;

        @BindView(R.id.view_wishlist_divider)
        View viewWishlistDivider;

        @BindView(R.id.tv_wishlist_attr)
        RobotoLightTextView tvWishlistAttr;

        public MyWishlistViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(WishlistVM wishlistVM, int position) {
            viewWishlistDivider.setVisibility(position == 0 ? View.GONE : View.VISIBLE);
            ivWishlistMenu
                .setOnClickListener(
                    v -> menuClickListener.onItemMenuClick(ivWishlistMenu, wishlistVM));

            Glide.with(itemView.getContext()).load(wishlistVM.getThumb()).asBitmap()
                .error(R.drawable.ic_image_404_small)
                .into(ivWishlistThumb);
            GlideUtils.loadImageError(
                itemView.getContext(),
                wishlistVM.getThumb(),
                ivWishlistThumb,
                R.drawable.ic_image_404_small);
            tvWishlistNow.setText(wishlistVM.getNowPrice());
            tvWishlistOld.setText(wishlistVM.getOldPrice());
            tvWishlistOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            tvWishlistTitle.setText(wishlistVM.getTitle());
            tvPersent.setText(wishlistVM.getPercent());
            itemView.setOnClickListener(v -> {
                if (onWishListItemClickListener != null) {
                    onWishListItemClickListener.onWishListClick(wishlistVM);
                }
            });
            tvWishlistAttr.setText(wishlistVM.getAttr());
        }
    }

    public interface OnWishListItemClickListener {

        void onWishListClick(WishlistVM wishlistVM);
    }
}
