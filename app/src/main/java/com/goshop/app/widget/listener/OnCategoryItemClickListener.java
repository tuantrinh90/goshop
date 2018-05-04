package com.goshop.app.widget.listener;

import com.goshop.app.presentation.model.CategoriesParentVM;
import com.goshop.app.presentation.model.CategoryRightChildVM;

public interface OnCategoryItemClickListener {

    void onLeftClick(CategoriesParentVM leftMenuVM);

    void onChildItemClick(CategoryRightChildVM childVM);
}
