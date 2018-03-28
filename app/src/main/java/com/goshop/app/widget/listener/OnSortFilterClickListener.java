package com.goshop.app.widget.listener;

import com.goshop.app.presentation.model.SortVM;

import android.view.View;

import java.util.List;

public interface OnSortFilterClickListener {

    void onFilterClick(View view);

    void onSortClick(View view, List<SortVM> sortVMS);
}
