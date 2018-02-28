package com.goshop.app.utils;

import com.goshop.app.R;

import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class PopWindowUtil {

    public static void showShoppingCartMenuPop(View parentView,
        OnCartItemMenuClickListener itemMenuClickListener) {
        View popView = LayoutInflater.from(parentView.getContext())
            .inflate(R.layout.layout_pop_shopping_cart_menu, null);

        LinearLayout llWishlist = popView.findViewById(R.id.ll_wishlist);
        LinearLayout llDelete = popView.findViewById(R.id.ll_delete);
        llDelete.setOnClickListener(v -> {
            itemMenuClickListener.onCartDeleteClick();
        });
        llWishlist.setOnClickListener(v -> {
            itemMenuClickListener.onCartWishlist();
        });
        PopupWindow popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        int[] location = new int[2];
        parentView.getLocationOnScreen(location);
        popupWindow.showAtLocation(parentView, Gravity.TOP | Gravity.RIGHT, 0, location[1] - 12);
    }

    public interface OnCartItemMenuClickListener {

        void onCartWishlist();

        void onCartDeleteClick();
    }
}
