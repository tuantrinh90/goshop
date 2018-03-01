package com.goshop.app.utils;

import com.goshop.app.R;
import com.goshop.app.presentation.model.SortVM;
import com.goshop.app.widget.adapter.SortListAdapter;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import java.util.List;

public class PopWindowUtil {

    public static void showsSortListPop(View parentView, List<SortVM> sortVMS,
        OnSortPopDismissListener sortPopDismissListener) {
        View popView = LayoutInflater.from(parentView.getContext())
            .inflate(R.layout.layout_sort_pop, null);
        RecyclerView recyclerViewSortPop = popView.findViewById(R.id.recyclerview_sort_pop);
        LinearLayoutManager layoutManager = new LinearLayoutManager(parentView.getContext());
        recyclerViewSortPop.setLayoutManager(layoutManager);
        SortListAdapter sortListAdapter = new SortListAdapter(sortVMS);
        recyclerViewSortPop.setAdapter(sortListAdapter);
        PopupWindow popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        int[] location = new int[2];
        parentView.getLocationOnScreen(location);
        int height = parentView.getHeight();
        popupWindow.showAtLocation(parentView, Gravity.TOP | Gravity.LEFT, 0, location[1] + height);
        popupWindow.setOnDismissListener(() -> {
            sortPopDismissListener.onDismiss();
        });
        sortListAdapter.setOnSortListItemClickListener((int position) -> {
            popupWindow.dismiss();
            sortPopDismissListener.onPopItemClick(position);
        });

    }

    public static void showShoppingCartMenuPop(View parentView,
        OnCartItemMenuClickListener itemMenuClickListener) {
        View popView = LayoutInflater.from(parentView.getContext())
            .inflate(R.layout.layout_pop_shopping_cart_menu, null);

        LinearLayout llWishlist = popView.findViewById(R.id.ll_wishlist);
        LinearLayout llDelete = popView.findViewById(R.id.ll_delete);

        PopupWindow popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        int[] location = new int[2];
        parentView.getLocationOnScreen(location);
        popupWindow.showAtLocation(parentView, Gravity.TOP | Gravity.RIGHT, 0, location[1] - 12);
        llDelete.setOnClickListener(v -> {
            itemMenuClickListener.onCartDeleteClick();
            popupWindow.dismiss();
        });
        llWishlist.setOnClickListener(v -> {
            itemMenuClickListener.onCartWishlist();
            popupWindow.dismiss();
        });
    }

    public interface OnSortPopDismissListener {

        void onPopItemClick(int position);

        void onDismiss();
    }

    public interface OnCartItemMenuClickListener {

        void onCartWishlist();

        void onCartDeleteClick();
    }
}
