package com.goshop.app.utils;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.SortVM;
import com.goshop.app.presentation.model.widget.SingleChooseVM;
import com.goshop.app.widget.adapter.SingleChooseListAdapter;
import com.goshop.app.widget.adapter.SortListAdapter;

import android.app.DatePickerDialog;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import java.util.Calendar;
import java.util.List;

public class PopWindowUtil {

    public static final String CITY_POP = "city";

    public static final String COUNTRY_POP = "country";

    public static final String LANGUAGE_POP = "language";

    public static final String RACE_POP = "race";

    public static final String STATE_POP = "state";

    public static final String TITLE_POP = "title";

    public static void showsSortListPop(View parentView, List<SortVM> sortVMS,
        OnPopWindowDismissListener sortPopDismissListener) {
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
        popupWindow.showAtLocation(parentView, Gravity.TOP | Gravity.START, 0, location[1] + height);
        popupWindow.setOnDismissListener(sortPopDismissListener::onDismiss);
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
        popupWindow.showAtLocation(parentView, Gravity.TOP | Gravity.END, 0, location[1] - 12);
        llDelete.setOnClickListener(v -> {
            itemMenuClickListener.onCartDeleteClick();
            popupWindow.dismiss();
        });
        llWishlist.setOnClickListener(v -> {
            itemMenuClickListener.onCartWishlist();
            popupWindow.dismiss();
        });
    }

    public static void showSingleChoosePop(View parentView, String title,
        List<SingleChooseVM> singleChooseVMS,
        OnPopWindowDismissListener onPopWindowDismissListener) {
        View view = LayoutInflater.from(parentView.getContext())
            .inflate(R.layout.layout_pop_single_choose, null);
        RobotoMediumTextView tvTitle = view.findViewById(R.id.tv_single_dialog_title);
        tvTitle.setText(title);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_single_dialog);
        LinearLayoutManager layoutManager = new LinearLayoutManager(parentView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        SingleChooseListAdapter chooseListAdapter = new SingleChooseListAdapter(singleChooseVMS);
        recyclerView.setAdapter(chooseListAdapter);

        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(parentView, Gravity.CENTER, 0, 0);

        chooseListAdapter.setOnSingleChooseItemClickListener((position -> {
            onPopWindowDismissListener.onPopItemClick(position);
            popupWindow.dismiss();
        }));

    }

    public static void showInfoDisplayPop(View parentView, String info) {
        View view = LayoutInflater.from(parentView.getContext())
            .inflate(R.layout.layout_pop_info_display, null);
        RobotoRegularTextView tvTitle = view.findViewById(R.id.tv_pop_info);
        tvTitle.setText(info);

        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);

        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        int popupHeight = parentView.getMeasuredHeight();

        int[] location = new int[2];
        parentView.getLocationOnScreen(location);
        popupWindow.showAtLocation(parentView, Gravity.NO_GRAVITY, 0,
            location[1] - popupHeight - parentView.getMeasuredHeight()*3/2);
    }

    public static List<SingleChooseVM> updateSinglePopDatas(int position,
        List<SingleChooseVM> singleChooseVMS) {
        for (int i = 0; i < singleChooseVMS.size(); i++) {
            singleChooseVMS.get(i).setChoose(i == position);
        }
        return singleChooseVMS;
    }

    public static void showDatePickerDialog(View parentView,
        OnDatePickerDialogClickListener onDatePickerDialogClickListener) {
        final StringBuffer time = new StringBuffer();
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(parentView.getContext(),
            (DatePicker view, int pickYear, int monthOfYear,
                int dayOfMonth) -> {
                time.append(monthOfYear + 1).append("/").append(dayOfMonth).append("/")
                    .append(pickYear);
                onDatePickerDialogClickListener.onDatePicker(time.toString());
            }, year, month, day);
        datePickerDialog.show();
    }

    public interface OnDatePickerDialogClickListener {

        void onDatePicker(String time);
    }

    public interface OnPopWindowDismissListener {

        void onPopItemClick(int position);

        void onDismiss();
    }

    public interface OnCartItemMenuClickListener {

        void onCartWishlist();

        void onCartDeleteClick();
    }
}
