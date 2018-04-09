package com.goshop.app.widget.listener;

import com.goshop.app.presentation.model.CategoryLeftMenuVM;
import com.goshop.app.presentation.model.CategoryRightChildVM;

public interface OnCategoryItemClickListener {

    void onLeftClick(CategoryLeftMenuVM leftMenuVM);

    void onChildItemClick(CategoryRightChildVM childVM);
}
